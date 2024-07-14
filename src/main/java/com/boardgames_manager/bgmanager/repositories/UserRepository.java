package com.boardgames_manager.bgmanager.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.boardgames_manager.bgmanager.models.User;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByName(String name);

    Optional<User> findByEmail(String email);
}
