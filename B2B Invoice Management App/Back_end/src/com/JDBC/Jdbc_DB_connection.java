package com.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Jdbc_DB_connection {
    public static Connection createConnection() throws ClassNotFoundException {
        Connection con = null;

        String url = "jdbc:mysql://localhost:3306/grey_goose?zeroDateTimeBehavior=convertToNull";
        String username = "root";
        String password = "root";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, username, password);
            System.out.println("Connected!");
        } catch (SQLException err) {
            System.out.println("Error " + err.getMessage());
        }

        return con;
      }
}