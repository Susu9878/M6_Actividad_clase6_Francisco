package com.backend.m6_activity.models;

public class Player extends Character{
    private int lowMultiplier;
    private int mediumMultiplier;
    private int highMultiplier;

    public Player(){}

    public int getLowMult(){
        return lowMultiplier;
    }
    public void setLowMult(int mult){
        this.lowMultiplier = mult;
    }

    public int getMediumMult(){
        return mediumMultiplier;
    }
    public void setMediumMult(int mult){
        this.mediumMultiplier = mult;
    }

    public int getHighMult(){
        return highMultiplier;
    }
    public void setHighMult(int mult){
        this.highMultiplier = mult;
    }
    
    @Override
    public String toString(){
        return getName() + ". " + getCurrentHealth() + "/" + getMaxHealth() + ".\n" +
               "Base Damage: " + getDamage() + ".\n" +
               "Multipliers: ";
    }
}
