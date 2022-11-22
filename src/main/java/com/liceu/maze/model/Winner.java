package com.liceu.maze.model;

public class Winner {
    private int id;
    private int mapid;
    private String name;
    private long timems;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private String time;

    public long getTimems() {
        return timems;
    }

    public void setTimems(long timems) {
        this.timems = timems;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getMapid() {
        return mapid;
    }

    public void setMapid(int mapid) {
        this.mapid = mapid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
