package com.ceKVilla;

import java.sql.SQLException;
import java.util.Scanner;
import com.ceKVilla.models.HalamanAwal;

public class Main {
    static Scanner scan = new Scanner(System.in);
    static HalamanAwal menu = new HalamanAwal();
    public static void main(String[] args) throws Exception {
        try {
            System.out.println("MESSAGE : Berhasil Terhubung ke Database!\n");
            menu.LoginHotel();
        } catch (SQLException exception) {
            System.out.println("ERROR : " + exception.getMessage());
        }
    }
}