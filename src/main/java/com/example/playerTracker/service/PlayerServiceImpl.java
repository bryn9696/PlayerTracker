package com.example.playerTracker.service;

import com.example.playerTracker.model.Player;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PlayerServiceImpl implements PlayerService {

    private final Map<Long, Player> playerMap = new HashMap<>();
    private Long nextId = 1L;

    @Override
    public List<Player> addPlayer(Player player) {
        player.setId(nextId++);
        playerMap.put(player.getId(), player);
        return new ArrayList<>(playerMap.values());
    }

    @Override
    public List<Player> updatePlayer(Long id, Player updatedPlayer) {
        if (!playerMap.containsKey(id)) {
            return null; // Player not found
        }

        playerMap.put(id, updatedPlayer);
        return new ArrayList<>(playerMap.values());
    }

    @Override
    public Player getPlayerById(Long id) {
        return playerMap.get(id);
    }

    @Override
    public List<Player> getAllPlayers() {
        return new ArrayList<>(playerMap.values());
    }

}
