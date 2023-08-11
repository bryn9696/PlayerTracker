package com.example.playerTracker.controller;

import com.example.playerTracker.model.Player;
import com.example.playerTracker.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PlayerController {

    private final PlayerService playerService;

    @Autowired
    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("players", playerService.getAllPlayers());
        return "home";
    }

    @GetMapping("/player/{id}")
    public String playerDetails(@PathVariable Long id, Model model) {
        Player player = playerService.getPlayerById(id);
        if (player == null) {
            return "player-not-found";
        }
        model.addAttribute("player", player);
        return "player-details";
    }

//    @GetMapping("/player-list")
//    public String playerList(Model model) {
//        model.addAttribute("players", playerService.getAllPlayers());
//        return "player-list";
//    }

    @GetMapping("/ratings-form")
    public String ratingForm(Model model) {
        model.addAttribute("players", playerService.getAllPlayers());
        return "ratings-form";
    }

//    @PostMapping("/rate-players")
//    public String ratePlayers() {
//        // Handle form submission and update player ratings
//        // You need to implement the logic to update player ratings here
//        return "redirect:/"; // Redirect back to the home page after rating
//    }
}