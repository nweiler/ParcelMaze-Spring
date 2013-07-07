/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nweiler.ParcelMaze;

/**
 *
 * @author sirius
 */
public abstract class RoomDecorator implements Room {
    
    public abstract boolean hasMonster();
    public abstract boolean hasParcel();
    public abstract void removeParcel();
    public abstract void setExit(String direction, Room neighbor);
    public abstract String getShortDescription();
    public abstract String getLongDescription();
    public abstract String getExitString();
    public abstract Room getExit(String direction);
    public abstract void displayImage();
    public abstract void displayDesc();
    public abstract String getImageFilePath();
}
