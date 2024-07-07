package com.boardgames_manager.bgmanager.repositories;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.boardgames_manager.bgmanager.models.BoardGame;

public interface BoardGameRepository extends CrudRepository<BoardGame, Long> {

    List<BoardGame> findByName(String name);
}
