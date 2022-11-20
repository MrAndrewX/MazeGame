package com.liceu.maze.model;

public class Wall implements MapSite{
    @Override
    public String enter(Player player) {

        return "Es una pared," +
                "No puedes pasar";
    }



}
