package com.boardgames_manager.bgmanager.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.boardgames_manager.bgmanager.models.BoardGame;

public interface BoardGameRepository extends JpaRepository<BoardGame, Long> {

    BoardGame findByName(String name);
}
