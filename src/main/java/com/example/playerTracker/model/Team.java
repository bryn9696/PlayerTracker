package com.example.playerTracker.model;

import java.util.Date;

public class Team {
    private String name;
    public Team() {
    }

    public Team(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
