package com.crewmeister.fxrate.entity;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Table(name = "FX_RATE", uniqueConstraints = @UniqueConstraint(columnNames = { "currency", "as_of_date" }))
@Entity
@Data
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class FxRate implements Serializable {

	@Id
	@GeneratedValue
	@JsonIgnore
	private Integer id;

	@Column(nullable = false)
	private String currency;

	@Column(nullable = false)
	private Double rate;

	@Column(nullable = false, name = "as_of_date")
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate asOfDate;

}
