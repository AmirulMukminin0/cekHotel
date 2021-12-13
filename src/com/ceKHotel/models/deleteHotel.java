package com.ceKHotel.models;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class deleteHotel extends BaseModel{
    public deleteHotel() throws SQLException {
        super();
    }

    public static void hapusRiwayatHotel() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        try {
            RiwayatHotel lihatRiwayat = new RiwayatHotel();
            lihatRiwayat.getRiwayatHotel();

            System.out.println("PILIH ID CUSTOMER YANG INGIN DIHAPUS = ");
            int idHapus = scanner.nextInt();

            String queryHotel = "DELETE FROM detailHotel USING Customer WHERE detailHotel.customer_customer_id = customer.customer_id AND customer.customer_id = ? ;";
            String queryCustomer = "DELETE FROM Customer WHERE customer_id = ?;";
            PreparedStatement preparedStatement = connection.prepareStatement(queryHotel);
            preparedStatement.setInt(1, idHapus);

            PreparedStatement preparedStatement1 = connection.prepareStatement(queryCustomer);
            preparedStatement1.setInt(1, idHapus);

            int hasil = preparedStatement.executeUpdate();
            preparedStatement1.executeUpdate();
            System.out.println("--------------------------------------------------");
            System.out.println("Berhasil Menghapus " + hasil + " Riwayat Pesanan Hotel deLight!");
        } catch (SQLException exception) {
            System.out.println("ERROR: " + exception.getMessage());
        }
    }
}