package com.crewmeister.fxrate.provider;

import java.io.BufferedReader;
import java.io.StringReader;
import java.time.LocalDate;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import com.crewmeister.fxrate.entity.FxRate;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class FxRateProvider {

	@Value("${fx.rate.provider.api}")
	private String fxRateProviderApi;

	private final RestTemplate restTemplate;

	public FxRateProvider(RestTemplateBuilder builder) {
		this.restTemplate = builder.build();
	}

	public List<FxRate> getFxRates(String currency, String flowRef, String key) {
		return parseCSV(currency, getExchangeRatesInCSV(flowRef, key));
	}

	private List<FxRate> parseCSV(String currency, String csvOutput) {
		try (BufferedReader br = new BufferedReader(new StringReader(csvOutput))) {
			return br.lines()
					.skip(9)
					.filter(s -> !s.contains("No value available"))
					.map(s -> buildFxRate(s, currency))
					.collect(Collectors.toList());
		} catch (Exception e) {
			log.error("An exception occured in parsing fx rates csv for {}", currency);
			return Collections.emptyList();
		}
	}

	private String getExchangeRatesInCSV(String flowRef, String key) {		
		Map<String, String> params = new HashMap<>();
		params.put("detail", "dataonly");
		ResponseEntity<String> response = restTemplate.exchange(
				constructURI(flowRef, key), 
				HttpMethod.GET, 
				httpHeaders(),
				String.class, 
				params);
		return response.getStatusCode() == HttpStatus.OK ? response.getBody() : "";
	}

	private FxRate buildFxRate(String line, String currency) {
		String[] data = line.split(",");
		return FxRate.builder()
				.currency(currency)
				.rate(Double.valueOf(data[1]))
				.asOfDate(LocalDate.parse(data[0]))
				.build();
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private HttpEntity httpHeaders() {
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", "application/vnd.bbk.data+csv;version=1.0.0");
		headers.set("Accept-Language", "en-US");
		return new HttpEntity(headers);
	}

	private String constructURI(String flowRef, String key) {
		StringBuilder builder = new StringBuilder();
		builder
		.append(fxRateProviderApi)
		.append("/")
		.append(flowRef)
		.append("/")
		.append(key);
		return builder.toString();
	}

	public RestTemplate getRestTemplate() {
		return restTemplate;
	}

}
