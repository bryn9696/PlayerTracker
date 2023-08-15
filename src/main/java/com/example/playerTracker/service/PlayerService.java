package com.example.playerTracker.service;

import com.example.playerTracker.model.Player;

import java.util.List;

public interface PlayerService {
    List<Player> addPlayer(Player player);
    Player getPlayerById(Long id);
    List<Player> getAllPlayers();
    // Other methods if needed
}