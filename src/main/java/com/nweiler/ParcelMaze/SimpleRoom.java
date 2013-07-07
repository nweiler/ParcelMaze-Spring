package com.nweiler.ParcelMaze;


//Code for rooms in the Maze. Borrows code from Zuul 
import java.util.Set;
import java.util.HashMap;
import java.util.Random;

/**
* Code for rooms in the Maze. The room has a description, an associated image, and a list of exits.
* It also may or may not contain a parcel and/or a monster.
*/

public class SimpleRoom implements Room {
    private String name;
    private String imageFilePath;
    private String description;
    private HashMap<String, Room> exits;
    private Actor myMonster;
    private Parcel myParcel;
    private int hasParcel;
    private int hasMonster;
    private Random rand = new Random();

 /**
  * Creates a room and initializes the description, image file and booleans for monster and parcel.
  * @param description A description of the room to be displayed along with the image.
  * @param imageFilePath The path and filename for the image.
  * @param myUser The instance of the user class created at the beginning of the maze.
  */
    public SimpleRoom(String name, String description, 
            String imageFilePath, int hasParcel, int hasMonster) {
        this.name = name;
        this.description = description;
        this.imageFilePath = imageFilePath;
        exits = new HashMap<String, Room>();
        this.hasParcel = hasParcel;
        this.hasMonster = hasMonster;
        if(hasMonster == 1) { myMonster = new Monster(); }
        if(hasParcel == 1) { myParcel = new Parcel(); }
    }
    
    public void displayDesc() {
        StdDraw.text(.5, .2, "You are" + description);
        if(hasParcel == 1) {
            StdDraw.text(.5, .1, "This room contains a parcel!");
            StdDraw.text(.5, .05, "You picked up the parcel and got +10 health!");
        }
        if(hasMonster == 1) {
            StdDraw.text(.5, .15, "There is a monster! Ahh!");
        }
    }
 
    public int hasMonster() {
        return hasMonster;
    }
 
    public int hasParcel() {
        return hasParcel;
    }
 
    public void removeParcel() {
        hasParcel = 0;
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
        if(hasMonster == 1) {
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
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
}