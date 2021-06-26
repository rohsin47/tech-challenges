package com.crewmeister.fxrate.provider;

import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.crewmeister.fxrate.TestUtils;
import com.crewmeister.fxrate.entity.FxRate;
import com.crewmeister.fxrate.repository.FxRateRepository;

@ExtendWith(MockitoExtension.class)
class InMemoryFxRateLoaderTest {
	
	@Mock
	FxRateProvider fxRateProvider;
	
	@Mock
	FxRateRepository fxRateRepository;
	
	@Mock
	CountDownLatch countDownLatch;
	
	@Mock
	ConcurrentHashMap<String, List<FxRate>> store;
	
	@InjectMocks
	InMemoryFxRateLoader inMemoryFxRateLoader;
	
	@Test
	void testLoadFxRates() {
		FxRate rate = TestUtils.buildFxRate("USD", "2021-05-05");
		when(fxRateProvider.getFxRates(anyString(), anyString(), anyString())).thenReturn(Arrays.asList(rate));
		rate.setId(123);
		when(fxRateRepository.saveAll(any())).thenReturn(TestUtils.getFxRateIterable(rate));
		inMemoryFxRateLoader.loadFxRates();
		verify(fxRateProvider, times(10)).getFxRates(anyString(), anyString(), anyString());	
	}

}
