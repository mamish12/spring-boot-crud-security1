package com.excellence.springbootcrudoperationwithsecurity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@EnableWebSecurity// add
public class SpringBootCrudOperationWithSecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootCrudOperationWithSecurityApplication.class, args);
	}

}
