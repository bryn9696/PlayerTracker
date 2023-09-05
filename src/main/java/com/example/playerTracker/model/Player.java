package com.example.playerTracker.model;

import java.util.Date;

public class Player {

    private Long id;
    private String name;
    private int age;
    private String position;
    private int speed;
    private int accuracy;
    private int strength;
    private int rating;
    private double progression;
    private Date dateAdded;
    private Date dateLastEdited;
    private String team;

    public Player() {
    }

    public Player(String name, int age, String position, int speed, int accuracy, int strength, int rating, double progression, String team) {
        this.name = name;
        this.age = age;
        this.position = position;
        this.speed = speed;
        this.accuracy = accuracy;
        this.strength = strength;
        this.rating = rating;
        this.progression = progression;
        this.dateAdded = new Date();
        this.dateLastEdited = new Date();
        this.team = team;
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

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(int accuracy) {
        this.accuracy = accuracy;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
    public double getProgression() {
        return progression;
    }

    public void setProgression(double progression) {
        this.progression = progression;
    }

    public Date getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(Date dateAdded) {
        this.dateAdded = dateAdded;
    }

    public Date getDateLastEdited() {
        return dateAdded;
    }

    public void setDateLastEdited(Date dateAdded) {
        this.dateAdded = dateAdded;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }
}
