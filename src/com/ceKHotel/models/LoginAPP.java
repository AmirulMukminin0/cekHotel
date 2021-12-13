package com.ceKHotel.models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;
import java.util.Scanner;

import static com.ceKHotel.models.BaseModel.connection;

public class LoginAPP implements Login{
    Scanner input = new Scanner(System.in);

    public LoginAPP() throws SQLException {
        super();
    }

    public static void Login(String username, String password) throws SQLException {
        halamanMenu menu = new halamanMenu();
        HalamanAwal menu1 = new HalamanAwal();
        String query = "SELECT * FROM customerService where username = '" + username + "' AND password = '" + password + "'";
        ResultSet res;
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            res = stmt.executeQuery();
            if (res.next()) {
                String Un = res.getString("username");
                String pw = res.getString("password");
                if (Objects.equals(Un, username) && Objects.equals(pw, password)) {
                    System.out.println("\nLogin Anda telah berhasil!");
                    menu.menuHotel();
                }
            } else {
                System.out.println("\nUsername atau password yang Anda masukkan salah !");
                menu1.kembaliLogin();
            }
        } catch (SQLException e) {
            System.out.println("Terdapat Kesalahan : " + e.getMessage());
        }
    }

    public void loginCs() throws SQLException {
        System.out.println("\n\nLOGIN");
        System.out.println("\nSilahkan masukkan username dan password Anda!");
        System.out.print("Masukkan Username : ");
        String username = input.next();
        System.out.print("Masukkan Password : ");
        String password = input.next();

        Login(username, password);
    }
}