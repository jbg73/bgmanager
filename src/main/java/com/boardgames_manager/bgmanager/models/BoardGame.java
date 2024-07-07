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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    public Long getId()
    {
        return this.id;
    }

    public String getName()
    {
        return this.name;
    }

    public int getNoPlayers()
    {
        return this.no_players;
    }

    public int getDuration()
    {
        return this.duration;
    }

    public DifficultyLevel getDifficultyLevel()
    {
        return this.difficulty;
    }

    public String getCategory()
    {
        return this.category;
    }

    public float getPersonalRate()
    {
        return this.personal_rate;
    }

    public String getDescription()
    {
        return this.description;
    }

    public String getImageUrl()
    {
        return this.image_url;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setNoPlayers(int no_players)
    {
        this.no_players = no_players;
    }

    public void setDuration(int duration)
    {
        this.duration = duration;
    }

    public void setDifficultyLevel(DifficultyLevel difficulty)
    {
        this.difficulty = difficulty;
    }

    public void setCategory(String category)
    {
        this.category = category;
    }

    public void setPersonalRate(float personal_rate)
    {
        this.personal_rate = personal_rate;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public void setImageUrl(String image_url)
    {
        this.image_url = image_url;
    }

    @Override
    public String toString()
    {
        return "BoardGame{" + "id=" + this.id + ", name=" + this.name + ", no_players" + this.no_players;
    }

}
