package com.boardgames_manager.bgmanager.models;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="users")
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToMany
    @JoinTable(
        name= "user_games",
        joinColumns = @JoinColumn(name="user_id"),
        inverseJoinColumns = @JoinColumn(name="boardgame_id")
    )
    private List<BoardGame> boardGames;

    public User() {}

    public User(String name)
    {
        this.name = name;
    }

    public Long getId()
    {
        return this.id;
    }

    public String getName()
    {
        return this.name;
    }

    public List<BoardGame> getBoardGames()
    {
        return this.boardGames;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setBoardGames(List<BoardGame> boardGames)
    {
        this.boardGames = boardGames;
    }

    @Override
    public String toString()
    {
        String gamesStr = "";
        if(boardGames != null)
        {
            for (BoardGame boardGame : boardGames) {
                gamesStr += boardGame.toString();
            }
        }
        return "User: " + name + "has: " + gamesStr;
    }


}
