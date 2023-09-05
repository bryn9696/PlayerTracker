package com.example.playerTracker;

import com.example.playerTracker.model.Player;
import com.example.playerTracker.service.PlayerServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

class PlayerServiceTests {

    private PlayerServiceImpl playerService;

    @BeforeEach
    public void setup() {
        playerService = new PlayerServiceImpl();
    }

    @Test
    public void testAddPlayer() {
        Player player = new Player();
        player.setName("Bryn");
        player.setSpeed(10);
        player.setAccuracy(20);
        player.setStrength(30);
        player.setRating(40);

        List<Player> playersAfterAdd = playerService.addPlayer(player);

        assertEquals(1, playersAfterAdd.size());
        Player addedPlayer = playersAfterAdd.get(0);

        assertEquals("Bryn", addedPlayer.getName());
        assertEquals(10, addedPlayer.getSpeed());
        assertEquals(20, addedPlayer.getAccuracy());
        assertEquals(30, addedPlayer.getStrength());
        assertEquals(40, addedPlayer.getRating());
        assertEquals(25.0, addedPlayer.getProgression());
    }

    @Test
    public void testGetPlayerById() {
        Player player = new Player("Alice", 22, "Midfielder", 75, 85, 65, 88, 0.0, "Team B");
        List<Player> players = playerService.addPlayer(player);

        assertNotNull(players);
        assertEquals(1, players.size());

        Player addedPlayer = players.get(0);

        Player retrievedPlayer = playerService.getPlayerById(addedPlayer.getId());
        assertNotNull(retrievedPlayer);
        assertEquals(addedPlayer.getId(), retrievedPlayer.getId());
    }


    @Test
    public void testGetAllPlayers() {
        Player player1 = new Player("Alice", 22, "Midfielder", 75, 85, 65, 88, 0.0, "Team B");
        Player player2 = new Player("Bryn", 23, "Defender", 70, 80, 75, 86, 0.0, "Team A");

        playerService.addPlayer(player1);
        playerService.addPlayer(player2);

        List<Player> players = playerService.getAllPlayers();

        assertNotNull(players);
        assertEquals(2, players.size());
    }

    @Test
    public void testUpdatePlayer() {
        Player player = new Player("Alice", 22, "Midfielder", 75, 85, 65, 88, 0.0, "Team B");
        List<Player> players = playerService.addPlayer(player);

        assertNotNull(players);
        assertEquals(1, players.size());

        Player addedPlayer = players.get(0);

        Player updatedPlayer = new Player("Updated Alice", 23, "Forward", 80, 90, 70, 90, 0.0, "Team A");
        playerService.updatePlayer(addedPlayer.getId(), updatedPlayer);

        Player retrievedPlayer = playerService.getPlayerById(addedPlayer.getId());
        assertNotNull(retrievedPlayer);
        assertEquals("Updated Alice", retrievedPlayer.getName());
        assertEquals(23, retrievedPlayer.getAge());
        assertEquals("Forward", retrievedPlayer.getPosition());
        assertEquals(80, retrievedPlayer.getSpeed());
        assertEquals(90, retrievedPlayer.getAccuracy());
        assertEquals(70, retrievedPlayer.getStrength());
        assertEquals(90, retrievedPlayer.getRating());
        assertNotEquals(0.0, retrievedPlayer.getProgression());  // Progression should be updated
        assertNotNull(retrievedPlayer.getDateLastEdited());
        assertEquals("Team A", retrievedPlayer.getTeam());
    }

    @Test
    public void testUpdatePlayerNotFound() {
        assertThrows(IllegalArgumentException.class, () -> {
            Player updatedPlayer = new Player("Updated Alice", 23, "Forward", 80, 90, 70, 90, 0.0, "Team A");
            playerService.updatePlayer(1L, updatedPlayer);
        });
    }

    @Test
    public void testGetPlayersByTeam() {
        Player player1 = new Player("Alice", 22, "Midfielder", 75, 85, 65, 88, 0.0, "Team B");
        Player player2 = new Player("Bryn", 23, "Defender", 70, 80, 75, 86, 0.0, "Team A");

        playerService.addPlayer(player1);
        playerService.addPlayer(player2);

        List<Player> teamAPlayers = playerService.getPlayersByTeam("Team A");
        assertNotNull(teamAPlayers);
        assertEquals(1, teamAPlayers.size());

        List<Player> teamBPlayers = playerService.getPlayersByTeam("Team B");
        assertNotNull(teamBPlayers);
        assertEquals(1, teamBPlayers.size());
    }

    @Test
    public void testUpdatePlayerTeam() {
        Player player = new Player("Bryn", 23, "Defender", 70, 80, 75, 86, 0.0, "Team A");
        List<Player> players = playerService.addPlayer(player);

        assertNotNull(players);
        assertEquals(1, players.size());

        Player addedPlayer = players.get(0);

        boolean updated = playerService.updatePlayerTeam(addedPlayer.getId(), "Team C");
        assertTrue(updated);

        Player retrievedPlayer = playerService.getPlayerById(addedPlayer.getId());
        assertNotNull(retrievedPlayer);
        assertEquals("Team C", retrievedPlayer.getTeam());
    }

    @Test
    public void testUpdatePlayerTeamNotFound() {
        boolean updated = playerService.updatePlayerTeam(1L, "Team C");
        assertFalse(updated);
    }
}

