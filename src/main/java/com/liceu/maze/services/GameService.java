package com.liceu.maze.services;

import com.liceu.maze.model.*;

import java.util.Scanner;
import java.util.stream.IntStream;

public class GameService {
    private static Scanner scanner = new Scanner(System.in);



    public static void play(Maze maze, Player player) {

    }

    public static String go(Player player, Maze.Directions dir) {
        Room room = player.getCurrentRoom();

        MapSite ms = room.getSide(dir);
        String message = ms.enter(player);
        return message;
    }



    public static Maze createMaze() {
        MazeBuilder mazeBuilder = new StandardMazeBuilder();
        IntStream
                .range(1,7)
                .forEach(mazeBuilder::buildRoom);

        Key k1 = new Key("Level1 Key",4);
        Key k2 = new Key("Level2 Key",1);
        Coin c1 = new Coin("Coin 1");

        mazeBuilder.buildDoor(1,2, Maze.Directions.NORTH);
        mazeBuilder.buildDoor(1,4, Maze.Directions.SOUTH);
        mazeBuilder.buildDoor(1,5, Maze.Directions.EAST);

        mazeBuilder.buildDoor(1,3, Maze.Directions.WEST, k2);
        mazeBuilder.buildDoor(5,6, Maze.Directions.EAST, k1);

        mazeBuilder.putKeyInRoom(6, k2);
        mazeBuilder.putKeyInRoom(2, k1);
        mazeBuilder.putCoinInRoom(4,c1);

        mazeBuilder.setTarget(3);

        return mazeBuilder.getMaze();
    }


    public String parseJson(Player player, String message, String havekey,String havecoin) {
        String n = null;
        String s = null;
        String e = null;
        String w = null;
        String norte = player.getCurrentRoom().getSide(Maze.Directions.NORTH).toString();
        if (norte.equals("false")){
            n="close";
        }else if(norte.equals("true")){
            n="open";
        }
        String sur = player.getCurrentRoom().getSide(Maze.Directions.SOUTH).toString();
        if (sur.equals("false")){
            s="close";
        }else if(sur.equals("true")){
            s="open";
        }
        String este = player.getCurrentRoom().getSide(Maze.Directions.EAST).toString();
        if (este.equals("false")){
            e="close";
        }else if(este.equals("true")){
            e="open";
        }
        String west = player.getCurrentRoom().getSide(Maze.Directions.WEST).toString();
        if (west.equals("false")){
            w="close";
        }else if(west.equals("true")){
            w="open";
        }
        String keydisplay = "";
        if (havekey.equals("false")){
            keydisplay = "false";
        }else{
            keydisplay = "true";
        }
        String coindisplay = "";

        if (havecoin.equals("false")){
            coindisplay = "false";
        }else{
            coindisplay = "true";
        }
        System.out.println(player.getItemList());
        String writemessage = message;
        int numkeys = 0;
        int nummonedas = 0;
        for (Item it : player.getItemList()){
            if (it.toString().contains("Key")){
                numkeys++;
            }
            if (it.toString().contains("Coin")){
                nummonedas++;
            }


        }

        String json = "{\n" +
                "          \"n\": \""+n+"\",\n" +
                "          \"s\": \""+s+"\",\n" +
                "          \"w\": \""+w+"\",\n" +
                "          \"e\": \""+e+"\",\n" +
                "          \"roomnumber\": "+player.getCurrentRoom().getNumber()+",\n" +
                "          \"coindisplay\": "+coindisplay+",\n" +
                "          \"keydisplay\": "+keydisplay+",\n" +
                "          \"items\": [{\n" +
                "              \"coins\": "+nummonedas+"\n" +
                "            },\n" +
                "            {\n" +
                "              \"keys\": "+numkeys+"\n" +
                "            }\n" +
                "          ],\n" +
                "          \"message\": \""+writemessage+"\"\n" +
                "        }";
        return json;

    }
}
