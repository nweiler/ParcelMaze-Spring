package com.nweiler.ParcelMaze;

//Code for rooms in the Maze. Borrows code from Zuul 
import java.util.Set;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Random;

/**
* Code for rooms in the Maze. The room has a description, an associated image, and a list of exits.
* It also may or may not contain a parcel and/or a monster.
*/

public class StandardRoom implements Room
{
    private String name;
    private String imageFilePath;
    private String description;
    private HashMap<String, Room> exits;
    private Monster myMonster;
    private boolean hasParcel;
    private boolean hasMonster;
    private static Random rand = new Random();
 
 /**
  * Creates a room and initializes the description, image file and booleans for monster and parcel.
  * @param description A description of the room to be displayed along with the image.
  * @param imageFilePath The path and filename for the image.
  * @param myUser The instance of the user class created at the beginning of the maze.
  */
    public StandardRoom(String name, String description, 
            String imageFilePath, boolean hasParcel, boolean hasMonster) {
        this.name = name;
        this.description = description;
        this.imageFilePath = imageFilePath;
        exits = new HashMap<String, Room>();

        int x = rand.nextInt(2); // randomly generate parcel (or not)
        if(x==0 || imageFilePath.equals("castle.jpg")) { //prevents parcel in first room
            hasParcel = false;
        }
        else {
            hasParcel = true;
        }
        x = rand.nextInt(2);
     
        if(x==0 || imageFilePath.equals("castle.jpg")) { //prevents monster in first room
            hasMonster = false;
        }
        else if(x==1) {
            hasMonster = true;
        }
    }
    
    public void displayDesc()
    {
        StdDraw.text(.5, .2, "You are" + description);
        if(hasParcel){
            StdDraw.text(.5, .1, "This room contains a parcel!");
            StdDraw.text(.5, .05,"You picked up the parcel and got +10 health!");
        }
        if(hasMonster) {
            StdDraw.text(.5, .15, "There is a monster! Ahh!");
        }
    }
 
    public boolean hasMonster() {
        return hasMonster;
    }
 
    public boolean hasParcel() {
        return hasParcel;
    }
 
    public void removeParcel() {
        hasParcel = false;
    }

    public void setExit(String direction, Room neighbor) {
         exits.put(direction, neighbor);
    }
 
    public String getShortDescription() {
        return description;
    }
 
    public String getLongDescription() {
        return "You are" + description + ".\n" + getExitString();
    }
 
    /**
    * Returns a string with the exits for the room
    */
    public String getExitString() {
        String returnString = "Exits:";
        Set<String> keys = exits.keySet();
        for (String exit : keys) {
            returnString += " " + exit;
        }
        return returnString;
    }
 
    public Room getExit(String direction) {
        return exits.get(direction);
    }

    /**
    * Displays the room image
    * If the room contains a monster, the monster image is also displayed.
    */
    public void displayImage() {
        StdDraw.picture(.5, .5, imageFilePath, 1.1, 1);
        if(hasMonster!=false) {
            StdDraw.picture(.5, .5, "monster.png", 1.05, .9);
        }
    }
 
    public void displayFoundParcel() {
        StdDraw.text(.5, .1, "This room contains a parcel!");
        StdDraw.text(.5, .05,"You picked up the parcel and got +10 health!");    
    }
    
    public void displayFoundMonster() {
        StdDraw.text(.5, .15, "There is a monster! Ahh!");
    }
    
    public String getImageFilePath() {
        return imageFilePath;
    }
}