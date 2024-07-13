package com.boardgames_manager.bgmanager.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.boardgames_manager.bgmanager.models.UserCreationRequest;
import com.boardgames_manager.bgmanager.services.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class AuthenticationController {
    
    private UserService userService;

    public AuthenticationController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<?> Registration( @RequestBody UserCreationRequest userDto) {
        if (userService.CheckUserExist(userDto))
        {
            return new ResponseEntity<>("There is already an account registered with the same email", HttpStatus.BAD_REQUEST);
        }

        userService.CreateUser(userDto);
        return new ResponseEntity<UserCreationRequest>(userDto, HttpStatus.OK);
    }

    
    
}
