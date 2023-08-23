package com.example.playerTracker.controller;

import com.example.playerTracker.model.Player;
import com.example.playerTracker.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public List<Player> addPlayer(@RequestBody Player player) {
        return playerService.addPlayer(player);
    }

    @GetMapping("/players/{id}")
    public Player getPlayerById(@PathVariable Long id) {
        return playerService.getPlayerById(id);
//        Player player = playerService.getPlayerById(id);
//        if (player != null) {
//            return ResponseEntity.ok(player);
//        } else {
//            return ResponseEntity.notFound().build();
//        }
    }
}