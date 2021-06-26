package com.crewmeister.fxrate.service;

import java.util.List;
import com.crewmeister.fxrate.entity.FxRate;

public interface FxRateService {

	List<String> getAvailableCurrencies();

	List<FxRate> getAllFxRates();

	List<FxRate> getFxRatebyDate(String date);

	List<FxRate> getFxRateByDateAndCurrency(String date, String currency);

}
