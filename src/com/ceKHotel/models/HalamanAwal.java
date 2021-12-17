package com.ceKHotel.models;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class HalamanAwal {
    static Scanner scan = new Scanner(System.in);
    public static void LoginHotel() throws SQLException {
        Registrasi reg = new Registrasi();
        LoginAPP log = new LoginAPP();

        System.out.println("======================================================");
        System.out.println("      SILAHKAN LOGIN/REGISTRASI TERLEBIH DAHULU!      ");
        System.out.println("======================================================");
        System.out.print("\nMENU : \n1. Login \n2. Registrasi \n0. Keluar \n\nPilihan Anda : ");
        Integer open = scan.nextInt();
        if (open == 0) {
            System.out.println("\n-------------------------------------------------------------");
            System.out.println("                 Anda telah berhasil keluar!                 ");
            System.exit(0);
        } if (open == 1) {
            log.loginCs();
        } if (open == 2) {
            reg.registrasiCs();
            halamanMenu.menuHotel();
        } else {
            System.out.println("\nPilihan Anda tidak ada dalam menu!");
            kembaliLogin();
        }
    }

    public static void kembaliKeMenu() throws SQLException {
        System.out.println("\nTekan Enter Untuk Kembali!");
        try {
            System.in.read();
            halamanMenu.menuHotel();
        } catch (IOException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }

    public static void kembaliLogin() throws SQLException {
        System.out.println("\nTekan Enter Untuk Kembali!");
        try {
            System.in.read();
            LoginHotel();
        } catch (IOException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }


}
