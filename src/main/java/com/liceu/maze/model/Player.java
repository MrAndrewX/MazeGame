package com.liceu.maze.model;

import java.util.ArrayList;
import java.util.List;

public class Player {
    Room currentroom;
    List<Item> itemList = new ArrayList<>();

    public void setCurrentRoom(Room currentroom) {
        System.out.println("Estas en habitacion: "+ currentroom.getNumber());
        this.currentroom = currentroom;
        currentroom.enter(this);
    }

    public void addItem(Item item) {
        this.itemList.add(item);
    }

    public List<Item> getItemList() {
        return this.itemList;
    }

    public Room getCurrentRoom() {
        return this.currentroom;
    }
}
