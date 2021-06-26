package com.crewmeister.fxrate.provider;

import static org.mockito.Mockito.when;

import java.util.List;

import static org.mockito.Mockito.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyMap;
import static org.mockito.ArgumentMatchers.anyString;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.web.client.RestTemplate;
import com.crewmeister.fxrate.entity.FxRate;

@ExtendWith(MockitoExtension.class)
class FxRateProviderTest {
	
	FxRateProvider fxRateProvider;
	
	RestTemplate restTemplate;
	
	@BeforeEach
	void before() {
		fxRateProvider = new FxRateProvider(Mockito.mock(RestTemplateBuilder.class));
		restTemplate = Mockito.mock(RestTemplate.class);
		ReflectionTestUtils.setField(fxRateProvider, "restTemplate", restTemplate);
	}
	
	@Test
	void shouldHaveRestTemplate() {
		assertThat(fxRateProvider.getRestTemplate()).isNotNull();
	}
	
	@Test
	void shouldGetFxRatesFromProviderService() {
		String out = "Euro foreign exchange reference rate of the ECB / EUR 1 = DKK ... / Denmark,,\n"
				+ "Euro foreign exchange reference rate of the ECB / EUR 1 = DKK ... / Denmark,\n"
				+ "daily euro reference exchange rates published by the ECB.,\n"
				+ "daily euro reference exchange rates published by the ECB.,\n"
				+ "Source (in english),European Central Bank (ECB).,,European Central Bank (ECB).,\n"
				+ "Time format code,P1M,,P1M,\n"
				+ "unit,DKK,,DKK,\n"
				+ "unit multiplier,,,,\n"
				+ "last update,2021-04-30 16:06:44,,2021-04-30 16:06:44,\n"
				+ "1999-01-07, 7.4359,";
		ResponseEntity<String> res = ResponseEntity.ok(out);
		when(restTemplate.exchange(anyString(), 
				eq(HttpMethod.GET), 
				any(),
				eq(String.class), 
				anyMap())).thenReturn(res);
		
		List<FxRate> result = fxRateProvider.getFxRates("DKK", "FLOWREF", "TestKey");
		
		verify(restTemplate).exchange(anyString(), 
				eq(HttpMethod.GET), 
				any(),
				eq(String.class), 
				anyMap());
		assertThat(result).isNotNull().isNotEmpty().hasSize(1);		
	}

}
