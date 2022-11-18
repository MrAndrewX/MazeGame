package com.liceu.maze.model;

import java.util.HashMap;
import java.util.Map;

public class Room {
    public boolean haveKey;
    public boolean haveCoin;
    private int number;
    private Item item;

    private boolean target = false;

    public Map<Maze.Directions, MapSite> sides = new HashMap<>();

    public Room(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public boolean isTarget() {
        return target;
    }

    public void setTarget(boolean target) {
        this.target = target;
    }

    public void setItem(Item it) {
        this.item = it;
    }

    public MapSite getSide(Maze.Directions dir) {
        return this.sides.get(dir);
    }

    public void setSide(Maze.Directions dir, MapSite ms) {
        this.sides.put(dir, ms);
    }

    public void setHaveCoin(boolean haveCoin) {
        this.haveCoin = haveCoin;
    }

    public void setHaveKey(boolean haveKey) {
        this.haveKey = haveKey;
    }

    public void enter(Player player) {
        if (this.item instanceof Key) {

            player.getCurrentRoom().haveKey = true;

        }
        if (this.item instanceof Coin){
            player.getCurrentRoom().haveCoin = true;
        }


    }
    public void getKey(Player player){

            player.addItem(this.item);
            this.item = null;

    }
    public void getCoin(Player player){

        player.addItem(this.item);
        this.item = null;

    }
}
