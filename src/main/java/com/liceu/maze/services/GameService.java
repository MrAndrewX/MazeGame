package com.liceu.maze.services;

import com.liceu.maze.model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class GameService {



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

        Key k1 = new Key("Level1 Key",1);
        Key k2 = new Key("Level2 Key",0);
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
    public Maze createMaze2() {
        MazeBuilder mazeBuilder = new StandardMazeBuilder();
        IntStream
                .range(1,9)
                .forEach(mazeBuilder::buildRoom);
        Key k1 = new Key("k1",2);
        Key k2 = new Key("k2",0);
        Coin coin = new Coin("Coin 1");
        Coin coin2 = new Coin("Coin 2");
        mazeBuilder.buildDoor(1,2, Maze.Directions.EAST,k1);
        mazeBuilder.buildDoor(1,5, Maze.Directions.WEST);
        mazeBuilder.buildDoor(2,3, Maze.Directions.SOUTH);
        mazeBuilder.buildDoor(3,4, Maze.Directions.WEST);
        mazeBuilder.buildDoor(5,6, Maze.Directions.NORTH);
        mazeBuilder.buildDoor(6,7, Maze.Directions.WEST);
        mazeBuilder.buildDoor(7,8, Maze.Directions.WEST,k2);
        mazeBuilder.putKeyInRoom(5,k1);
        mazeBuilder.putKeyInRoom(4,k2);
        mazeBuilder.putCoinInRoom(6,coin);
        mazeBuilder.putCoinInRoom(7,coin2);
        mazeBuilder.setTarget(8);


        return mazeBuilder.getMaze();


    }


    public String parseJson(Player player, String message, String havekey, String havecoin, boolean end) {


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
        List<Key> keylist = new ArrayList<>();
        for (Item it : player.getItemList()){
            if (it instanceof Key){
                keylist.add((Key) it);
            }
            if (it.toString().contains("Coin")){
                nummonedas++;
            }


        }
        System.out.println(keylist);
        String keyListstr = keylist.toString();


        String json = "{\n" +
                "          \"end\": \""+end+""+"\",\n" +
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
                "              \"keys\": \""+keyListstr+"\"\n" +
                "            }\n" +
                "          ],\n" +
                "          \"message\": \""+writemessage+"\"\n" +
                "        }";
        return json;

    }


}
