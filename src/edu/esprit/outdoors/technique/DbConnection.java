/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.outdoors.technique;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Mehdi
 */
public class DbConnection {

    private final String url = "jdbc:mysql://localhost:3306/outdoors";
    private final String login = "root";
    private final String password = "";
    private Connection connection;
    private static DbConnection dbConnection;

    private DbConnection() {
        try {
            connection = DriverManager.getConnection(url, login, password);
        } catch (SQLException e) {
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public static DbConnection getInstance() {
        if (dbConnection == null) {
            dbConnection = new DbConnection();
        }
        return dbConnection;
    }
}
