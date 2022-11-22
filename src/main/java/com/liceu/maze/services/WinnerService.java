package com.liceu.maze.services;

import com.liceu.maze.DAO.DB.WinnerDAODB;
import com.liceu.maze.DAO.WinnerDAO;
import com.liceu.maze.model.Winner;

import java.sql.SQLException;
import java.util.List;

public class WinnerService {
    WinnerDAO winnerDAO = new WinnerDAODB();
    public void newFigure(String username, int mapid, long finaltime, String time) throws SQLException {
        Winner winner = new Winner();
        winner.setName(username);
        winner.setMapid(mapid);
        winner.setTimems(finaltime);
        winner.setTime(time);
        winnerDAO.insert(winner);



    }
    public List<Winner> getWinners() throws SQLException {
        return winnerDAO.getWinners();
    }
}
