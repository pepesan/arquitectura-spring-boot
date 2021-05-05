package com.example.demo.service.resilence4j;

import reactor.core.publisher.Mono;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@SpringBootApplication
public class DemoServiceResilence4jApplication {
	@RequestMapping(value = "/recommended")
	public Mono<String> ingredientsList(){
		return Mono.just("Onions, Potatoes, Celery, Carrots");
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoServiceResilence4jApplication.class, args);
	}

}
