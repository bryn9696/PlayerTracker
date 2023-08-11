package com.example.playerTracker.service;

import com.example.playerTracker.model.Player;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class PlayerService {

    private final Map<Long, Player> playerMap = new HashMap<>();
    private Long nextId = 1L;

    public Player addPlayer(Player player) {
        player.setId(nextId++);
        playerMap.put(player.getId(), player);
        return player;
    }

    public Player getPlayerById(Long id) {
        return playerMap.get(id);
    }

    public Iterable<Player> getAllPlayers() {
        return playerMap.values();
    }

    // You can add more methods for updating, deleting, etc.
}