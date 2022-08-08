package com.mycompany.locationmanagementapi.controller;

import com.mycompany.locationmanagementapi.exception.BusinessException;
import com.mycompany.locationmanagementapi.model.UserModel;
import com.mycompany.locationmanagementapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/users")
    public ResponseEntity<Boolean> login(@RequestBody UserModel userModel) throws BusinessException{

        boolean result = userService.login(userModel);
        ResponseEntity<Boolean> responseEntity = new ResponseEntity<>(result, HttpStatus.OK);

        return responseEntity;
    }

    @PostMapping("/users/register")
    public ResponseEntity<Long> register(@RequestBody UserModel userModel) throws BusinessException{

        Long result = userService.register(userModel);
        ResponseEntity<Long> responseEntity = new ResponseEntity<>(result, HttpStatus.CREATED);

        return responseEntity;
    }
}

