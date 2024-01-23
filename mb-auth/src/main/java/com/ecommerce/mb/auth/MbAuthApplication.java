package com.ecommerce.mb.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = {"com.ecommerce.mb.commons.models.entity","com.ecommerce.mb.auth.models.entity"})
public class MbAuthApplication {

	public static void main(String[] args) {
		SpringApplication.run(MbAuthApplication.class, args);
	}

}
