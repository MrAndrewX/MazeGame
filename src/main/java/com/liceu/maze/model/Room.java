package com.liceu.maze.model;

import java.util.HashMap;
import java.util.Map;

public class Room {
    int number;
    Item item;
    boolean target = false;
    private Map<Maze.Directions, MapSite> sides = new HashMap<>();

    public MapSite getSide(Maze.Directions dir) {
        return this.sides.get(dir);
    }

    public void setSide(Map<Maze.Directions, MapSite> sides) {
        this.sides = sides;
    }

    public Room(int number){
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public boolean isTarget() {
        return target;
    }

    public void setTarget(boolean target) {
        this.target = target;
    }
    public void enter(Player player) {
        if (this.item != null) {
            System.out.println("Has obtingut un ítem: " + this.item.toString());
            player.addItem(this.item);
            this.item = null;
        }
    }

    public void setSide(Maze.Directions dir, MapSite ms) {
        this.sides.put(dir, ms);
    }

}
