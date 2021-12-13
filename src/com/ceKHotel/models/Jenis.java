package com.ceKHotel.models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Jenis extends BaseModel{

    public Jenis() throws SQLException {
        super();
    }
    static void getJenisKamar() {
        String query = "SELECT * FROM jenisKamar";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();

            System.out.println("\n\n+-------------------------------------------------------+");
            System.out.println("|                    PILIH JENIS KAMAR                  |");
            System.out.println("+----+--------------------------+-----------------------+");
            System.out.println("| ID | Jenis Kamar              | Harga                 |");
            System.out.println("+----+--------------------------+-----------------------+");

            while (rs.next()) {
                int idJenis = rs.getInt("jenisKamar_id");
                String jenis = rs.getString("namaJenis");
                float harga = rs.getFloat("hargaJenis");

                System.out.println(String.format("| %d. | %s               | Rp%.2f           |", idJenis, jenis, harga));
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }
}
