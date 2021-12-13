package com.ceKHotel.models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class  Fasilitas extends BaseModel{

    public Fasilitas() throws SQLException {
    super();
    }
    static void getFasilitas() {
        String query = "SELECT * FROM FasilitasKamar";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();

            System.out.println("\n\n+-------------------------------------------------------+");
            System.out.println("|                 PILIH FASILITAS KAMAR                 |");
            System.out.println("+----+----------------------------------+---------------+");
            System.out.println("| ID | Fasilitas Kamar                  | View Kamar    |");
            System.out.println("+----+----------------------------------+---------------+");

            while (rs.next()) {
                int idFasilitas = rs.getInt("fasilitasKamar_id");
                String namaFas = rs.getString("namaFasilitasKamar");
                String view = rs.getString("viewKamar");

                System.out.println(String.format("| %d. | %s \t | %s \t\t |", idFasilitas, namaFas, view));
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }
}

