package com.cursosdedesarrollo.consulclienterest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class ConsulClienteRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConsulClienteRestApplication.class, args);
	}

}
