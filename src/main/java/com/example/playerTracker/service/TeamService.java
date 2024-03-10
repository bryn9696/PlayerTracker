package com.example.playerTracker.service;

import com.example.playerTracker.model.Player;
import com.example.playerTracker.model.Team;

import java.util.List;

public interface TeamService {
    List<Team> getAllTeams();
    List<Team> addTeam(Team team);
}
