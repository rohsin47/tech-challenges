package com.crewmeister.fxrate;

import java.time.LocalDate;
import java.util.Iterator;

import org.springframework.http.MediaType;

import com.crewmeister.fxrate.entity.FxRate;

public class TestUtils {
	
	public static final MediaType APPLICATION_JSON_UTF8 = new MediaType(MediaType.APPLICATION_JSON.getType(), MediaType.APPLICATION_JSON.getSubtype());
	
	public static FxRate buildFxRate(String curr, String date) {
		return FxRate.builder().currency(curr).rate(3.46).asOfDate(LocalDate.parse(date)).build();
	}
	
	public static Iterable<FxRate> getFxRateIterable(FxRate rate) {
		return new Iterable<FxRate>() {
			@Override
			public Iterator<FxRate> iterator() {
				return new Iterator<FxRate>() {
					int i = 0;

					@Override
					public boolean hasNext() {
						while (i < 1) {
							return true;
						}
						return false;
					}

					@Override
					public FxRate next() {
						i++;
						return rate;
					}
				};
			}
		};
	}

}
