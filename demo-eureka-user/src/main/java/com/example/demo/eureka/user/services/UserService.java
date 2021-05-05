package com.example.demo.eureka.user.services;

import com.example.demo.eureka.user.dtos.Department;
import com.example.demo.eureka.user.dtos.ResponseUser;
import com.example.demo.eureka.user.entities.User;
import com.example.demo.eureka.user.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

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
        return userRepository.findById(id).get();
    }

    public ResponseUser getUserByDeparment(Long id) {
        ResponseUser responseUser = new ResponseUser();
        User user = userRepository.findById(id).get();
        responseUser.setUser(user);
        // without Eureka Server or API GATEWAY
        //Department department = restTemplate.getForObject("http://localhost:9001/departments/"+ user.getDepartmentId(), Department.class);

        // WITH Eureka Server or API GATEWAY
        Department department = restTemplate.getForObject("http://DEPARTMENT-SERVICE/departments/"+ user.getDepartmentId(), Department.class);
        responseUser.setDepartment(department);
        return responseUser;
    }

    public List<User> findAll() {
        return (List<User>) userRepository.findAll();
    }
}
