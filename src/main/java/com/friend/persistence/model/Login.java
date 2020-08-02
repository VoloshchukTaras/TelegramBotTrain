package com.friend.persistence.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Login {
    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;

    public Login(){
        try{
            Class.forName("com.postgresql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:1991/FriendBot",
                    "postgres","Vtaras1991scorpionV");
            statement = connection.createStatement();


        }catch (Exception e){
            System.out.println("Error: " + e);
        }
    }
}
