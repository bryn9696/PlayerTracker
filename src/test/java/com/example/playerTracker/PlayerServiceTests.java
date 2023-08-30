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
    void testGetAllPlayers() {
        PlayerServiceImpl playerService = new PlayerServiceImpl();
        playerService.addPlayer(new Player("Bryn", 27, "CB", 80, 90, 70, 85, 81.25));
        playerService.addPlayer(new Player("John", 25, "ST", 75, 85, 65, 80, 76.25));

        List<Player> players = playerService.getAllPlayers();

        assertEquals(2, players.size());
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

}
