package com.microtest.auth;

import com.microtest.auth.domain.Role;
import com.microtest.auth.domain.User;
import com.microtest.auth.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

//@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class AuthApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuthApplication.class, args);
	}

	@Bean
	CommandLineRunner init(
			UserService userService
	) {
		return (evt) -> Arrays.asList(
				"user,admin,john,robert,ana".split(",")).forEach(
				username -> {
					User acct = new User();
					acct.setUsername(username);
					acct.setPassword("password");
					acct.grantAuthority(Role.ROLE_USER);
					if (username.equals("admin"))
						acct.grantAuthority(Role.ROLE_ADMIN);
					userService.registerUser(acct);
				}
		);
	}
}

