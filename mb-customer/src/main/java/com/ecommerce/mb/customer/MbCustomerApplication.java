package com.ecommerce.mb.customer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = {"com.ecommerce.mb.commons.models.entity"})
public class MbCustomerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MbCustomerApplication.class, args);
	}

}
