package com.ecommerce.mb.payment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = {"com.ecommerce.mb.commons.models.entity"})
public class MbPaymentApplication {

	public static void main(String[] args) {
		SpringApplication.run(MbPaymentApplication.class, args);
	}

}
