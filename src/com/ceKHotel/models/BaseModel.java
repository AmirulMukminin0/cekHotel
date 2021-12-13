package com.ceKHotel.models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseModel {
    private String dbUrl = "jdbc:postgresql://localhost/cekHotel";
    private String dbUser = "postgres";
    private String dbPassword = "sempaklepis123";
    public static Connection connection;

   public BaseModel()throws SQLException{
        connection = DriverManager.getConnection(dbUrl,dbUser,dbPassword);
   }
}