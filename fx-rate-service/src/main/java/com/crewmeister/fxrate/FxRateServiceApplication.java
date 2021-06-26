package com.crewmeister.fxrate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = { "com.crewmeister.fxrate.repository" })
public class FxRateServiceApplication {	

	public static void main(String[] args) {
		SpringApplication.run(FxRateServiceApplication.class, args);
	}

}
