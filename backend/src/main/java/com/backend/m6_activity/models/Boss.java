package com.backend.m6_activity.models;

public class Boss extends Character{
    
    @Override
    public String toString(){
        return getName() + ". " + getCurrentHealth() + "/" + getMaxHealth();
    }
}
