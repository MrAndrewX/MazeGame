package com.liceu.maze.controllers;

import com.liceu.maze.model.Maze;
import com.liceu.maze.model.Player;
import com.liceu.maze.services.GameService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;

@WebServlet("/nav")
public class Nav extends HttpServlet {
    GameService gameService = new GameService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Player player = (Player) session.getAttribute("player");
        Maze maze = (Maze) session.getAttribute("maze");

        String direction = req.getParameter("dir");
        if (direction == null){


            RequestDispatcher dispatcher =
                    req.getRequestDispatcher("/WEB-INF/jsp/canvas.jsp");
            dispatcher.forward(req,resp);
        }
        System.out.println("dir :" + direction);

        Maze.Directions dir = dirparse(direction);



            String message = gameService.go(player, dir);

        String havekey = "false";
        int numcoins = 0;

        if (player.getCurrentRoom().haveKey){

            havekey = "true";
        }
        String havecoin = "false";
        if (player.getCurrentRoom().haveCoin){
            havecoin = "true";
        }
        System.out.println("Tiene key?: " + havekey);

        boolean end = false;
        if (player.getCurrentRoom().isTarget()){
            session.setAttribute("end","end");
            message = "Final." +
                    " Haz click para continuar";
            end=true;
            Date date = new Date();
            session.setAttribute("endtime",date.getTime());


        }







            String json = gameService.parseJson(player,message,havekey,havecoin,end);

        req.setAttribute("json",json);
        RequestDispatcher dispatcher =
                req.getRequestDispatcher("/WEB-INF/jsp/canvas.jsp");
        dispatcher.forward(req,resp);
    }

    public static Maze.Directions dirparse(String direction) {
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
