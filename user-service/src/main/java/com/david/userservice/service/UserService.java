package com.david.userservice.service;

import com.david.userservice.dto.Department;
import com.david.userservice.dto.ResponseTemplateVO;
import com.david.userservice.exception.RecordNotFoundException;
import com.david.userservice.model.User;
import com.david.userservice.repo.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.transaction.Transactional;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@Transactional
public class UserService {

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private RestTemplate responseTemplate;

    private final Logger logger = LoggerFactory.getLogger(UserService.class);

    public UserRepository getUserRepo() {
        return userRepo;
    }

    public void setUserRepo(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    public User saveUser(User user) {
        logger.info("Inside saveUser method of UserService");
        return userRepo.save(user);
    }

    public ResponseTemplateVO getUserWithDepartment(Long userId) {
        logger.info("Inside getUserWithDepartment method of UserService");
        ResponseTemplateVO rt = new ResponseTemplateVO();
        Optional<User> user = userRepo.findById(userId);
//        if(user.isPresent()){
//        Department dept = responseTemplate.getForObject("http://localhost:5001/departments/getDept/"+ user.get().getDepartmentId(), Department.class);
        Department dept = responseTemplate.getForObject("http://DEPARTMENT-SERVICE/departments/getDept/"+ user.get().getDepartmentId(), Department.class);

        rt.setUser(user.get());
        rt.setDepartment(dept);

        return rt;
//        }else (Exception){
//            return String.valueOf(Exception.class);
//        }
    }
}
