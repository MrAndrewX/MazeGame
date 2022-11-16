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

@WebServlet("/start")
public class Start extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher =
                req.getRequestDispatcher("/WEB-INF/jsp/selectmaze.jsp");
        dispatcher.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        GameService gameService = new GameService();
        Player player = new Player();
        Maze maze = gameService.createMaze();
        session.setAttribute("player",player);
        session.setAttribute("maze",maze);
        player.setCurrentRoom(maze.getRoom(1));

        String json = gameService.parseJson(player);
        req.setAttribute("json",json);
            RequestDispatcher dispatcher =
                    req.getRequestDispatcher("/WEB-INF/jsp/canvas.jsp");
            dispatcher.forward(req,resp);

    }

}
