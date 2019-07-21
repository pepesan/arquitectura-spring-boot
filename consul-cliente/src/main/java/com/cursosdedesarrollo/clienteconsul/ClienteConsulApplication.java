package com.cursosdedesarrollo.clienteconsul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ClienteConsulApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClienteConsulApplication.class, args);
	}

}
