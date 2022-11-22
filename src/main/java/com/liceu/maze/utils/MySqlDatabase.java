package com.liceu.maze.utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class MySqlDatabase {
    static Connection connection;

    public static Connection getConnection(){
        if (connection != null) return connection;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            connection = DriverManager.getConnection("jdbc:mysql://mysql:3306/game", "root", "root");
            return connection;
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
