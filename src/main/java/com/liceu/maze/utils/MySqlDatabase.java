package com.liceu.geom.DAO;

import java.sql.Connection;
import java.sql.DriverManager;

public class MySqlDatabase {
    static Connection connection;

    static Connection getConnection(){
        if (connection != null) return connection;
        try {
            Class.forName("con.mysql.cj.jdbc.Driver").newInstance();
            connection = DriverManager.getConnection("jdbc:mysql://mysql:3306/game", "root", "root");
            return connection;
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
