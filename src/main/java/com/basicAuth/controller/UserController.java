package com.basicAuth.controller;


import com.basicAuth.model.Login;
import com.basicAuth.serviceImpl.UserServiceImpl;
import com.basicAuth.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserServiceImpl userServiceImpl;

    // register
    @PostMapping("/register")
    private ResponseEntity<?> Register(@RequestBody UserModel userModel){
        UserModel user=userServiceImpl.register(userModel);
        if(user!=null){
            return ResponseEntity.ok("Registered successfully");
        }
        else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("not registered successfully");
        }
    }

    // login
    @PostMapping("/login")
    public ResponseEntity<?>login(@RequestBody Login login){
        Authentication auth=userServiceImpl.login(login);
        if(auth!=null){
            return ResponseEntity.ok("login");
        }
        else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("not login");
        }
    }


}
