package com.nweiler.ParcelMaze;


public class Main {

    /** 
    * Make a Game playable from the command line. 
    */
    public static void main(String[] args) {
        Maze maze = Maze.getInstance();
        maze.createRooms("com/nweiler/ParcelMaze/roomData.txt");
        maze.play();
    }
}
