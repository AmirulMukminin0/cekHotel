package com.ceKHotel.models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerService extends BaseModel{

    public CustomerService() throws SQLException {
        super();
    }

    public static ResultSet getDataCs() throws SQLException {
        String query = "SELECT * FROM customerService";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();

            System.out.println("\nCUSTOMER SERVICE : ");

            while (rs.next()){
                int idCs = rs.getInt("cs_id");
                String namaCs = rs.getString("namacs");

                System.out.println(String.format("%d. %s", idCs, namaCs));
            }

            return preparedStatement.executeQuery();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return null;
    }
}