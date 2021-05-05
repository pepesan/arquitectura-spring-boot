package com.example.demo.service.resilence4j.client;


import org.springframework.cloud.circuitbreaker.resilience4j.ReactiveResilience4JCircuitBreakerFactory;
import org.springframework.cloud.client.circuitbreaker.ReactiveCircuitBreaker;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;


@Service
public class IngredientsService {
    private WebClient webClient = null;
    private ReactiveCircuitBreaker readingListCircuitBreaker= null;
    public IngredientsService(ReactiveResilience4JCircuitBreakerFactory reactiveResilience4JCircuitBreakerFactory) {
        this.webClient = WebClient.builder().baseUrl("http://localhost:8090").build();
        this.readingListCircuitBreaker = reactiveResilience4JCircuitBreakerFactory.create("recommended");
    }

    public Mono<String> getData() {
        return readingListCircuitBreaker.run(webClient.get().uri("/recommended").retrieve().bodyToMono(String.class), throwable -> {
            return Mono.just("Onions");
        });
    }
}
