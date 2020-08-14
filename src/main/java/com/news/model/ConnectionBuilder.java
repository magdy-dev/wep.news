package com.news.model;

import java.sql.*;

public class ConnectionBuilder {

    private static Connection connection;
// it is how to make connection with database
    static {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/news", "postgres", "123456");
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        return connection;
    }
}
