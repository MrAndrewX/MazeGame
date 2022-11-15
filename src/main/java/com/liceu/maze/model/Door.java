package com.liceu.maze.model;

import java.util.List;

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
        if (!this.open) {
            List<Item> items = player.getItemList();
            items.stream()
                    .filter(i -> i instanceof Key)
                    .map(i -> (Key) i)
                    .forEach(k -> k.open(this));
        }

        if (this.open) {
            Room r = getOtherRoom(player.getCurrentRoom());
            player.setCurrentRoom(r);
        } else {
            System.out.println("No pots obrir la porta, encara");
        }
    }
    private Room getOtherRoom(Room currentRoom) {
        if (r1.getNumber() == currentRoom.getNumber()) {
            return r2;
        }
        return r1;
    }
}
