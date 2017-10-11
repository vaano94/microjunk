package com.microtest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@EnableFeignClients
//@EnableConfigurationProperties
@Configuration
public class PaymentSenderApplication {

	public static void main(String[] args) {
		SpringApplication.run(PaymentSenderApplication.class, args);
	}
}
