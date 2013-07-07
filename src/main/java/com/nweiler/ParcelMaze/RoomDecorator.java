package com.nweiler.ParcelMaze;


public abstract class RoomDecorator implements Room {
    
    public abstract int hasMonster();
    public abstract int hasParcel();
    public abstract void removeParcel();
    public abstract void setExit(String direction, Room neighbor);
    public abstract String getShortDescription();
    public abstract String getLongDescription();
    public abstract String getExitString();
    public abstract Room getExit(String direction);
    public abstract void displayImage();
    public abstract void displayDesc();
    public abstract String getImageFilePath();
    public abstract String getName();
    public abstract void setName(String name);
}
