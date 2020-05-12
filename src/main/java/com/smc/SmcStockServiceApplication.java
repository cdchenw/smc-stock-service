package com.smc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class SmcStockServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SmcStockServiceApplication.class, args);
	}

}
