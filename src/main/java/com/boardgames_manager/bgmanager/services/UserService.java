package com.boardgames_manager.bgmanager.services;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.boardgames_manager.bgmanager.repositories.UserRepository;

@Service
public class UserService {
    
    private UserRepository userRepository;
    private PasswordEncoder passwordEndoEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder)
    {
        this.userRepository = userRepository;
        this.passwordEndoEncoder = passwordEncoder;
    }
}
