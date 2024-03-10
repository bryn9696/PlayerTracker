package com.example.playerTracker.service;

import com.example.playerTracker.model.Player;
import com.example.playerTracker.model.Team;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TeamServiceImpl implements TeamService{
    private final Map<Long, Team> teamMap = new HashMap<>();
    private Long nextId = 1L;

    @Override
    public List<Team> getAllTeams() {
        return new ArrayList<>(teamMap.values());
    }

    @Override
    public List<Team> addTeam(Team team) {
        team.setId(nextId++);

        teamMap.put(team.getId(), team);
        return new ArrayList<>(teamMap.values());
    }
}
