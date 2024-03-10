package com.example.playerTracker.controller;

import com.example.playerTracker.model.Player;
import com.example.playerTracker.model.Team;
import com.example.playerTracker.service.PlayerService;
import com.example.playerTracker.service.TeamService;
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
    private final TeamService teamService;

    @Autowired
    public PlayerController(PlayerService playerService, TeamService teamService) {
        this.playerService = playerService;
        this.teamService = teamService;
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

    @GetMapping("/teams")
    public List<Team> getAllTeams() {
        return teamService.getAllTeams();
    }

    @PostMapping("/teams")
    public List<Team> addTeam(@RequestBody Team team)
    {
        team.setDateAdded(new Date());
        return teamService.addTeam(team);
    }

    @GetMapping("/byTeam/{team}")
    public List<Player> getPlayersByTeam(@PathVariable String team) {
        return playerService.getPlayersByTeam(team);
    }

    // Update a player's team
    @PutMapping("/{id}/team")
    public ResponseEntity<String> updatePlayerTeam(@PathVariable long id, @RequestBody String team) {
        if (playerService.updatePlayerTeam(id, team)) {
            return new ResponseEntity<>("Player team updated successfully.", HttpStatus.OK);
        }
        return new ResponseEntity<>("Player not found.", HttpStatus.NOT_FOUND);
    }
}