package com.crewmeister.fxrate.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

import com.crewmeister.fxrate.entity.FxRate;
import com.crewmeister.fxrate.repository.FxRateRepository;

import lombok.RequiredArgsConstructor;


@Component
@RequiredArgsConstructor
public class EurFxRateService implements FxRateService {

	private final FxRateRepository fxRateRepository;

	public List<String> getAvailableCurrencies() {
		return fxRateRepository.findAllDistinctCurrency();
	}

	public List<FxRate> getAllFxRates() {
		List<FxRate> result = new ArrayList<>();
		fxRateRepository.findAll().forEach(result::add);		
		return result;
	}

	public List<FxRate> getFxRatebyDate(String date) {
		return fxRateRepository.findAllByAsOfDate(LocalDate.parse(date));
	}

	public List<FxRate> getFxRateByDateAndCurrency(String date, String currency) {
		return Arrays.asList(fxRateRepository.findByAsOfDateAndCurrency(LocalDate.parse(date), currency));
	}

}
