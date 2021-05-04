package com.example.demo.eureka.department.controller;

import com.example.demo.eureka.department.entity.Department;
import com.example.demo.eureka.department.service.DepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/departments")
@Slf4j
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    @GetMapping("/")
    public List<Department> getAll(){
        log.info("get department by id in controller");
        return departmentService.findAll();
    }
    @PostMapping("/")
    public Department saveDepartment(@Valid @RequestBody Department department){
        log.info("saving department");
        Department savedItem=departmentService.save(department);
        log.info(String.valueOf(savedItem));
        System.out.println(String.valueOf(savedItem));
        return savedItem;
    }
    @GetMapping("/{id}")
    public Department getById(@PathVariable Long id){
        log.info("get department by id in controller");
        return departmentService.getById(id).get();
    }
}
