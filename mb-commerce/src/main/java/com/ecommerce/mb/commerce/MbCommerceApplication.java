package com.ecommerce.mb.commerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = {"com.ecommerce.mb.commons.models.entity"})
public class MbCommerceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MbCommerceApplication.class, args);
	}

}
