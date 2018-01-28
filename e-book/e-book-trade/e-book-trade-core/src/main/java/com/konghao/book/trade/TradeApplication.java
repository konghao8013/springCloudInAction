package com.konghao.book.trade;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@EnableEurekaClient
@EnableFeignClients
@SpringBootApplication
@MapperScan("com.konghao.book.trade.persistence")
public class TradeApplication {


	public static void main(String[] args) {
		SpringApplication.run(TradeApplication.class, args);
	}

}
