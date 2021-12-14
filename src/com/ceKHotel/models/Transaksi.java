package com.ceKHotel.models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.util.Locale;
import java.sql.Statement;
import java.util.Scanner;

public class Transaksi extends BaseModel {

    public Transaksi() throws SQLException {
        super();
    }

    static int customerService;
    static int idCustomer;
    static int jenisKamar;
    static int lama;
    static int pilihFasilitas;
    static int nomorKamar;
    static double uangMasuk;
    static Scanner scanner = new Scanner(System.in);
    public static int Transaksi() {
        try {
            System.out.println("\n\n+--------------------------------------------------+");
            System.out.println("|               PESANAN HOTEL deLight              |");
            System.out.println("+--------------------------------------------------+");
            CustomerService.getDataCs();
            System.out.print("\nPilih Customer Service : ");
            customerService = scanner.nextInt();
            CustomerModel.addCustomer();

            CustomerModel.lihatCustomer();
            System.out.print("\nMasukkan ID Customer   : ");
            idCustomer = scanner.nextInt();

            System.out.print("Masukkan Lama Menginap : ");
            lama = scanner.nextInt();

            Jenis.getJenisKamar();
            System.out.print("\nPilihan Jenis Kamar : ");
            jenisKamar = scanner.nextInt();

            Fasilitas.getFasilitas();
            System.out.print("\nPilihan Fasilitas Kamar : ");
            pilihFasilitas = scanner.nextInt();

            System.out.print("Masukkan Nomor Kamar    : ");
            nomorKamar = scanner.nextInt();

            System.out.print("Uang Yang Diterima      : Rp");
            uangMasuk = scanner.nextDouble();
            NumberFormat rupiah = NumberFormat.getNumberInstance(new Locale("in", "ID"));

            String query = "INSERT INTO detailHotel" +
                    "(lamamenginap, nomorKamar, jeniskamar_jeniskamar_id, fasilitaskamar_fasilitaskamar_id, customer_customer_id, cs_cs_id) VALUES " +
                    " (?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, lama);
            preparedStatement.setInt(2, nomorKamar);
            preparedStatement.setInt(3, jenisKamar);
            preparedStatement.setInt(4, pilihFasilitas);
            preparedStatement.setInt(5, idCustomer);
            preparedStatement.setInt(6, customerService);

            System.out.println("\nPesanan Kamar Baru Telah Ditambahkan!");
            strukNota();

            return preparedStatement.executeUpdate();
        } catch (SQLException exception) {
            System.out.println("ERROR : " + exception.getMessage());
        }
        return 0;
    }

    public static void strukNota() throws SQLException {
        System.out.println("---------------------------------------------------------");

        NumberFormat rupiah = NumberFormat.getNumberInstance(new Locale("in", "ID"));
        String queryPenginapan = "SELECT * FROM Penginapan";
        String querycustomerService = "SELECT namaCs FROM customerService WHERE Cs_id = ?;";
        String queryJenis = "SELECT * FROM jenisKamar WHERE jenisKamar_id = ?;";
        String queryCustomer = "SELECT namaCustomer, noHp FROM Customer WHERE customer_id = ?;";

        PreparedStatement preparedStatementcustomerService = connection.prepareStatement(querycustomerService);
        preparedStatementcustomerService.setInt(1, customerService);
        ResultSet rsCs = preparedStatementcustomerService.executeQuery();
        String namaCs = null;
        while (rsCs.next()) {
            namaCs = rsCs.getString("namaCs");
        }

        PreparedStatement preparedStatementJenis = connection.prepareStatement(queryJenis);
        preparedStatementJenis.setInt(1, jenisKamar);
        ResultSet resultSetJenis = preparedStatementJenis.executeQuery();

        double hargaJenis = 0;
        String namaJenis = null;
        double totalPembayaran = 0;
        double uangKembali = 0;

        while (resultSetJenis.next()) {
            hargaJenis = resultSetJenis.getDouble("hargaJenis");
            namaJenis = resultSetJenis.getString("namaJenis");
            totalPembayaran = lama * hargaJenis;
            uangKembali = uangMasuk - totalPembayaran;
        }

        PreparedStatement preparedStatementCstmr = connection.prepareStatement(queryCustomer);
        preparedStatementCstmr.setInt(1, idCustomer);
        ResultSet resultSetCstmr = preparedStatementCstmr.executeQuery();

        String namaCstmr = null;
        String noTelpCstmr = null;

        while (resultSetCstmr.next()) {
            namaCstmr = resultSetCstmr.getString("namaCustomer");
            noTelpCstmr = resultSetCstmr.getString("noHp");
        }

        PreparedStatement preparedStatementPenginapan = connection.prepareStatement(queryPenginapan);
        ResultSet resultSetPenginapan = preparedStatementPenginapan.executeQuery();

        String namaPenginapan = null;
        String noTelpPenginapan = null;
        String alamatPenginapan = null;
        String kabPenginapan = null;
        String provPenginapan = null;


        while (resultSetPenginapan.next()) {
            namaPenginapan = resultSetPenginapan.getString("namaPenginapan");
            noTelpPenginapan = resultSetPenginapan.getString("noTelpPenginapan");
            alamatPenginapan = resultSetPenginapan.getString("alamatPenginapan");
            kabPenginapan = resultSetPenginapan.getString("kabupatenPenginapan");
            provPenginapan = resultSetPenginapan.getString("provinsiPenginapan");

        }

        System.out.println(String.format("\n\n\t\t\t\t\t\t%s \n   %s, %s, Prov. %s \n\t\t\t\t\tTelp. %s", namaPenginapan, alamatPenginapan, kabPenginapan, provPenginapan, noTelpPenginapan));
        System.out.println("=========================================================");
        System.out.println(String.format("CUSTOMER \nNama Customer    : %s \nNomor Telepon    : %s \n---------------------------------------------------------", namaCstmr, noTelpCstmr));
        System.out.println("DETAIL PESANAN \nJenis Kamar      : " + namaJenis + "\nLama Menginap    : " + lama + " Hari x Rp"+ rupiah.format(hargaJenis));
        System.out.println("\nTOTAL            : Rp" + rupiah.format(totalPembayaran) + "\nBAYAR            : Rp" + rupiah.format(uangMasuk) + "\nKEMBALI          : Rp" + rupiah.format(uangKembali));
        System.out.println(String.format("\nCustomer Service : %s", namaCs));
        System.out.println("\n========================================================= \n\t\t\t\t\t  TERIMA KASIH\n");


    }
}