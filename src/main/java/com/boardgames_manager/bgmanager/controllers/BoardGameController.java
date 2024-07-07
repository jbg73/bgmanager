package com.boardgames_manager.bgmanager.controllers;

import org.springframework.web.bind.annotation.RestController;
import com.boardgames_manager.bgmanager.repositories.BoardGameRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class BoardGameController {

    private final BoardGameRepository board_game_repository_;

    BoardGameController(BoardGameRepository repository){
        this.board_game_repository_ = repository;
    }

    @GetMapping("/board")
    public String getMethodName(@RequestParam String param) {
        return new String();
    }
    
}
