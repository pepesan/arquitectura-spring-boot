package com.example.demo.eureka.department.service;

import com.example.demo.eureka.department.entity.Department;
import com.example.demo.eureka.department.repository.DepartmentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    public Department save(Department department) {
        log.info("saving department in service");
        return departmentRepository.save(department);
    }

    public Optional<Department> getById(Long id) {
        log.info("get department by id in service");
        Department department = new Department();
        return departmentRepository.findById(id);
        //return department;
    }

    public List<Department> findAll() {
        return (List<Department>) departmentRepository.findAll();
    }
}
