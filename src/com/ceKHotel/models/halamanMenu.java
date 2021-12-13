package com.ceKHotel.models;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class halamanMenu {
    static Scanner scan = new Scanner(System.in);

    public static void menuHotel() throws SQLException {
        System.out.println("\n\n======================================================");
        System.out.println("------------- SELAMAT DATANG DI CEKHOTEL -------------");
        System.out.println("======================================================");
        System.out.print("\nMENU: \n1. Menambah Data Pesanan Hotel deLight \n2. Melihat Data Riwayat Pesanan Hotel deLight \n3. Menghapus Data Pesanan Hotel deLight \n0. Keluar \n\nPilihan Anda : ");
        Integer menu = scan.nextInt();
        switch (menu) {
            case 0:
                System.out.println("------------------------------------------------------");
                System.out.println("              Anda telah berhasil Keluar!             ");
                System.out.println("------------------------------------------------------");
                HalamanAwal.LoginHotel();
                break;
            case 1:
                menuBuatPesananKamar();
                HalamanAwal.kembaliKeMenu();
            case 2:
                menuLihatPesananKamar();
                HalamanAwal.kembaliKeMenu();
            case 3:
                menuHapusPesananKamar();
                HalamanAwal.kembaliKeMenu();
            default:
                System.out.println("Pilihan Anda tidak ada dalam menu!");
                HalamanAwal.kembaliKeMenu();
        }
    }

    public static void menuBuatPesananKamar() throws SQLException {
        try {
            System.out.print("\033[H\033[2J");
            System.out.flush();
            Transaksi Hotel = new Transaksi();
            Hotel.Transaksi();
        } catch (SQLException exception) {
            System.out.println("ERROR : " + exception.getMessage());
            HalamanAwal.kembaliKeMenu();
        }
    }

    public static void menuLihatPesananKamar () throws SQLException {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        try {
            RiwayatHotel rwythotel = new RiwayatHotel();
            rwythotel.getRiwayatHotel();
        } catch (SQLException exception) {
            System.out.println("ERROR : " + exception.getMessage());
            HalamanAwal.kembaliKeMenu();
        }
    }

    public static void menuHapusPesananKamar () throws SQLException {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        try {
            deleteHotel hapusRiwayat = new deleteHotel();
            hapusRiwayat.hapusRiwayatHotel();
        } catch (SQLException exception) {
            System.out.println("ERROR: " + exception.getMessage());
            HalamanAwal.kembaliKeMenu();
        }
    }
}