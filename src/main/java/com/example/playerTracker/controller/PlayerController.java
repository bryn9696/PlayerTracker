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

    @PostMapping("/add-players")
    public Player addPlayer(@RequestBody Player player) {
        return playerService.addPlayer(player);
    }

    // Other methods for updating, deleting, etc.
}


//package com.example.playerTracker.controller;
//
//import com.example.playerTracker.model.Player;
//import com.example.playerTracker.service.PlayerService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/api")
//public class PlayerController {
//
//    private final PlayerService playerService;
//
//    @Autowired
//    public PlayerController(PlayerService playerService) {
//        this.playerService = playerService;
//    }
//
//    @GetMapping("/players")
//    public List<Player> getAllPlayers() {
//        return playerService.getAllPlayers();
//    }
//
//    @GetMapping("/players/{id}")
//    public Player getPlayerById(@PathVariable Long id) {
//        return playerService.getPlayerById(id);
//    }
//
//    @PostMapping("/players")
//    public Player addPlayer(@RequestBody Player player) {
//        return playerService.addPlayer(player);
//    }
//
//    // Other methods for updating, deleting, etc.
//}
