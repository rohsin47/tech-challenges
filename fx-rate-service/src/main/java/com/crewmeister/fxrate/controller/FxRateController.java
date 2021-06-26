package com.crewmeister.fxrate.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.crewmeister.fxrate.entity.FxRate;
import com.crewmeister.fxrate.service.EurFxRateService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class FxRateController {

	private final EurFxRateService fxRateService;

	@GetMapping("/v1/currencies")
	public ResponseEntity<List<String>> getAllAvailableCurrencies() {
		return ResponseEntity.ok(fxRateService.getAvailableCurrencies());
	}

	@GetMapping("/v1/fxrate/all")
	public ResponseEntity<List<FxRate>> getAllEurFxRates() {
		return ResponseEntity.ok(fxRateService.getAllFxRates());
	}

	@GetMapping("/v1/fxrate/query")
	public ResponseEntity<List<FxRate>> get(
			@RequestParam(name = "asOfDate", required = true) String asOfDate, 
			@RequestParam(name = "currency", required = false) String currency) {		
		if(currency == null) {
			return ResponseEntity.ok(fxRateService.getFxRatebyDate(asOfDate));
		} 
		return ResponseEntity.ok(fxRateService.getFxRateByDateAndCurrency(asOfDate, currency));
	}

}
