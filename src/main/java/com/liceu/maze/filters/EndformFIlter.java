package com.liceu.maze.filters;

import com.liceu.maze.model.Player;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;

@WebFilter(urlPatterns = {"/endform"})
public class EndformFIlter extends HttpFilter {
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpSession session = req.getSession();
       String status = (String) session.getAttribute("end");
        if (status == null){
            res.setStatus(401);
            res.sendRedirect("/start");
            return;
        }
        chain.doFilter(req,res);
    }
}
