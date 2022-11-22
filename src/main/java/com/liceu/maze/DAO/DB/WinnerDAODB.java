package com.liceu.maze.DAO.DB;


import com.liceu.maze.DAO.WinnerDAO;
import com.liceu.maze.model.Winner;
import com.liceu.maze.utils.MySqlDatabase;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class WinnerDAODB implements WinnerDAO {

    @Override
    public boolean insert(Winner winner) throws SQLException {
        Connection con = MySqlDatabase.getConnection();
        PreparedStatement preparedStatement = con
                .prepareStatement("INSERT INTO winners (username, mapa, timems, time) " +
                        "VALUES (?, ?, ?, ?)");
        preparedStatement.setString(1, winner.getName());
        preparedStatement.setInt(2,winner.getMapid());
        preparedStatement.setLong(3,winner.getTimems());
        preparedStatement.setString(4,winner.getTime());
        preparedStatement.executeUpdate();
        return true;


    }

    @Override
    public List<Winner> getWinners() throws SQLException {
        List<Winner> winnerList = new ArrayList<>();
        Connection con = MySqlDatabase.getConnection();
        Statement stmt = con.createStatement();
        ResultSet resultSet = stmt.executeQuery("select * from winners order by timems ASC");
        while (resultSet.next()){
            int id = resultSet.getInt(1);
            String username = resultSet.getString(2);
            int mapid = resultSet.getInt(3);
            long timems = resultSet.getLong(4);
            String timeverbose = resultSet.getString(5);
            Winner winner = new Winner();
            winner.setId(id);
            winner.setName(username);
            winner.setTimems(timems);
            winner.setMapid(mapid);
            winner.setTime(timeverbose);
            winnerList.add(winner);
        }
        return winnerList;
    }
}
