package com.microtest;

import com.microtest.notification.domain.Tweet;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import twitter4j.Status;

@SpringBootApplication
@EnableFeignClients
//@EnableConfigurationProperties
@EnableDiscoveryClient
@EnableScheduling
@EnableGlobalMethodSecurity(prePostEnabled = true)
@Configuration
public class PaymentSenderApplication {

	public static void main(String[] args) {
		SpringApplication.run(PaymentSenderApplication.class, args);
	}

	@Bean
	public ModelMapper modelMapper() {
		ModelMapper modelMapper = new ModelMapper();
		PropertyMap<Status, Tweet> personMap = new PropertyMap<Status, Tweet>() {
			protected void configure() {
				map().setContent(source.getText());
				map().setTweetDate(source.getCreatedAt());
				map().setUserName(source.getUser().getName());
			}
		};
		return modelMapper;
	}
}
