package com.crewmeister.fxrate.controller;

import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.anyString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import java.util.Arrays;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import com.crewmeister.fxrate.TestUtils;
import com.crewmeister.fxrate.service.EurFxRateService;

@ExtendWith(MockitoExtension.class)
class FxRateControllerTest {

	MockMvc mockMvc;

	@Mock
	EurFxRateService fxRateService;

	@Spy
	@InjectMocks
	FxRateController fxRateController;

	@BeforeEach
	public void before() {
		mockMvc = MockMvcBuilders.standaloneSetup(fxRateController)
				.setMessageConverters(new MappingJackson2HttpMessageConverter()).build();
	}

	@Test
	void shouldGetCurrencies() throws Exception {
		when(fxRateService.getAvailableCurrencies()).thenReturn(Arrays.asList("USD", "EUR"));
		mockMvc.perform(get("/api/v1/currencies").contentType(TestUtils.APPLICATION_JSON_UTF8))
				.andExpect(status().isOk()).andExpect(content().contentType(TestUtils.APPLICATION_JSON_UTF8))
				.andExpect(jsonPath("$", Matchers.containsInAnyOrder("USD", "EUR")));
	}

	@Test
	void shouldGetAllFxRates() throws Exception {
		when(fxRateService.getAllFxRates()).thenReturn(
				Arrays.asList(TestUtils.buildFxRate("USD", "2021-05-05"), TestUtils.buildFxRate("EUR", "2021-05-06")));
		mockMvc.perform(get("/api/v1/fxrate/all").contentType(TestUtils.APPLICATION_JSON_UTF8))
				.andExpect(status().isOk()).andExpect(content().contentType(TestUtils.APPLICATION_JSON_UTF8))
				.andExpect(jsonPath("$", Matchers.hasSize(2)));
	}
	
	@Test
	void shouldGetFxRateByDate() throws Exception {
		when(fxRateService.getFxRatebyDate(anyString())).thenReturn(
				Arrays.asList(TestUtils.buildFxRate("USD", "2021-05-05"), TestUtils.buildFxRate("EUR", "2021-05-05")));
		mockMvc.perform(get("/api/v1/fxrate/query?asOfDate=2021-05-05").contentType(TestUtils.APPLICATION_JSON_UTF8))
				.andExpect(status().isOk()).andExpect(content().contentType(TestUtils.APPLICATION_JSON_UTF8))
				.andExpect(jsonPath("$", Matchers.hasSize(2)));
	}
	
	@Test
	void shouldGetFxRateByDateAndCurrency() throws Exception {
		when(fxRateService.getFxRateByDateAndCurrency(anyString(), anyString())).thenReturn(
				Arrays.asList(TestUtils.buildFxRate("USD", "2021-05-05")));
		mockMvc.perform(get("/api/v1/fxrate/query?asOfDate=2021-05-05&currency=USD").contentType(TestUtils.APPLICATION_JSON_UTF8))
				.andExpect(status().isOk()).andExpect(content().contentType(TestUtils.APPLICATION_JSON_UTF8))
				.andExpect(jsonPath("$", Matchers.hasSize(1)));
	}

}
