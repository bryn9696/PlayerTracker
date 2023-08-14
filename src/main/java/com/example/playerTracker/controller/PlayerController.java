package com.example.playerTracker.controller;

import com.example.playerTracker.model.Player;
import com.example.playerTracker.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PlayerController {

    private final PlayerService playerService;

    @Autowired
    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping("/")
    public String home(Model model) {
        System.out.println("2222");
        model.addAttribute("players", playerService.getAllPlayers());
        return "home.html";
    }

    @GetMapping("/player/{id}")
    public String playerDetails(@PathVariable Long id, Model model) {
        Player player = playerService.getPlayerById(id);
        if (player == null) {
            return "player-not-found.html";
        }
        model.addAttribute("player", player);
        return "player-details.html";
    }

    @GetMapping("/player-list")
    public String playerList(Model model) {
        model.addAttribute("players", playerService.getAllPlayers());
        return "player-list.html";
    }

    @GetMapping("/ratings-form")
    public String ratingForm(Model model) {
        model.addAttribute("players", playerService.getAllPlayers());
        return "ratings-form.html";
    }

//    @PostMapping("/rate-players")
//    public String ratePlayers() {
//        // Handle form submission and update player ratings
//        // You need to implement the logic to update player ratings here
//        return "redirect:/"; // Redirect back to the home page after rating
//    }

    @GetMapping("/add-player")
    public String showAddPlayerForm() {
        return "add-player.html";
    }

    @PostMapping("/add-player")
    public String addPlayer(@ModelAttribute Player player) {
        playerService.addPlayer(player);
        return "redirect:/player-list";
    }
}