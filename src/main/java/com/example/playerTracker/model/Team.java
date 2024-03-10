package com.example.playerTracker.model;

import java.util.Date;

public class Team {
    private Long id;
    private String name;
    private int age;
    private String manager;
    private int squadSize;
    private Date dateAdded;
    public Team() {
    }

    public Team(String name, int age, String manager, int squadSize) {
        this.name = name;
        this.age = age;
        this.manager = manager;
        this.squadSize = squadSize;
        this.dateAdded = new Date();
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getManager() {
        return manager;
    }
    public void setManager(String manager) {
        this.manager = manager;
    }
    public int getSquadSize() {
        return squadSize;
    }
    public void setSquadSize(int squadSize) {
        this.squadSize = squadSize;
    }
    public Date getDateAdded() {
        return dateAdded;
    }
    public void setDateAdded(Date dateAdded) {
        this.dateAdded = dateAdded;
    }
}
