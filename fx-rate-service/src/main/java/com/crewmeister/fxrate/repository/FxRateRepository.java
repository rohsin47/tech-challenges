package com.crewmeister.fxrate.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.crewmeister.fxrate.entity.FxRate;

@Repository
public interface FxRateRepository extends CrudRepository<FxRate, Integer> {

	@Query("Select distinct f.currency from FxRate f")
	List<String> findAllDistinctCurrency();

	List<FxRate> findAllByAsOfDate(LocalDate asOfDate);

	List<FxRate> findAllByCurrency(String currency);

	FxRate findByAsOfDateAndCurrency(LocalDate asOfDate, String currency);

}
