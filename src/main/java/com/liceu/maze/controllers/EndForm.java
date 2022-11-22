package com.liceu.maze.controllers;

import com.liceu.maze.services.WinnerService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

@WebServlet("/endform")
public class EndForm extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        long starttime = (long) session.getAttribute("starttime");
        long endtime = (long) session.getAttribute("endtime");

        long finaldate = endtime - starttime;
        session.setAttribute("finaltime",finaldate);

        SimpleDateFormat formatter= new SimpleDateFormat("HH:mm:ss.SSS");
        formatter.setTimeZone(TimeZone.getTimeZone("UTC"));
        String formatted = formatter.format(finaldate);

        session.setAttribute("time",formatted);
        req.setAttribute("time",formatted);
        RequestDispatcher dispatcher =
                req.getRequestDispatcher("/WEB-INF/jsp/endform.jsp");
        dispatcher.forward(req,resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        WinnerService ws = new WinnerService();
        HttpSession session = req.getSession();
        session.getAttribute("mapid");
        session.getAttribute("starttime");
        String username = req.getParameter("username");
        int mapid = (int) session.getAttribute("mapid");
        long finaltime = (long) session.getAttribute("finaltime");
        String timeverbose = (String)session.getAttribute("time");
        try {
            ws.newFigure(username,mapid,finaltime,timeverbose);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    resp.sendRedirect("/winners");
    }

}
