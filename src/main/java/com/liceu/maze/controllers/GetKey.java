package com.liceu.maze.controllers;

import com.liceu.maze.model.Item;
import com.liceu.maze.model.Maze;
import com.liceu.maze.model.Player;
import com.liceu.maze.model.Room;
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
        int nummonedas = 0;
        for (Item it : player.getItemList()){

            if (it.toString().contains("Coin")){
                nummonedas++;
            }
        }



        if (player.getCurrentRoom().haveKey){
            if (nummonedas >= player.getCurrentRoom().getKeyCost()){
                System.out.println("monedas insuficientes");
                String json = gameService.parseJson(player, "Monedas insuficientes!", "true", "false");
                req.setAttribute("json", json);
                player.getCurrentRoom().setHaveKey(true);
                RequestDispatcher dispatcher =
                        req.getRequestDispatcher("/WEB-INF/jsp/canvas.jsp");
                dispatcher.forward(req, resp);

            }else {

                player.getCurrentRoom().getKey(player);
                String json = gameService.parseJson(player, "Has recogido una llave!", "false", "false");
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

