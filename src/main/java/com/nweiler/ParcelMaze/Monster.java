package com.nweiler.ParcelMaze;


import java.util.Random;

/**
 * Class for the monster object that the user will fight.
 * Monsters always start with 100 health.
 * The attack strength is a random integer between 0 and 50
 * that changes with each call to checkAttack().
 */

public class Monster extends Actor {
    private int health;
    private static Random rand = new Random();

    /**
     * Constructor for the monster class.
     * Sets monsters health to 100.
     */
    public Monster() {
        health = 100;
    	//attack = rand.nextInt(10);
    }
    
    public void die() {
        health = 0;
    }

    /**
     * Returns the monster's current health.
     * @return Monster's health
    */ 
    @Override
    public int getHealth() {
        return health;
    }

    @Override
    public void setHealth(int health) {
        this.health = health;
    }

    public void damage(int damage)
    {
        health -= damage;
    }    
    /**
     * Checks the strength of the monster's attack for the fight.
     * @return Monster attack strength
     */
    public int attack() {
        return rand.nextInt(10);
    }
    
}