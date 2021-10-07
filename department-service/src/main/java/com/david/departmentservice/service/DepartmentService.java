package com.david.departmentservice.service;

import com.david.departmentservice.model.Department;
import com.david.departmentservice.repo.DepartmentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class DepartmentService{

    @Autowired
    private DepartmentRepository departmentRepo;
    private final Logger logger = LoggerFactory.getLogger(DepartmentService.class);

    public DepartmentRepository getDepartmentRepo() {
        return departmentRepo;
    }

    public void setDepartmentRepo(DepartmentRepository departmentRepo) {
        this.departmentRepo = departmentRepo;
    }

    public Department saveDept(Department dept) {
        logger.info("Inside saveDept method of DepartmentService");
        return departmentRepo.save(dept);
    }

//    public Department findDeptById(Long id) {
//        logger.info("Inside findDeptById method of DepartmentService");
//        return departmentRepo.findById(id);
//    }

}
