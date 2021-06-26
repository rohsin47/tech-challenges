package com.crewmeister.fxrate.service;

import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.crewmeister.fxrate.TestUtils;
import com.crewmeister.fxrate.entity.FxRate;
import com.crewmeister.fxrate.repository.FxRateRepository;

@ExtendWith(MockitoExtension.class)
class EurFxRateServiceTest {

	@Mock
	FxRateRepository fxRateRepository;

	@InjectMocks
	EurFxRateService eurFxRateService;

	@Test
	void shouldGetCurrencies() {
		when(fxRateRepository.findAllDistinctCurrency()).thenReturn(Arrays.asList("USD", "CAD"));
		List<String> curr = eurFxRateService.getAvailableCurrencies();
		verify(fxRateRepository).findAllDistinctCurrency();
		assertThat(curr).isNotNull().hasSize(2).containsExactlyInAnyOrder("USD", "CAD");
	}

	@Test
	void shouldGetAllFxRates() {
		FxRate rate = TestUtils.buildFxRate("USD", "2021-05-05");
		when(fxRateRepository.findAll()).thenReturn(TestUtils.getFxRateIterable(rate));
		List<FxRate> rates = eurFxRateService.getAllFxRates();
		verify(fxRateRepository).findAll();
		assertThat(rates).isNotNull().hasSize(1).containsExactly(rate);
	}
	
	@Test
	void shouldGetFxRatesByDate() {
		FxRate rate = TestUtils.buildFxRate("USD", "2021-05-05");
		when(fxRateRepository.findAllByAsOfDate(any())).thenReturn(Arrays.asList(rate));
		List<FxRate> curr = eurFxRateService.getFxRatebyDate("2021-05-05");
		verify(fxRateRepository).findAllByAsOfDate(any());
		assertThat(curr).isNotNull().hasSize(1).containsExactly(rate);
	}
	
	@Test
	void shouldGetFxRatesByDateAndCurrency() {
		FxRate rate = TestUtils.buildFxRate("USD", "2021-05-05");
		when(fxRateRepository.findByAsOfDateAndCurrency(any(), anyString())).thenReturn(rate);
		List<FxRate> curr = eurFxRateService.getFxRateByDateAndCurrency("2021-05-05", "EUR");
		assertThat(curr).isNotNull().hasSize(1).containsExactly(rate);
	}
	
	@Test
	void shouldNotAnyFxRatesByDateAndCurrency() {
		when(fxRateRepository.findByAsOfDateAndCurrency(any(), anyString())).thenReturn(null);
		List<FxRate> curr = eurFxRateService.getFxRateByDateAndCurrency("2021-05-05", "INR");
		assertThat(curr).isNotNull();
	}
}