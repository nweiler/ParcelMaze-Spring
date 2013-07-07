package com.nweiler.ParcelMaze;

/**
 * @author sirius
 */
public interface Room {
    
    boolean hasMonster();
    boolean hasParcel();
    void removeParcel();
    void setExit(String direction, Room neighbor);
    String getShortDescription();
    String getLongDescription();
    String getExitString();
    Room getExit(String direction);
    void displayImage();
    void displayDesc();
    String getImageFilePath();
}