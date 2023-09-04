package com.example.playerTracker.service;

import com.example.playerTracker.model.Player;

import java.util.List;

public interface PlayerService {
    List<Player> addPlayer(Player player);
    List<Player> updatePlayer(Long id, Player player);
    Player getPlayerById(Long id);
    List<Player> getAllPlayers();
    List<Player> getPlayersByTeam(String team);
    boolean updatePlayerTeam(Long id, String team);

}