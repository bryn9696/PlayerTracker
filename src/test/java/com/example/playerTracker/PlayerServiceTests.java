package com.example.playerTracker;

import com.example.playerTracker.model.Player;
import com.example.playerTracker.service.PlayerServiceImpl;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

class PlayerServiceTests {

    @Test
    void testGetAllPlayers() {
        PlayerServiceImpl playerService = new PlayerServiceImpl();
        playerService.addPlayer(new Player("Bryn", 27, "CB", 80, 90, 70, 85));
        playerService.addPlayer(new Player("John", 25, "ST", 75, 85, 65, 80));

        List<Player> players = playerService.getAllPlayers();

        assertEquals(2, players.size());
    }

}
