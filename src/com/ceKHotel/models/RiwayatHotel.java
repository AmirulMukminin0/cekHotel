package com.ceKHotel.models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RiwayatHotel extends BaseModel{

    public RiwayatHotel() throws SQLException {
        super();
    }

    public static void getRiwayatHotel() throws SQLException {
        String query = "SELECT detailHotel.customer_customer_id, Customer.namaCustomer, noHp, detailHotel.lamaMenginap FROM Customer JOIN detailHotel ON Customer.customer_id = detailHotel.customer_customer_id";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            System.out.println("\n+----------------------------------------------------------------------------+");
            System.out.println("|                            DAFTAR RIWAYAT HOTEL                            |");
            System.out.println("+====+===============+===================+==================+================+");
            System.out.println("| No | ID Customer   | Customer          | Nomor HP         | Lama Menginap  |");
            System.out.println("+====+===============+===================+==================+================+");

            int n = 1;
            while (resultSet.next()) {
                int idCustomer = resultSet.getInt("customer_customer_id");
                String namaCustomer = resultSet.getString("namaCustomer");
                String noTelpCustomer = resultSet.getString("noHp");
                int lamaMenginap = resultSet.getInt("lamaMenginap");
                int nomor = n ++;

                System.out.println(String.format("| %d  | %s \t\t\t | %s \t\t | %s \t| %s Hari \t\t |", nomor,idCustomer, namaCustomer, noTelpCustomer, lamaMenginap));
                System.out.println("+----+---------------+-------------------+------------------+----------------+");
            }
        } catch (SQLException exception) {
            System.out.println("ERROR: " + exception.getMessage());
        }
    }
}