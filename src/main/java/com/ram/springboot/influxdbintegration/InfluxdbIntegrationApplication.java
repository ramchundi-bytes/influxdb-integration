package com.ram.springboot.influxdbintegration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class InfluxdbIntegrationApplication {

	public static void main(String[] args) {
		SpringApplication.run(InfluxdbIntegrationApplication.class, args);
	}

}
