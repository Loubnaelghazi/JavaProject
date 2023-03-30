package com.example.esalaf;
import java.sql.PreparedStatement;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
public class Conection {
    public Connection conection ;
    protected Statement statement ;
    protected PreparedStatement preparedStatement ;
    protected ResultSet resultSet;

    private static final String DB_URL = "jdbc:mysql://localhost:3306/esalaf";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "";

    public static Conection getConection() throws SQLException {
        return (Conection) DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
    }



}
//copie ce code pour appelr had zmr
