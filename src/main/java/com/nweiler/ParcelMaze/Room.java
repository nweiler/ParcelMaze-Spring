package com.nweiler.ParcelMaze;


public interface Room {
    int hasMonster();
    int hasParcel();
    void removeParcel();
    void setExit(String direction, Room neighbor);
    String getShortDescription();
    String getLongDescription();
    String getExitString();
    Room getExit(String direction);
    void displayImage();
    void displayDesc();
    String getImageFilePath();
    String getName();
    void setName(String name);
}