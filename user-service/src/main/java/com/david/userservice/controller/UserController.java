package com.david.userservice.controller;

import com.david.userservice.dto.ResponseTemplateVO;
import com.david.userservice.model.User;
import com.david.userservice.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService service;
    private final Logger logger = LoggerFactory.getLogger(UserController.class);

    @PostMapping("/saveUser")
    public User saveUser (@RequestBody User user){
        logger.info("Inside saveUser method of UserController");
        return service.saveUser(user);
    }

    @GetMapping("/getUser/{id}")
    public ResponseTemplateVO getUserWithDepartment(@PathVariable("id") Long userId){
        logger.info("Inside getUserWithDepartment method of UserController");
        return service.getUserWithDepartment(userId);
    }

//    @GetMapping("/getUser/{id}")
//    public Optional<User> findUserById(@PathVariable("id") Long userId){
//        logger.info("Inside findUserById method of DepartmentController");
//        return service.getUserRepo().findById(userId);
//    }
}
