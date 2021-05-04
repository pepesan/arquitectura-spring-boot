package com.example.demo.eureka.user.services;

import com.example.demo.eureka.user.dtos.Department;
import com.example.demo.eureka.user.dtos.ResponseUser;
import com.example.demo.eureka.user.entities.User;
import com.example.demo.eureka.user.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    public User save(User user) {
        return userRepository.save(user);
    }

    public User getById(Long id) {
        return userRepository.getOne(id);
    }

    public ResponseUser getUserByDeparment(Long id) {
        ResponseUser responseUser = new ResponseUser();
        User user = userRepository.getOne(id);
        responseUser.setUser(user);
        Department department = restTemplate.getForObject("http://localhost:9001/departments/"+ user.getDepartmentId(), Department.class);
        responseUser.setDepartment(department);
        return responseUser;
    }
}
