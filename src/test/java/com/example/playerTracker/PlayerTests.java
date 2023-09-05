package com.example.playerTracker;

import com.example.playerTracker.model.Player;
import org.junit.jupiter.api.Test;
import java.util.Date;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

public class PlayerTests {

    @Test
    public void testPlayerCreation() {
        Player player = new Player("Bryn", 25, "Forward", 80, 90, 70, 85, 0.0, "Team A");

        assertNotNull(player);
        assertEquals("Bryn", player.getName());
        assertEquals(25, player.getAge());
        assertEquals("Forward", player.getPosition());
        assertEquals(80, player.getSpeed());
        assertEquals(90, player.getAccuracy());
        assertEquals(70, player.getStrength());
        assertEquals(85, player.getRating());
        assertEquals(0.0, player.getProgression());
        assertNotNull(player.getDateAdded());
        assertNotNull(player.getDateLastEdited());
        assertEquals("Team A", player.getTeam());
    }

    @Test
    public void testPlayerId() {
        Player player = new Player();
        assertNull(player.getId());

        player.setId(1L);
        assertEquals(1L, player.getId());
    }

    @Test
    public void testPlayerName() {
        Player player = new Player();
        assertNull(player.getName());

        player.setName("Ryn");
        assertEquals("Ryn", player.getName());
    }

    @Test
    public void testPlayerAge() {
        Player player = new Player();
        assertEquals(0, player.getAge());

        player.setAge(30);
        assertEquals(30, player.getAge());
    }

    @Test
    public void testPlayerPosition() {
        Player player = new Player();
        assertNull(player.getPosition());

        player.setPosition("Midfielder");
        assertEquals("Midfielder", player.getPosition());
    }

    @Test
    public void testPlayerSpeed() {
        Player player = new Player();
        assertEquals(0, player.getSpeed());

        player.setSpeed(75);
        assertEquals(75, player.getSpeed());
    }

    @Test
    public void testPlayerAccuracy() {
        Player player = new Player();
        assertEquals(0, player.getAccuracy());

        player.setAccuracy(85);
        assertEquals(85, player.getAccuracy());
    }

    @Test
    public void testPlayerStrength() {
        Player player = new Player();
        assertEquals(0, player.getStrength());

        player.setStrength(70);
        assertEquals(70, player.getStrength());
    }

    @Test
    public void testPlayerRating() {
        Player player = new Player();
        assertEquals(0, player.getRating());

        player.setRating(88);
        assertEquals(88, player.getRating());
    }

    @Test
    public void testPlayerProgression() {
        Player player = new Player();
        assertEquals(0.0, player.getProgression());

        player.setProgression(10.5);
        assertEquals(10.5, player.getProgression());
    }

    @Test
    public void testPlayerDateAdded() {
        Player player = new Player();
        assertNull(player.getDateAdded());

        Date date = new Date();
        player.setDateAdded(date);
        assertEquals(date, player.getDateAdded());
    }

    @Test
    public void testPlayerDateLastEdited() {
        Player player = new Player();
        assertNull(player.getDateLastEdited());

        Date date = new Date();
        player.setDateLastEdited(date);
        assertEquals(date, player.getDateLastEdited());
    }

    @Test
    public void testPlayerTeam() {
        Player player = new Player();
        assertNull(player.getTeam());

        player.setTeam("Team B");
        assertEquals("Team B", player.getTeam());
    }
}
