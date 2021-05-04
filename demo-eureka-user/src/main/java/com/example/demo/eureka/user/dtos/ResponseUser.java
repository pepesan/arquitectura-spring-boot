package com.example.demo.eureka.user.dtos;

import com.example.demo.eureka.user.entities.User;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ResponseUser {
        private User user;
        private Department department;
}
