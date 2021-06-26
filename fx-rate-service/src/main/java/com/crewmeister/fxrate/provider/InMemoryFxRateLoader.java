package com.crewmeister.fxrate.provider;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CountDownLatch;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.crewmeister.fxrate.entity.FxRate;
import com.crewmeister.fxrate.repository.FxRateRepository;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class InMemoryFxRateLoader implements FxRateLoader {

	private final FxRateProvider fxRateProviderService;
	private final FxRateRepository fxRateRepository;
	private final CountDownLatch countDownLatch;
	private final ConcurrentMap<String, List<FxRate>> store;

	@Autowired
	public InMemoryFxRateLoader(FxRateProvider fxRateProviderService, FxRateRepository fxRateRepository) {
		this.fxRateProviderService = fxRateProviderService;
		this.fxRateRepository = fxRateRepository;
		this.countDownLatch = new CountDownLatch(FxRateProviderKeys.getAvailableCurrencies().size());
		this.store = new ConcurrentHashMap<>();
	}

	@Override
	@PostConstruct
	public void loadFxRates() {
		try {
			FxRateProviderKeys.getAvailableCurrencies().stream().forEach(this::callProviderAndLoad);
			countDownLatch.await();
			if(!store.isEmpty()) {
				store.values().forEach(fxRateRepository::saveAll);
				store.clear();
			}			
		} catch (InterruptedException e) {
			log.error("An exception occured in loading fx rates", e);
			Thread.currentThread().interrupt();
		}
	}

	private void callProviderAndLoad(String entry) {
		new Thread(() -> {
			List<FxRate> fxRates = fxRateProviderService.getFxRates(entry, 
					FxRateProviderKeys.PROVIDER_FLOWREF,
					FxRateProviderKeys.getTimeSeriesKeyForCurrency(entry));
			log.info("Loaded {} fx rates records for {}", fxRates.size(), entry);
			store.putIfAbsent(entry, fxRates);
			countDownLatch.countDown();
		}).start();
	}

	public ConcurrentMap<String, List<FxRate>> getStore() {
		return store;
	}

}
