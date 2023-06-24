package com.leanersacademy.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    private static ConnectionFactory instance = null;
    private final String url = "jdbc:mysql://localhost:3306/leanersacademy";
    private final String user = "root";
    private final String password = "friendship87";

    private ConnectionFactory(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    public static ConnectionFactory getInstance(){
        if (instance == null){
            synchronized (ConnectionFactory.class){
                if(instance == null){
                    instance = new ConnectionFactory();
                }
            }
        }
        return instance;
    }

    public Connection getConnection(){
        try{
            return DriverManager.getConnection(url, user, password);
        }catch(SQLException e){
            throw new RuntimeException("Error Connecting To Database", e);
        }
    }
}
