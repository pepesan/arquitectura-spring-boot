package com.example.demo.eureka.department.controller;

import com.example.demo.eureka.department.entity.Department;
import com.example.demo.eureka.department.service.DepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/departments")
@Slf4j
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/")
    public Department saveDepartment(@Valid @RequestBody Department department){
        log.info("saving department");
        return departmentService.save(department);
    }
    @GetMapping("/{id}")
    public Department getById(@PathVariable("id") Long id){
        log.info("get department by id in controller");
        return departmentService.getById(id);
    }
}
