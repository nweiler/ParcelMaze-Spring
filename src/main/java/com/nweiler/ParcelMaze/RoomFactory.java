package com.nweiler.ParcelMaze;


public class RoomFactory {
   
    public SimpleRoom createRoom(String name, String type, String description, 
            String imageFilePath, int hasParcel, int hasMonster) {
        if(type.equals("room")) {
            return new SimpleRoom(name, description, 
                    imageFilePath, hasParcel, hasMonster);
        }
        else {
            return null;
        }
    }     
}