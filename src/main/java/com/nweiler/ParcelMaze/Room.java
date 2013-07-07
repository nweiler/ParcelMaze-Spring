package com.nweiler.ParcelMaze;

/**
 * @author sirius
 */
public interface Room {
     
    abstract void startAFight();
    abstract boolean hasMonster();
    abstract boolean hasParcel();
    abstract void removeParcel();
    abstract void setExit(String direction, Room neighbor);
    abstract String getShortDescription();
    abstract String getLongDescription();
    abstract String getExitString();
    abstract Room getExit(String direction);
    abstract void displayImage();
    abstract void displayDesc();
    abstract String getImageFilePath();
}