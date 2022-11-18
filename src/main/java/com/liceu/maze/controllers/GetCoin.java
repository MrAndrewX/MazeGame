package com.liceu.maze.controllers;

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

@WebServlet("/getcoin")
public class GetCoin extends HttpServlet {
    GameService gameService = new GameService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Player player = (Player) session.getAttribute("player");
        if (player.getCurrentRoom().haveCoin){
            player.getCurrentRoom().getCoin(player);
            String json = gameService.parseJson(player,"Has recogido una Moneda!", "false","false");
            player.getCurrentRoom().setHaveCoin(false);
            req.setAttribute("json",json);
            RequestDispatcher dispatcher =
                    req.getRequestDispatcher("/WEB-INF/jsp/canvas.jsp");
            dispatcher.forward(req,resp);
        }else{
            resp.sendError(HttpServletResponse.SC_FORBIDDEN, "No puedes obtener una moneda si no hay en la habitacion");
        }
    }
}
