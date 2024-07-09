package com.boardgames_manager.bgmanager.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.boardgames_manager.bgmanager.models.BoardGame;
import com.boardgames_manager.bgmanager.models.User;
import com.boardgames_manager.bgmanager.models.UserCreationRequest;
import com.boardgames_manager.bgmanager.repositories.UserRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
public class UserController {
    
    @Autowired
    private UserRepository user_repository_;

    @PostMapping("/users")
    public User SaveNewUser(@RequestBody UserCreationRequest userRequest) {
        User user = new User(userRequest.getName());
        return user_repository_.save(user);
    }
    

    @GetMapping("/users/{user_name}/games")
    List<BoardGame> DisplayUserGames(@PathVariable String user_name) {
        User user = user_repository_.findByName(user_name);

        if (user == null)
        {
            return null;
        }
        return user.getBoardGames();
    }
    
}
