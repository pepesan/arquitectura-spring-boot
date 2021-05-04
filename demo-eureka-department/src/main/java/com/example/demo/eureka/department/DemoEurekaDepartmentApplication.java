package com.example.demo.eureka.department;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class DemoEurekaDepartmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoEurekaDepartmentApplication.class, args);
	}

}
