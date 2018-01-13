package com.konghao.hystrix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

@SpringBootApplication
@EnableTurbine
public class HystrixTurbineApplication {
	// http://localhost:9000/hystrix.stream
	public static void main(String[] args) {
		SpringApplication.run(HystrixTurbineApplication.class, args);
	}
}
