/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nweiler.ParcelMaze;

/**
 *
 * @author sirius
 */
public class StartingRoomDecorator extends RoomDecorator {
    
    private Room simpleRoom;
    
    public StartingRoomDecorator(Room simpleRoom) {
        this.simpleRoom = simpleRoom;
    }
    
        @Override
    public boolean hasMonster() {
        return simpleRoom.hasMonster();
    }
    
    @Override
    public boolean hasParcel() {
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
}
