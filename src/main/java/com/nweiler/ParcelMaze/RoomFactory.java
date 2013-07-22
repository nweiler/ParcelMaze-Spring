package com.nweiler.ParcelMaze;

import java.util.HashMap;

public class RoomFactory {
   
    public SimpleRoom createRoom(String name, String type, String description, 
            String imageFilePath, int hasParcel, int hasMonster) {
        if(name.equals("outside")) {
            return new SimpleRoom(name, description, 
                    imageFilePath, 0, 0);
        }
        if(type.equals("room")) {
            return new SimpleRoom(name, description, 
                    imageFilePath, hasParcel, hasMonster);
        }
        else {
            return null;
        }
    }     
}