package com.liceu.maze.model;

import java.util.List;

public class Door implements  MapSite{
    private Room r1, r2;
    private boolean open = false;

    public Door(Room r1, Room r2) {
        this.r1 = r1;
        this.r2 = r2;
    }

    public void open() {
        this.open = true;
    }

    public boolean isOpen() {
        return this.open;
    }


    @Override
    public String toString() {
        return open+"";
    }

    @Override
    public String enter(Player player) {
        if (!this.open) {
          return "Esta cerrada";


        }else{

            Room r = getOtherRoom(player.getCurrentRoom());
            player.setCurrentRoom(r);



        }
        return "";
    }




    private Room getOtherRoom(Room currentRoom) {
        if (r1.getNumber() == currentRoom.getNumber()) {
            return r2;
        }
        return r1;
    }
}
