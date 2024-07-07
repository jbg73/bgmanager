package com.boardgames_manager.bgmanager.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

enum DifficultyLevel {
    EASY, NORMAL, HARD
};


@Entity
@Table(name = "boardgames")
public class BoardGame {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private int no_players;
    private int duration; // in mins
    private DifficultyLevel difficulty;
    private String category; // todo: create categories instead of using string
    private float personal_rate;
    private String description;
    private String image_url; // todo: images should be stored in aws

    protected BoardGame() {}

    public BoardGame(int no_players, int duration, DifficultyLevel difficulty, String category,
            float personal_rate, String description, String image_url) {
        this.no_players = no_players;
        this.duration = duration;
        this.difficulty = difficulty;
        this.category = category;
        this.personal_rate = personal_rate;
        this.description = description;
        this.image_url = image_url;
    }
}
