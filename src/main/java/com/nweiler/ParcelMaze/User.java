package com.nweiler.ParcelMaze;


import java.util.Random;

/**
 * The class representing the player. The user's attack strength is constant throughout the game.
 * Health starts at 100 and may decrease as the player encounters monsters.
 */

public class User extends Actor
{
    private int health;
    private Random rand = new Random();
    private String name;
    
    public User() {
        health = 100;
        //userAttack = rand.nextInt(25 + 1);
    }
    
    /**
     * Overloaded constructor allows for possible future addition on name attribute for the User.
     * @param name The player's name entered at the start of the game.
     */
    public User(String name) {
        health = 100;
        this.name = name;
    }
    
    public String getName() {
        return name;
    }
    
    @Override
    public int getHealth() {
        return health;
    }
    
    public int attack() {
        return rand.nextInt(25 + 1);
    }
    
    /**
     * Used for testing while creating player death sequence.
     */
    public void die() {
        Maze maze = Maze.getInstance();
        maze.play();
    }
    
    public void addHealth() {
        health += 10;
    }
    
    /**
     * Alternative to addHealth method. 
     * @param Damage The adjustment made to the user health
     */
    public void damage(int damage)
    {
        health -= damage;
    }    
}
