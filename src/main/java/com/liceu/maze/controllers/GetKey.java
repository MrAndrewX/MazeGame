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

@WebServlet("/getkey")
public class GetKey extends HttpServlet {
    GameService gameService = new GameService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Player player = (Player) session.getAttribute("player");
        Maze maze = (Maze) session.getAttribute("maze");



        if (player.getCurrentRoom().haveKey){
            System.out.println("Monedas del jugador: "+player.getCoinsPlayer(player));
            System.out.println("Coste de la llave de la habitacion: " + player.getCurrentRoom().getKeyCost());
            if (player.getCoinsPlayer(player) < player.getCurrentRoom().getKeyCost()){
                System.out.println("No puedes obtener esta llave");

                String json = gameService.parseJson(player, "No tienes monedas suficientes", "true", "false", false);


                req.setAttribute("json", json);
                RequestDispatcher dispatcher =
                        req.getRequestDispatcher("/WEB-INF/jsp/canvas.jsp");
                dispatcher.forward(req, resp);
            }
            else{
                player.restarCoins(player,player.getCurrentRoom().getKeyCost());
                player.getCurrentRoom().getKey(player);
                String json = gameService.parseJson(player, "Has recogido una llave!", "false", "false", false);
                player.getCurrentRoom().setHaveKey(false);

                req.setAttribute("json", json);

                RequestDispatcher dispatcher =
                        req.getRequestDispatcher("/WEB-INF/jsp/canvas.jsp");
                dispatcher.forward(req, resp);
            }

        }else{
            resp.sendError(HttpServletResponse.SC_FORBIDDEN, "No puedes obtener una llave si no hay en la habitacion");
        }

    }
}

