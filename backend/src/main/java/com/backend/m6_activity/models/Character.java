package com.backend.m6_activity.models;

public class Character {
    private String id;
    private String name;
    private int currentHealth;
    private final int maxHealth;
    private int damage;

    public Character(){
        this.maxHealth = 100;
    }

    public Character(int maxHealth){
        this.maxHealth = maxHealth;
    }

    public String getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public int getCurrentHealth(){
        return currentHealth;
    }
    public int getMaxHealth(){
        return maxHealth;
    }
    public int getDamage(){
        return damage;
    }
}
