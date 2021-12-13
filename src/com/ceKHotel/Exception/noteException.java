package com.ceKHotel.Exception;

import com.ceKHotel.models.HalamanAwal;

import java.sql.SQLException;

public class noteException extends Exception{
    public noteException() throws SQLException {
        super("Data Tidak Boleh Kosong!");
        System.out.println("\nData Tidak Boleh Kosong !");
        HalamanAwal menu = new HalamanAwal();
        menu.kembaliKeMenu();
    }
}