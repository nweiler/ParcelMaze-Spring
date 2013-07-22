package com.nweiler.ParcelMaze;


import java.util.HashMap;
import java.util.Scanner;
import java.util.Random;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * For our game "The Parcel Maze of Doom!" navigation through the maze is strictly text based.
 * Meaning, that when you want to go from one room to another it is based on the players
 * input of direction. Similar to Zuul when a player wants to move they have the option 
 * of direction. (North, South, East, West)
 * 
 * Unlike Zuul, however, our game will have unique images displayed for each room 
 * In addition to that the player could wander into a room that has a monster or a parcel. 
 * Encountering a monster initiates a fight sequence.
 * A parcel increases the player's health.
 */

public class Maze {
    private static Maze instance;
    private RoomFactory roomFactory;
    private Room currentRoom;
    private HashMap<String, Room> rooms;
    private HashMap<String, String> exitStrings;
    private Actor myUser = new User();
    private int monsterCount = 0;
    private static Random rand = new Random();
    
    ApplicationContext context = new ClassPathXmlApplicationContext("com/nweiler/ParcelMaze/ParcelMaze.xml");
    
    /**
     * Private constructor for singleton
     */
    private Maze() {
        roomFactory = new RoomFactory();
    }
    
    public static synchronized Maze getInstance() {
        if(instance == null) {
            instance = new Maze();
      	}
      	return instance;
    }
    
     // This prevents duplicate instances via cloning (highly unlikely)
    @Override
    public Object clone() throws CloneNotSupportedException {
    	throw new CloneNotSupportedException();
    }

    
    public void play() {
        
        rooms = new HashMap<String, Room>();
        exitStrings = new HashMap<String, String>();
                
        rooms.put("outside", (Room) context.getBean("outside"));
        rooms.put("stable", (Room) context.getBean("stable"));
        rooms.put("warroom", (Room) context.getBean("warroom"));
        rooms.put("greathall", (Room) context.getBean("greathall"));
        rooms.put("tunnel", (Room) context.getBean("tunnel"));
        rooms.put("armory", (Room) context.getBean("armory"));
        rooms.put("saferoom", (Room) context.getBean("saferoom"));
        rooms.put("dungeon", (Room) context.getBean("dungeon"));
        rooms.put("kitchen", (Room) context.getBean("kitchen"));
        rooms.put("servants", (Room) context.getBean("servants"));
        rooms.put("wstairwell", (Room) context.getBean("wstairwell"));
        rooms.put("balcony", (Room) context.getBean("balcony"));
        rooms.put("estairwell", (Room) context.getBean("estairwell"));
        rooms.put("wtower", (Room) context.getBean("wtower"));
        rooms.put("etower", (Room) context.getBean("etower"));
        rooms.put("bedroom", (Room) context.getBean("bedroom"));
        rooms.put("watchout", (Room) context.getBean("watchout"));
        rooms.put("court", (Room) context.getBean("court"));       
                
        for(Room x: rooms.values()) {
            if(x.hasMonster()==1) { monsterCount ++; }
        }
        
        currentRoom = rooms.get("outside");
        StdDraw.clear();
        printWelcome();
        currentRoom.displayImage();
        currentRoom.displayDesc();
        Command command;
        
        boolean finished = false;       
        while(!finished) {
            
            while(monsterCount != 0 && !finished) {
                command = Parser.getCommand();
                finished = processCommand(command);
            }
            
            if(currentRoom.getName().equals("castle")) {
                finished = true;
            }
            
            else {
                while(!finished) {
                    System.out.println("You have defeated all of the monters "
                            + "but you must find your way back to the entrance!");
                    command = Parser.getCommand();
                    finished = processCommand(command);
                    if(currentRoom.getImageFilePath().equals("castle.jpg")){
                        finished = true;
                    }
                }
            }
        }
        
        if(monsterCount == 0) {
            System.out.println("You have defeated all of the monters "
                    + "and escaped the castle. YOU WIN!!!!!!");   
            System.out.println("Thank you for playing.  Goodbye."); 
            StdDraw.text(.5, .5, "YOU WIN!!!!");
        }
        else {
            System.out.println("Play again soon!");
        }
    }
    
    
    
    public void goRoom(Command command) {
        if(!command.hasSecondWord()) {
            // if there is no second word, we don't know where to go...
            System.out.println("Go where?");
            return;
        }

        String direction = command.getSecondWord();

        // Try to leave current room.
        Room nextRoom = currentRoom.getExit(direction);

        if (nextRoom == null) {
            System.out.println("There is no door!");
        }
        else {
            currentRoom = nextRoom;
            System.out.println(currentRoom.getLongDescription());
            StdDraw.clear();
            currentRoom.displayImage();
            currentRoom.displayDesc();
            if(currentRoom.hasParcel() == 1){
                //myUser.addHealth(10);
                currentRoom.removeParcel();
            }
            if(currentRoom.hasMonster() == 1){
                Fight fight = new Fight();
                System.out.println(currentRoom.getMonster().getHealth());
                boolean playerWins = fight.fight(myUser, currentRoom.getMonster());
                if (playerWins) currentRoom.removeMonster();
            }
            StdDraw.clear();
            currentRoom.displayImage();
        }
    }
    
    /**
     * Print out the opening message for the player.
     */
    private void printWelcome() {
        System.out.println("\nYou are standing outside a large castle.");
        System.out.println("You must defeat the monsters inside "
                + "and return from whence you came...");
        System.out.println("Type 'help' if you need help.\n");
        System.out.println(currentRoom.getLongDescription());
    }

    /**
     * Given a command, process (that is: execute) the command.
     * @param Command 
     *      The command to be processed.
     * @return True if the command ends the game, false otherwise.
     */
    private boolean processCommand(Command command) {
        boolean wantToQuit = false;

        if(command.isUnknown()) {
            System.out.println("I don't know what you mean...");
            return false;
        }
             
        String commandWord = command.getCommandWord();
        if (commandWord.equals("help")) {
            printHelp();
        }
        else if (commandWord.equals("go")) {
            goRoom(command);
        }
        else if (commandWord.equals("quit")) {
            wantToQuit = quit(command);
        }
        else if (commandWord.equals("health")) {
            System.out.println("Your current health is " + myUser.getHealth());

        }
        else if (commandWord.equals("monsters")){
            System.out.println("There are " + monsterCount 
                    + " monsters left in the castle!");
        }
        // else command not recognised.
        return wantToQuit;
    }

    /**
     * Print out some help information.
     * Here we print a cryptic message and a list of the 
     * command words.
     */
    private void printHelp() {
        System.out.println("You are trapped within the castle.");
        System.out.println("You must find the parcels and defeat the monsters.");
        System.out.println();
        System.out.println("Your command words are:");
        Parser.showCommands();
    }

    /** 
     * "Quit" was entered. Check the rest of the command to see
     * whether we really quit the game.
     * @param Command, uses command to determine exit command.
     * @return true, if this command quits the game, false otherwise.
     */
    private boolean quit(Command command) {
        if(command.hasSecondWord()) {
            System.out.println("Quit what?");
            return false;
        }
        else {
            return true;  // signal that we want to quit
        }
    }
    
    public void increaseMonsterCount() { 
        monsterCount++;
    }
    
    public void reduceMonsterCount() { 
        monsterCount--; 
    }
    
    public void printMonsterCount() { 
        System.out.println("There are " + monsterCount 
                + " monsters left in the castle!"); 
    }
}
