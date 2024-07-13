package com.boardgames_manager.bgmanager.services;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.boardgames_manager.bgmanager.models.User;
import com.boardgames_manager.bgmanager.models.UserCreationRequest;
import com.boardgames_manager.bgmanager.repositories.UserRepository;

@Service
public class UserService {
    
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder)
    {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void CreateUser(UserCreationRequest userDto)
    {
        User user = ConvertUserDtoToUserEntity(userDto);

        userRepository.save(user);
    }

    public Boolean CheckUserExist(UserCreationRequest userDto)
    {
        User user = ConvertUserDtoToUserEntity(userDto);
        if (userRepository.findByEmail(user.getEmail()) != null)
        {
            return true;
        }

        return false;
    }

    private User ConvertUserDtoToUserEntity(UserCreationRequest userDto)
    {
        User user = new User();
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));

        return user;
    }
}
