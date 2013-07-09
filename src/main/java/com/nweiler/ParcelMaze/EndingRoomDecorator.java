package com.nweiler.ParcelMaze;


public class EndingRoomDecorator extends RoomDecorator {
    
    private Room simpleRoom;
    
    public EndingRoomDecorator(Room simpleRoom) {
        this.simpleRoom = simpleRoom;
    }
    
    @Override
    public int hasMonster() {
        return simpleRoom.hasMonster();
    }
    
    @Override
    public int hasParcel() {
        return simpleRoom.hasParcel();
    }
    
    @Override
    public void removeParcel() {
        simpleRoom.removeParcel();
    }
    
    @Override
    public void setExit(String direction, Room neighbor) {
        simpleRoom.setExit(direction, neighbor);
    }
    
    @Override
    public String getShortDescription() {
        return simpleRoom.getShortDescription();
    }
    
    @Override
    public String getLongDescription() {
        return simpleRoom.getLongDescription();
    }
    
    @Override
    public String getExitString() {
        return simpleRoom.getExitString();
    }
    
    @Override
    public Room getExit(String direction) {
        return simpleRoom.getExit(direction);
    }
    
    @Override
    public void displayImage() {
        simpleRoom.displayImage();
    }
    
    @Override
    public void displayDesc() {
        simpleRoom.displayDesc();
    }
    
    @Override
    public String getImageFilePath() {
        return simpleRoom.getImageFilePath();
    }
        
    public String getName() {
        return simpleRoom.getName();
    }
    
    public void setName(String name) {
        simpleRoom.setName(name);
    }
 
    public Actor getMonster() {
        return simpleRoom.getMonster();
    }
}
