package com.boardgames_manager.bgmanager.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

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
    public ResponseEntity<UserCreationRequest> registration( @RequestBody UserCreationRequest userDto) {
        
        System.out.println("Trying to register new user...");
        userService.CreateUser(userDto);
        return new ResponseEntity<UserCreationRequest>(userDto, HttpStatus.OK);
    }
    
}
