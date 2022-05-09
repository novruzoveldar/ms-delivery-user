package com.guavapay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MsDeliveryUserApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsDeliveryUserApplication.class, args);
	}

}
