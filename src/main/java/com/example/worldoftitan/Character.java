package com.example.worldoftitan;

public class Character {

    private String name;
    private int height;
    private int weight;
    private int strength;
    private int agility;
    private int intelligence;
    private int coordination;
    private int leadership;
    private String imagePath;

    public Character(String name, int height, int weight, int strength, int agility,
                     int intelligence, int coordination, int leadership, String imagePath) {
        this.name = name;
        this.height = height;
        this.weight = weight;
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
        this.coordination = coordination;
        this.leadership = leadership;
        this.imagePath = imagePath;
    }

    public String getName() {
        return name;
    }

    public int getHeight() {
        return height;
    }

    public int getWeight() {
        return weight;
    }

    public int getStrength() {
        return strength;
    }

    public int getAgility() {
        return agility;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public int getCoordination() {
        return coordination;
    }

    public int getLeadership() {
        return leadership;
    }

    public String getImagePath() {
        return imagePath;
    }
}
