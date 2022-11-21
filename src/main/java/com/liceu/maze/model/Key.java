package com.liceu.maze.model;

import java.util.ArrayList;
import java.util.List;

public class Key implements Item{
    private List<Door> doors = new ArrayList<>();
    private String name;
    private int cost;

    public Key() {

    }

    public List<Door> getDoors() {
        return doors;
    }

    public Key(String name, int cost) {
        this.name = name;
        this.cost = cost;
    }

    public void addDoor(Door d) {
        this.doors.add(d);
    }

    public void open(Door door) {
        this.doors
                .stream()
                .filter(d -> d.equals(door))
                .forEach(Door::open);
    }



    @Override
    public String toString() {
        return "Key{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public int getCost() {
        return cost;
    }

    public boolean getDoorKey(Door door, List<Item> itemList) {
        for (Item it : itemList){

            if (it instanceof Key){
                Key key = (Key) it;
                if (key.getDoors().contains(door)){
                    return true;
                }
            }
        }
        return false;
    }
}
