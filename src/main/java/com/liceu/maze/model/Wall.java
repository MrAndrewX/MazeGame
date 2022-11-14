package com.liceu.maze.model;

public class Wall implements MapSite{
    @Override
    public void enter(Player player) {
        System.out.println("No puedes pasar, es una pared");
    }
}
