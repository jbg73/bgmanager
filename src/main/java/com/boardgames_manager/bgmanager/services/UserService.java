package com.boardgames_manager.bgmanager.services;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.boardgames_manager.bgmanager.models.User;
import com.boardgames_manager.bgmanager.dtos.UserLoginDto;
import com.boardgames_manager.bgmanager.dtos.UserRegisterDto;
import com.boardgames_manager.bgmanager.repositories.UserRepository;

@Service
public class UserService {

    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;
    private AuthenticationManager authenticationManager;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder,
            AuthenticationManager authenticationManager) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
    }

    public User Signup(UserRegisterDto userDto) {
        User user = ConvertUserDtoToUserEntity(userDto);

        return userRepository.save(user);
    }

    public User Authenticate(UserLoginDto userLoginDto) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(userLoginDto.getEmail(), userLoginDto.getPassword()));

        return userRepository.findByEmail(userLoginDto.getEmail()).orElseThrow();
    }

    public Boolean CheckUserExist(UserRegisterDto userDto) {
        User user = ConvertUserDtoToUserEntity(userDto);
        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            return true;
        }

        return false;
    }

    private User ConvertUserDtoToUserEntity(UserRegisterDto userDto) {
        User user = new User();
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));

        return user;
    }
}
