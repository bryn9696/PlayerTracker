package com.example.playerTracker.controller;

import com.example.playerTracker.model.Player;
import com.example.playerTracker.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PlayerController {

    private final PlayerRepository playerRepository;

    @Autowired
    public PlayerController(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    @GetMapping("/players")
    public String showPlayers(Model model) {
        // Retrieve all players from the database and pass them to the view
        Iterable<Player> players = playerRepository.findAll();
        model.addAttribute("players", players);
        return "player-list";
    }

    @GetMapping("/players/{id}")
    public String showPlayerDetails(@PathVariable Long id, Model model) {
        // Retrieve the player by ID from the database and pass it to the view
        Player player = playerRepository.findById(id).orElse(null);
        model.addAttribute("player", player);
        return "player-details";
    }

    @PostMapping("/players/{id}/rate")
    public String ratePlayer(@PathVariable Long id, @RequestParam int speedRating, @RequestParam int accuracyRating,
                             @RequestParam int strengthRating) {
        // Update the player's ratings in the database
        Player player = playerRepository.findById(id).orElse(null);
        if (player != null) {
            player.setSpeed(speedRating);
            player.setAccuracy(accuracyRating);
            player.setStrength(strengthRating);
            playerRepository.save(player);
        }
        return "redirect:/players/" + id;
    }
}
