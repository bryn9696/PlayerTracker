package com.example.playerTracker.service;

import com.example.playerTracker.model.Team;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TeamServiceImpl implements TeamService{
    private final Map<Long, Team> teamsMap = new HashMap<>();
    @Override
    public List<Team> getAllTeams() {
        return new ArrayList<>(teamsMap.values());
    }
}
