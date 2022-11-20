package com.liceu.maze.model;

public class Coin implements Item{
private String name;

    public Coin(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Coin{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public int getCost() {
        return 0;
    }
}
