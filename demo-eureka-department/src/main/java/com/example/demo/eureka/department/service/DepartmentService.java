package com.example.demo.eureka.department.service;

import com.example.demo.eureka.department.entity.Department;
import com.example.demo.eureka.department.repository.DepartmentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    public Department save(Department department) {
        log.info("saving department in service");
        return departmentRepository.save(department);
    }

    public Department getById(Long id) {
        log.info("get department by id in service");
        return departmentRepository.getOne(id);
    }
}
