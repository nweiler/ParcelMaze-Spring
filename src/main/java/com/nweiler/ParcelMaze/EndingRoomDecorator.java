/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nweiler.ParcelMaze;

import java.util.HashMap;
import java.util.Random;

/**
 *
 * @author sirius
 */
public class EndingRoomDecorator extends RoomDecorator {
    
    private Room standardRoom;
    private String imageFilePath;
    private String description;
    private HashMap<String, Room> exits;
    private Monster myMonster;
    private boolean hasParcel;
    private boolean hasMonster;
    private static Random rand = new Random();
    
    public EndingRoomDecorator(String name, String description, 
            String imageFilePath, boolean hasParcel, boolean hasMonster) {
        super(name, description, imageFilePath, hasParcel, hasMonster);
    }
    
    @Override
    public boolean hasMonster() {
        return standardRoom.hasMonster();
    }
    
    @Override
    public boolean hasParcel() {
        return standardRoom.hasParcel();
    }
    
    @Override
    public void removeParcel() {
        standardRoom.removeParcel();
    }
    
    @Override
    public void setExit(String direction, Room neighbor) {
        standardRoom.setExit(direction, neighbor);
    }
    
    @Override
    public String getShortDescription() {
        return standardRoom.getShortDescription();
    }
    
    @Override
    public String getLongDescription() {
        return standardRoom.getLongDescription();
    }
    
    @Override
    public String getExitString() {
        return standardRoom.getExitString();
    }
    
    @Override
    public Room getExit(String direction) {
        return standardRoom.getExit(direction);
    }
    
    @Override
    public void displayImage() {
        standardRoom.displayImage();
    }
    
    @Override
    public void displayDesc() {
        standardRoom.displayDesc();
    }
    
    @Override
    public String getImageFilePath() {
        return standardRoom.getImageFilePath();
    }
}
