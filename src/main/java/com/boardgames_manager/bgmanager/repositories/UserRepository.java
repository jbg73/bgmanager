package com.boardgames_manager.bgmanager.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.boardgames_manager.bgmanager.models.User;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByName(String name);

    User findByEmail(String email);
}
