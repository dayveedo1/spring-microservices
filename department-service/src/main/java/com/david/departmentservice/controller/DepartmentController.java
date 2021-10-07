package com.david.departmentservice.controller;

import com.david.departmentservice.model.Department;
import com.david.departmentservice.service.DepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@Slf4j
@RequestMapping("/departments")
public class DepartmentController {

    @Autowired
    private DepartmentService service;
    private final Logger logger = LoggerFactory.getLogger(DepartmentController.class);

    @PostMapping("/saveDept")
    public Department saveDept (@RequestBody Department dept){
        logger.info("Inside saveDept method of DepartmentController");
        return service.saveDept(dept);
    }

    @GetMapping("/getDept/{id}")
    public Optional<Department> findDeptById(@PathVariable("id") Long Id){
        logger.info("Inside findDeptById method of DepartmentController");
        return service.getDepartmentRepo().findById(Id);
    }


}
