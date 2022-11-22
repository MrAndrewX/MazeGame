package com.liceu.maze.controllers;

import com.liceu.maze.model.*;
import com.liceu.maze.services.GameService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/open")
public class Open extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Player player = (Player) session.getAttribute("player");
        Maze maze = (Maze) session.getAttribute("maze");
        GameService gameService = new GameService();
        String direction = req.getParameter("dir");
        if (direction == null){


            RequestDispatcher dispatcher =
                    req.getRequestDispatcher("/WEB-INF/jsp/canvas.jsp");
            dispatcher.forward(req,resp);
        }
        Maze.Directions dir = dirparse(direction);


        String havekey = "false";
        int numcoins = 0;

        if (player.getCurrentRoom().haveKey){

            havekey = "true";
        }
        String havecoin = "false";
        if (player.getCurrentRoom().haveCoin){
            havecoin = "true";
        }

       Room room = player.getCurrentRoom();
        Door door = (Door) room.getSide(dirparse(direction));
        Key key = new Key();
        String msg = "";
        if (door.isOpen()){

        }else {
            if(key.getDoorKey(door, player.getItemList())) {
                door.open();
                msg = "Has abierto una puerta";
            } else {
                msg = "No tienes la llave";
            }
        }
        String json = gameService.parseJson(player,msg,havekey,havecoin, false);

        req.setAttribute("json",json);
        RequestDispatcher dispatcher =
                req.getRequestDispatcher("/WEB-INF/jsp/canvas.jsp");
        dispatcher.forward(req,resp);



    }
    public Maze.Directions dirparse(String direction) {
        if (direction.equals("N")){
            return Maze.Directions.NORTH;
        }else
        if (direction.equals("S")){
            return Maze.Directions.SOUTH;
        }else
        if (direction.equals("E")){
            return Maze.Directions.EAST;
        }else
        if (direction.equals("W")){
            return Maze.Directions.WEST;
        }
        return Maze.Directions.NORTH;

    }
}
