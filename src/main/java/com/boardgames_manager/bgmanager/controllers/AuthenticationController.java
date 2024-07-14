package com.boardgames_manager.bgmanager.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.boardgames_manager.bgmanager.dtos.LoginResponseDto;
import com.boardgames_manager.bgmanager.dtos.UserLoginDto;
import com.boardgames_manager.bgmanager.dtos.UserRegisterDto;
import com.boardgames_manager.bgmanager.models.User;
import com.boardgames_manager.bgmanager.services.JwtService;
import com.boardgames_manager.bgmanager.services.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class AuthenticationController {

    private UserService userService;
    private JwtService jwtService;

    public AuthenticationController(UserService userService, JwtService jwtService) {
        this.userService = userService;
        this.jwtService = jwtService;
    }

    @PostMapping("/auth/signup")
    public ResponseEntity<?> Signup(@RequestBody UserRegisterDto userDto) {
        if (userService.CheckUserExist(userDto)) {
            return new ResponseEntity<>("There is already an account registered with the same email",
                    HttpStatus.BAD_REQUEST);
        }

        userService.Signup(userDto);
        return new ResponseEntity<UserRegisterDto>(userDto, HttpStatus.OK);
    }

    @PostMapping("/auth/login")
    public ResponseEntity<LoginResponseDto> Login(@RequestBody UserLoginDto userLoginDto) {

        User authenticatedUser = userService.Authenticate(userLoginDto);

        String jwtToken = jwtService.GenerateToken(authenticatedUser);

        LoginResponseDto loginResponse = new LoginResponseDto();
        loginResponse.setToken(jwtToken);
        loginResponse.setExpiresIn(jwtService.getExpirationTime());

        return ResponseEntity.ok(loginResponse);
    }

}
