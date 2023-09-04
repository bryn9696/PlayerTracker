package com.example.playerTracker.service;

import com.example.playerTracker.model.Player;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class PlayerServiceImpl implements PlayerService {

    private final Map<Long, Player> playerMap = new HashMap<>();
    private Long nextId = 1L;

    @Override
    public List<Player> addPlayer(Player player) {
        player.setId(nextId++);
        double totalStats = 0;
        if (player.getSpeed() != 0 || player.getAccuracy() != 0 || player.getStrength() != 0 || player.getRating() != 0)
        {
            double total = (player.getSpeed() + player.getAccuracy() + player.getStrength() + player.getRating());
            totalStats = total / 400.0 * 100.0;
        }
        double initialProgression = (totalStats > 0) ? totalStats : 0.0;
        player.setProgression(initialProgression);

        playerMap.put(player.getId(), player);
        return new ArrayList<>(playerMap.values());
    }

    @Override
    public Player getPlayerById(Long id) {
        return playerMap.get(id);
    }

    @Override
    public List<Player> getAllPlayers() {
        return new ArrayList<>(playerMap.values());
    }

    public List<Player> updatePlayer(Long id, Player updatedPlayer) {
        Player playerToUpdate = playerMap.get(id);
        if (playerToUpdate != null) {
            // Calculate cumulative progression based on changes in stats
            double cumulativeProgression = playerToUpdate.getProgression();

            // Calculate progression for each stat change
            cumulativeProgression += calculateProgression(playerToUpdate.getSpeed(), updatedPlayer.getSpeed());
            cumulativeProgression += calculateProgression(playerToUpdate.getAccuracy(), updatedPlayer.getAccuracy());
            cumulativeProgression += calculateProgression(playerToUpdate.getStrength(), updatedPlayer.getStrength());
            cumulativeProgression += calculateProgression(playerToUpdate.getRating(), updatedPlayer.getRating());

            // Update player's stats and cumulative progression
            playerToUpdate.setName(updatedPlayer.getName());
            playerToUpdate.setAge(updatedPlayer.getAge());
            playerToUpdate.setPosition(updatedPlayer.getPosition());
            playerToUpdate.setSpeed(updatedPlayer.getSpeed());
            playerToUpdate.setAccuracy(updatedPlayer.getAccuracy());
            playerToUpdate.setStrength(updatedPlayer.getStrength());
            playerToUpdate.setRating(updatedPlayer.getRating());
            playerToUpdate.setProgression(cumulativeProgression);

            // Return the updated list of players
            return new ArrayList<>(playerMap.values());
        } else {
            throw new IllegalArgumentException("Player not found with ID: " + id);
        }
    }

    private double calculateProgression(double oldValue, double newValue) {
        double percentageIncrease = ((newValue - oldValue) / 400 * 100.0) ;  // Increase by 1 equals 1%
        double maxPercentageIncrease = 400.0;

        if (percentageIncrease > maxPercentageIncrease) {
            return maxPercentageIncrease;
        }

        return percentageIncrease;
    }

    @Override
    public List<Player> getPlayersByTeam(String team) {
        return playerMap.values()
                .stream()
                .filter(player -> team.equals(player.getTeam()))
                .collect(Collectors.toList());
    }

    @Override
    public boolean updatePlayerTeam(Long id, String team) {
        Player player = playerMap.get(id);
        if (player != null) {
            player.setTeam(team);
            return true;
        }
        return false;
    }
}
