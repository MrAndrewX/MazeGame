package com.liceu.maze.model;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private Room currentRoom;

    private List<Item> itemList = new ArrayList<>();
    public void setCurrentRoom(Room currentRoom) {
        System.out.println("Ets a l'habitació: " + currentRoom.getNumber());
        this.currentRoom = currentRoom;
        currentRoom.enter(this);
    }

    public void addItem(Item it) {
        this.itemList.add(it);
    }

    public List<Item> getItemList() {
        return this.itemList;
    }

    public Room getCurrentRoom() {
        return this.currentRoom;
    }
    public int getCoinsPlayer(Player player){
        int numcoins = 0;
        for (Item it : player.getItemList()){
            if (it.toString().contains("Coin")){
                numcoins++;
            }
        }
        return numcoins;
    }
    public void restarCoins(Player player,int coins){
        int limitreacher = 0;
        for(Item it : player.getItemList()){
            if (it instanceof Coin){
                player.getItemList().remove(it);
                limitreacher++;
                if (limitreacher == coins){
                    break;
                }
            }
        }
    }


}
