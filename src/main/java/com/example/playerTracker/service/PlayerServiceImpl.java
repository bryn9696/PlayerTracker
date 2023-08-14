package com.example.playerTracker.service;

import com.example.playerTracker.model.Player;
import com.example.playerTracker.service.PlayerService;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class PlayerServiceImpl implements PlayerService {

    private final Map<Long, Player> players = new HashMap<>();
    private final AtomicLong nextId = new AtomicLong(1);

    @Override
    public Player addPlayer(Player player) {
        long id = nextId.getAndIncrement();
        player.setId(id);
        players.put(id, player);
        System.out.println(players);
        return player;
    }

    @Override
    public Player getPlayerById(Long id) {
        return players.get(id);
    }

    @Override
    public List<Player> getAllPlayers() {
        return new ArrayList<>(players.values());
    }

}
