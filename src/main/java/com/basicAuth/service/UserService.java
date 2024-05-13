package com.basicAuth.service;


import com.basicAuth.model.Login;
import com.basicAuth.model.UserModel;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    // register
    UserModel register(UserModel userModel);

    // login
     Authentication login(Login login);
}
