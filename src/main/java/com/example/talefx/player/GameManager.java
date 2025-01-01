package com.example.talefx.player;

public class GameManager {
    private static final GameManager instance = new GameManager();
    private Player player;

    private GameManager() {
        player = new Player(); // Initialize the player once
    }

    public static GameManager getInstance() {
        return instance;
    }

    public Player getPlayer() {
        return player;
    }
}