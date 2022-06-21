package com.example.worldoftitan.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SqlConnector {
    private static Connection connection;

    public static Connection getConnection() {
        connect();
        return connection;
    }

    private static void connect() {
        try {
            tryToConnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void tryToConnect() throws SQLException {
        String databaseName = "attack_on_titan";
        String url = "jdbc:mysql://localhost/" + databaseName;
        String username = "root";
        String password = "root";
        connection = DriverManager.getConnection(url, username, password);
    }
}
