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

@WebServlet("/reset")
public class Reset extends HttpServlet {
    GameService gameService = new GameService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        session.removeAttribute("player");
        session.removeAttribute("maze");
        session.removeAttribute("starttime");

        Date date = new Date();
        session.setAttribute("starttime",date.getTime());
        Player player = new Player();
        session.setAttribute("player", player);
        int mapid = (int) session.getAttribute("mapid");
        Maze maze = new Maze();
        if (mapid == 1) {
            maze = gameService.createMaze();
        }if (mapid == 2){
            maze = gameService.createMaze2();
        }
        session.setAttribute("maze", maze);
        player.setCurrentRoom(maze.getRoom(1));
        String json = gameService.parseJson(player,"Bienvenido, puedes empezar", "false","false", false);
        req.setAttribute("json",json);
        RequestDispatcher dispatcher =
                req.getRequestDispatcher("/WEB-INF/jsp/canvas.jsp");
        dispatcher.forward(req,resp);




    }
}
