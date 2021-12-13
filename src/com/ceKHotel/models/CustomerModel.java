package com.ceKHotel.models;

import com.ceKHotel.Exception.noteException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLOutput;
import java.util.Scanner;
import java.sql.ResultSet;

public class CustomerModel extends BaseModel {
    public CustomerModel() throws SQLException {
        super();
    }

    public static void addCustomer() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("\n\nDATA CUSTOMER");
            System.out.println("\nMasukkan data customer :");
            System.out.print("Nama Panggilan  : ");
            String namaCustomer = scanner.next();
            System.out.print("Nomor Telephone : ");
            String noTelepon = scanner.next();
            System.out.print("Alamat          : ");
            String alamat = scanner.next();

            if (namaCustomer.isEmpty() || noTelepon.isEmpty() || alamat.isEmpty()) {
                throw new noteException();
            }

            String queryCustomer = "INSERT INTO CUSTOMER" +
                    " (namaCustomer, noHp, alamatCustomer)" + "" +
                    " VALUES (?, ?, ?)";

            PreparedStatement preparedStatement = connection.prepareStatement(queryCustomer);
            preparedStatement.setString(1, namaCustomer);
            preparedStatement.setString(2, noTelepon);
            preparedStatement.setString(3, alamat);

            preparedStatement.executeUpdate();
            return;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void lihatCustomer() {
        String query = "SELECT * FROM Customer";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();

            System.out.println("\n\n+-------+-------+---------------+---------------+---------------+");
            System.out.println("|                          DATA CUSTOMER                        |");
            System.out.println("+-------+-------+---------------+---------------+---------------+");
            System.out.println("| No    | ID    | Nama          | Nomor HP      | Alamat        |");
            System.out.println("+-------+-------+---------------+---------------+---------------+");

            int nomor = 0;
            while (rs.next()) {
                int idCustomer = rs.getInt("customer_id");
                String namaCstmr = rs.getString("namaCustomer");
                String noTelpCstmr = rs.getString("noHp");
                String alamat = rs.getString("alamatCustomer");
                nomor ++;

                System.out.println(String.format("| %d. \t| %d \t| %s \t| %s \t\t| %s \t\t\t|", nomor, idCustomer, noTelpCstmr, namaCstmr, alamat));
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }
}