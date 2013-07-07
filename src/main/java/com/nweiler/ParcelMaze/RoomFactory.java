package com.nweiler.ParcelMaze;

public class RoomFactory {
   
    public StandardRoom createRoom(String type, String description, 
            String imageFilePath, boolean hasParcel, boolean hasMonster) {
        if(type.equals("room")) {
            return new StandardRoom(description, imageFilePath, hasParcel, hasMonster);
        }
        else {
            return null;
        }
    }     
}