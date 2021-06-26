package com.crewmeister.fxrate.provider;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public final class FxRateProviderKeys {

	private FxRateProviderKeys() {
	}

	public static final String PROVIDER_FLOWREF = "BBEX3";

	private static final Map<String, String> PROVIDER_KEYS = new HashMap<>();

	static {
		PROVIDER_KEYS.put("AUD", "D.AUD.EUR.BB.AC.000");
		PROVIDER_KEYS.put("BGN", "D.BGN.EUR.BB.AC.000");
		PROVIDER_KEYS.put("BRL", "D.BRL.EUR.BB.AC.000");
		PROVIDER_KEYS.put("CAD", "D.CAD.EUR.BB.AC.000");
		PROVIDER_KEYS.put("CNY", "D.CNY.EUR.BB.AC.000");
		PROVIDER_KEYS.put("CYP", "D.CYP.EUR.BB.AC.000");
		PROVIDER_KEYS.put("CZK", "D.CZK.EUR.BB.AC.000");
		PROVIDER_KEYS.put("DKK", "D.DKK.EUR.BB.AC.000");
		PROVIDER_KEYS.put("EEK", "D.EEK.EUR.BB.AC.000");
		PROVIDER_KEYS.put("GBP", "D.GBP.EUR.BB.AC.000");
	}

	public static List<String> getAvailableCurrencies() {
		return PROVIDER_KEYS.keySet().stream().collect(Collectors.toList());
	}

	public static String getTimeSeriesKeyForCurrency(String curr) {
		return PROVIDER_KEYS.get(curr);
	}

}
