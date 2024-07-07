package com.boardgames_manager.bgmanager.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.boardgames_manager.bgmanager.models.BoardGame;
import com.boardgames_manager.bgmanager.repositories.BoardGameRepository;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
public class BoardGameController {

    private final BoardGameRepository board_game_repository_;

    BoardGameController(BoardGameRepository repository){
        this.board_game_repository_ = repository;
    }

    @GetMapping("/boards")
    List<BoardGame> all() {
        List<BoardGame> found_games = board_game_repository_.findAll();

        for (BoardGame bg : found_games) {
            System.out.println(bg.toString());
        }
        return found_games;
    }

    @PostMapping("/boards")
    BoardGame StoreGame(@RequestBody BoardGame board_game) {
        return board_game_repository_.save(board_game);
    }
    
    
}
