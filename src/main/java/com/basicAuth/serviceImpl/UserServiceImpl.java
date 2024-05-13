package com.basicAuth.serviceImpl;


import com.basicAuth.model.Login;
import com.basicAuth.service.UserService;
import com.basicAuth.model.UserModel;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.basicAuth.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserModel register(UserModel userModel) {
        // encode the plain text coming from json to bcrypt type password and then save in our database
        userModel.setPassword(passwordEncoder.encode(userModel.getPassword()));
        UserModel user=userRepository.save(userModel);
        return user;
    }

    @Autowired
    private AuthenticationManager authenticationManager;
    @Override
    public Authentication login(@NonNull Login login) {
             Authentication authentication=authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                     login.getEmail(),login.getPassword()
             ));
             return authentication;
    }
}
