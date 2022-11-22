package com.liceu.maze.controllers;

import com.liceu.maze.services.WinnerService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/winners")
public class Winners extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        WinnerService ws = new WinnerService();
        try {
            System.out.println(ws.getWinners());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            req.setAttribute("winners", ws.getWinners());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        RequestDispatcher dispatcher =
                req.getRequestDispatcher("/WEB-INF/jsp/winners.jsp");
        dispatcher.forward(req,resp);
    }
}
