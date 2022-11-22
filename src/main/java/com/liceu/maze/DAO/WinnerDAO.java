package com.liceu.maze.DAO;

import com.liceu.maze.model.Winner;

import java.sql.SQLException;
import java.util.List;

public interface WinnerDAO {
    boolean insert(Winner winner) throws SQLException;
    public List<Winner> getWinners() throws SQLException;
}
