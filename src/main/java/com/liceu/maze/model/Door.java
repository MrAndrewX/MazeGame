package com.liceu.maze.model;

public class Door implements  MapSite{
    boolean open = false;

    public void open() {
        this.open = true;
    }

    Room r1,r2;
    public Door(Room r1, Room r2) {
        this.r1 = r1;
        this.r2 = r2;
    }
    @Override
    public void enter(Player player) {

    }
}
