package com.ceKHotel.models;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLOutput;
import java.util.Scanner;

import static com.ceKHotel.models.BaseModel.connection;

public class Registrasi extends BaseRegis {
    Scanner input = new Scanner(System.in);

    public Registrasi() throws SQLException {
    }

    public static int tambahCs(String namaCs, String username, String password, String email, String noTelp) throws SQLException, SQLException {
        String query = "INSERT INTO customerService" +
                "(namaCs, username, password, email, noTelpn)" +
                "VALUES (?, ?, ?, ?, ?)";

        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, namaCs);
        preparedStatement.setString(2, username);
        preparedStatement.setString(3, password);
        preparedStatement.setString(4, email);
        preparedStatement.setString(5, noTelp);

        return preparedStatement.executeUpdate();
    }

    @Override
    public void regitrasiCs() throws SQLException {
        HalamanAwal menu = new HalamanAwal();
        try {
            System.out.println("\n\nREGISTRASI");
            System.out.println("\nMasukkan data customer service :");
            System.out.print("Nama       : ");
            String Nama = input.nextLine();
            System.out.print("e-Mail     : ");
            String email = input.nextLine();
            System.out.print("No Telepon : ");
            String telp = input.nextLine();
            System.out.print("Username   : ");
            String user = input.nextLine();
            System.out.print("Password   : ");
            String pass = input.nextLine();
            if (Nama.isEmpty() || user.isEmpty() || pass.isEmpty() || email.isEmpty() || telp.isEmpty()) {
                System.out.println("\nData Tidak Boleh Kosong !");
                menu.kembaliLogin();
            }

            tambahCs(Nama, user, pass, email, telp);
            System.out.println("\nRegistrasi Berhasil !");
        } catch (Exception e) {
            System.out.println("\nERROR: " + e.getMessage());
        }

    }
}