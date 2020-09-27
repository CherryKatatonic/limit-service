package com.katgrennan.currencyexchange.limitservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

// Simple instance limiting service
@SpringBootApplication
// Enable discovery for Eureka naming server
@EnableDiscoveryClient
// Enable Hystrix for fault tolerance
@EnableHystrix
public class LimitServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(LimitServiceApplication.class, args);
	}

}
