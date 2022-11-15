package com.liceu.maze.services;

import com.liceu.maze.model.*;

import java.util.Scanner;
import java.util.stream.IntStream;

public class GameService {
    private static Scanner scanner = new Scanner(System.in);
    
    Maze mapa1 = createMaze();
    Player player = new Player();

    private static void play(Maze maze, Player player) {
        player.setCurrentRoom(maze.getRoom(1));
        while(!player.getCurrentRoom().isTarget()) {
            Maze.Directions dir = askUser();
            go(player, dir);
        }
    }
    private static void go(Player player, Maze.Directions dir) {
        Room room = player.getCurrentRoom();
        MapSite ms = room.getSide(dir);
        ms.enter(player);
    }

    private static Maze.Directions askUser() {
        System.out.println("Cap a on vols anar? (N,S,E,W)");
        while(true) {
            String line = scanner.nextLine();
            if (line.length() > 0) {
                char c = line.toUpperCase().charAt(0);
                switch(c) {
                    case 'N': return Maze.Directions.NORTH;
                    case 'S': return Maze.Directions.SOUTH;
                    case 'E': return Maze.Directions.EAST;
                    case 'W': return Maze.Directions.WEST;
                }
            }
        }
    }

    private Maze createMaze() {
    MazeBuilder mazeBuilder = new StandardMazeBuilder();
        IntStream
                .range(1,7)
                .forEach(mazeBuilder::buildRoom);

        Key k1 = new Key("Key1");
        mazeBuilder.buildDoor(1,2, Maze.Directions.NORTH);
        mazeBuilder.buildDoor(1,3, Maze.Directions.SOUTH);
        mazeBuilder.buildDoor(1,4, Maze.Directions.EAST);
        mazeBuilder.buildDoor(1,5, Maze.Directions.WEST, k1);
        mazeBuilder.putKeyInRoom(4,k1);
        mazeBuilder.setTarget(5);
        return mazeBuilder.getMaze();


    }
}
