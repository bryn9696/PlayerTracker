package com.example.playerTracker;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.*;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;

import com.example.playerTracker.controller.PlayerController;
import com.example.playerTracker.model.Player;
import com.example.playerTracker.model.Team;
import com.example.playerTracker.service.PlayerService;
import com.example.playerTracker.service.TeamService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PlayerControllerTest {

    @InjectMocks
    private PlayerController playerController;

    @Mock
    private PlayerService playerService;

    @Mock
    private TeamService teamService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetAllPlayers() {
        List<Player> players = new ArrayList<>();
        players.add(new Player("Player 1", 25, "Forward", 90, 85, 75, 85, 0.0, "Team A"));
        when(playerService.getAllPlayers()).thenReturn(players);

        List<Player> result = playerController.getAllPlayers();

        assertThat(result, hasSize(1));
        assertEquals(players, result);
    }

    @Test
    public void testGetAllTeams() {
        List<Team> teams = new ArrayList<>();
        teams.add(new Team("Team 1", 25, "Forward", 90));
        when(teamService.getAllTeams()).thenReturn(teams);

        List<Team> result = playerController.getAllTeams();

        System.out.println(teams.get(0).getName());
        assertThat(result, hasSize(1));
        assertEquals(teams, result);
    }

    @Test
    public void testAddPlayer() {
        Player playerToAdd = new Player("New Player", 22, "Midfielder", 88, 90, 80, 82, 0.0, "Team B");
        List<Player> updatedPlayers = new ArrayList<>();
        updatedPlayers.add(new Player("Player 1", 25, "Forward", 90, 85, 75, 85, 0.0, "Team A"));
        updatedPlayers.add(playerToAdd);

        when(playerService.addPlayer(playerToAdd)).thenReturn(updatedPlayers);

        List<Player> result = playerController.addPlayer(playerToAdd);

        assertThat(result, hasSize(2));
        assertEquals(updatedPlayers, result);
    }
    @Test
    public void testAddTeam() {
        Team teamToAdd = new Team("hares", 22, "bryn", 88);
        List<Team> updatedTeams = new ArrayList<>();
        updatedTeams.add(new Team("Team 1", 25, "Forward", 90));
        updatedTeams.add(teamToAdd);

        when(teamService.addTeam(teamToAdd)).thenReturn(updatedTeams);

        List<Team> result = playerController.addTeam(teamToAdd);
        System.out.println(result.get(0).getName());

        assertThat(result, hasSize(2));
        assertEquals(updatedTeams, result);
    }

    @Test
    public void testGetPlayerById() {
        Long playerId = 1L;
        Player player = new Player("Player 1", 25, "Forward", 90, 85, 75, 85, 0.0, "Team A");
        when(playerService.getPlayerById(playerId)).thenReturn(player);

        Player result = playerController.getPlayerById(playerId);

        assertEquals(player, result);
    }

    @Test
    public void testUpdatePlayer() {
        Long playerId = 1L;
        Player player = new Player("Updated Player", 26, "Forward", 91, 87, 76, 86, 0.0, "Team A");
        List<Player> updatedPlayers = new ArrayList<>();
        updatedPlayers.add(player);

        Player updatedPlayer = new Player();
        updatedPlayer.setName("John");
        updatedPlayer.setAge(25);
        updatedPlayer.setPosition("Defender");
        updatedPlayer.setSpeed(85);
        updatedPlayer.setAccuracy(56);
        updatedPlayer.setStrength(60);
        updatedPlayer.setRating(40);

        when(playerService.updatePlayer(eq(playerId), eq(updatedPlayer))).thenReturn(updatedPlayers);

        // Act
        ResponseEntity<List<Player>> response = playerController.updatePlayer(playerId, updatedPlayer);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(updatedPlayers, response.getBody());
        assertThat(response.getBody(), hasSize(1));
    }

    @Test
    public void testGetPlayersByTeam() {
        String team = "Team A";
        List<Player> players = new ArrayList<>();
        players.add(new Player("Player 1", 25, "Forward", 90, 85, 75, 85, 0.0, team));
        players.add(new Player("Player 2", 24, "Midfielder", 88, 87, 79, 84, 0.0, team));
        when(playerService.getPlayersByTeam(team)).thenReturn(players);

        List<Player> result = playerController.getPlayersByTeam(team);

        assertThat(result, hasSize(2));
        assertEquals(players, result);
    }

//    @Test
//    void testUpdatePlayerTeam_Success() {
//        // Arrange
//        long playerId = 1L;
//        List<Player> players = new ArrayList<>();
//        players.add(new Player("Player 1", 25, "Forward", 90, 85, 75, 85, 0.0, "Team A"));
//        String newTeam = "New Team";
//
//        when(playerService.updatePlayerTeam(eq(playerId), any(String.class))).thenReturn(true);
//
//        // Act
//        ResponseEntity<String> response = playerController.updatePlayerTeam(playerId, players.get(0).getTeam());
//
//        // Assert
//        assertEquals(response.getStatusCode(), HttpStatus.OK);
//        assertEquals(response.getBody(), "Player team updated successfully.");
//    }
//
//    @Test
//    void testUpdatePlayerTeam_PlayerNotFound() {
//        // Arrange
//        long playerId = 2L;
//        String newTeam = "New Team";
//
//        // Act
//        ResponseEntity<String> response = playerController.updatePlayerTeam(playerId, newTeam);
//
//        // Assert
//        assertEquals(response.getStatusCode(), HttpStatus.NOT_FOUND);
//        assertEquals(response.getBody(), "Player not found.");
//    }
}