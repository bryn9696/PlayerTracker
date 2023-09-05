package com.example.playerTracker;

import com.example.playerTracker.model.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class PlayerTests {

    private Player player;

    @BeforeEach
    void setUp() {
        player = new Player("Bryn", 25, "Forward", 80, 85, 90, 75, 82.5, "TeamA");
    }

    @Test
    void testInitialValues() {
        assertEquals("Bryn", player.getName());
        assertEquals(25, player.getAge());
        assertEquals("Forward", player.getPosition());
        assertEquals(80, player.getSpeed());
        assertEquals(85, player.getAccuracy());
        assertEquals(90, player.getStrength());
        assertEquals(75, player.getRating());
        assertEquals(82.5, player.getProgression());
        assertEquals("TeamA", player.getTeam());
    }

    @Test
    void testDateAddedNotNull() {
        assertNotNull(player.getDateAdded());
    }

    @Test
    void testDateLastEditedNotNullAfterUpdate() {
        Player updatedPlayer = new Player("Bryn", 26, "Midfielder", 81, 86, 91, 76, 83.5, "TeamB");
        player.updateAttributes(updatedPlayer);
        assertNotNull(player.getDateLastEdited());
    }

    @Test
    void testTeamAssignment() {
        assertEquals("TeamA", player.getTeam());
    }

    @Test
    void testNameChange() {
        player.updateAttributes(new Player("Ryn", 25, "Forward", 90, 85, 100, 75, 87.5, "TeamA"));

        assertEquals("Ryn", player.getName());
    }

    @Test
    void testPositionChange() {
        player.updateAttributes(new Player("Bryn", 25, "Defender", 90, 85, 100, 75, 87.5, "TeamA"));

        assertEquals("Defender", player.getPosition());
    }

    @Test
    void testSpeedChange() {
        player.updateAttributes(new Player("Bryn", 25, "Forward", 0, 85, 0, 75, 40.0, "TeamA"));

        // Speed and Strength decreased to 0, so the progression is -100%
        assertEquals(0, player.getSpeed());
    }

    @Test
    void testAccuracyChange() {
        player.updateAttributes(new Player("Bryn", 25, "Forward", 70, 14, 80, 75, 77.5, "TeamA"));

        // Speed decreased by 12.5%, Strength decreased by 11.1%
        assertEquals(14, player.getAccuracy());
    }

    @Test
    void testStrengthChange() {
        player.updateAttributes(new Player("Bryn", 25, "Forward", 70, 14, 10, 75, 77.5, "TeamA"));

        // Speed decreased by 12.5%, Strength decreased by 11.1%
        assertEquals(10, player.getStrength());
    }
}
