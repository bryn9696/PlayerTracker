package com.example.playerTracker.service;

import com.example.playerTracker.model.Player;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

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
    public Player getPlayerById(Long id) {
        return playerMap.get(id);
    }

    @Override
    public List<Player> getAllPlayers() {
        return new ArrayList<>(playerMap.values());
    }

}
