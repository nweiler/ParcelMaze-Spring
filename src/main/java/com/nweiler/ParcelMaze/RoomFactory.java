package com.nweiler.ParcelMaze;

public class RoomFactory {
   
    public StandardRoom createRoom(String name, String type, String description, 
            String imageFilePath, boolean hasParcel, boolean hasMonster) {
        if(type.equals("room")) {
            return new StandardRoom(name, description, imageFilePath, hasParcel, hasMonster);
        }
        else {
            return null;
        }
    }     
}