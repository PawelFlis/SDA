package com.example.SDA;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SoftDevelopmentAdventuresApplication {

	public static void main(String[] args) {
		SpringApplication.run(SoftDevelopmentAdventuresApplication.class, args);
	}

}
