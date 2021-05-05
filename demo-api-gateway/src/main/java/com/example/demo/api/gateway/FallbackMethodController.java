package com.example.demo.api.gateway;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallbackMethodController {
    @GetMapping("/userServiceFallback")
    public String userServiceFallbackMethod(){
        return "User Service if OFF";
    }
    @GetMapping("/departmentServiceFallback")
    public String departmentServiceFallbackMethod(){
        return "Department Service if OFF";
    }
}
