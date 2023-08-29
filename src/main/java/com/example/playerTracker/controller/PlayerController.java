package com.example.playerTracker.controller;

import com.example.playerTracker.model.Player;
import com.example.playerTracker.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api")
public class PlayerController {

    private final PlayerService playerService;

    @Autowired
    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping("/players")
    public List<Player> getAllPlayers() {
        return playerService.getAllPlayers();
    }

    @PostMapping("/players")
    public List<Player> addPlayer(@RequestBody Player player)
    {
        player.setDateAdded(new Date());
        return playerService.addPlayer(player);
//        Player addedPlayer = playerService.addPlayer(player);
//        return ResponseEntity.status(HttpStatus.CREATED).body(addedPlayer);
    }

    @GetMapping("/players/{id}")
    public Player getPlayerById(@PathVariable Long id)
    {
        return playerService.getPlayerById(id);
    }

    @PutMapping("/players/{id}")
    public ResponseEntity<List<Player>> updatePlayer(@PathVariable Long id, @RequestBody Player updatedPlayer) {
        List<Player> updatedPlayers = playerService.updatePlayer(id, updatedPlayer);
        if (updatedPlayers == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(updatedPlayers);
    }
}