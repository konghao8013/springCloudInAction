package com.konghao.eureka.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.annotation.Bean;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;

@EnableEurekaClient
@SpringBootApplication
public class ConsumerApplication {

/*	@Bean
	public IRule ribbonRule() {
		return new RandomRule();
	}
*/
	public static void main(String[] args) {
		SpringApplication.run(ConsumerApplication.class, args);

	}
}
