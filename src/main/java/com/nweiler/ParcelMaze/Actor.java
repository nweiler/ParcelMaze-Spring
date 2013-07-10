package com.nweiler.ParcelMaze;


public abstract class Actor {

    private Room currentRoom;
    private int health;
    
    public int getHealth() {
        return health;
    }

    public abstract void die();    
    
    public void damage(int damage) {
        health -= damage;
    }
            
    public void setHealth(int health) {
        this.health = health;
    }
    
    public abstract int attack();
        
            /** 
     * Try to go to one direction. If there is an exit, enter the new
     * room, otherwise print an error message.
     * 
     * @param Command, uses
     *      The command used to determine exit command
     */
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
                //myUser.addHealth();
                currentRoom.removeParcel();;
            }
        }
    }

}
