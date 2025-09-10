/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.manajementiketkonser;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Tuf Gaming
 */
public class Manajementiketkonser {
    static class Tiket {
        String namaKonser;
        String tanggal;
        double harga;

        Tiket(String namaKonser, String tanggal, double harga) {
            this.namaKonser = namaKonser;
            this.tanggal = tanggal;
            this.harga = harga;
        }
    }

    public static void main(String[] args) {
        ArrayList<Tiket> daftarTiket = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        int pilihan;

        do {
            System.out.println("\n=== Sistem Manajemen Penjualan Tiket Konser ===");
            System.out.println("1. Tambah Tiket");
            System.out.println("2. Lihat Tiket");
            System.out.println("3. Update Tiket");
            System.out.println("4. Hapus Tiket");
            System.out.println("5. Keluar");
            System.out.print("Pilih menu: ");
            pilihan = input.nextInt();
            input.nextLine(); // membersihkan buffer

            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan nama konser: ");
                    String nama = input.nextLine();
                    System.out.print("Masukkan tanggal konser (dd-mm-yyyy): ");
                    String tanggal = input.nextLine();
                    System.out.print("Masukkan harga tiket: ");
                    double harga = input.nextDouble();
                    daftarTiket.add(new Tiket(nama, tanggal, harga));
                    System.out.println("Tiket berhasil ditambahkan!");
                    break;

                case 2:
                    System.out.println("\n=== Daftar Tiket Konser ===");
                    if (daftarTiket.isEmpty()) {
                        System.out.println("Belum ada tiket yang tersedia.");
                    } else {
                        for (int i = 0; i < daftarTiket.size(); i++) {
                            Tiket t = daftarTiket.get(i);
                            System.out.println((i+1) + ". " + t.namaKonser + " | " + t.tanggal + " | Rp " + t.harga);
                        }
                    }
                    break;

                case 3:
                    System.out.print("Masukkan nomor tiket yang ingin diupdate: ");
                    int idxUpdate = input.nextInt() - 1;
                    input.nextLine();
                    if (idxUpdate >= 0 && idxUpdate < daftarTiket.size()) {
                        System.out.print("Masukkan nama konser baru: ");
                        String namaBaru = input.nextLine();
                        System.out.print("Masukkan tanggal konser baru: ");
                        String tanggalBaru = input.nextLine();
                        System.out.print("Masukkan harga tiket baru: ");
                        double hargaBaru = input.nextDouble();
                        daftarTiket.set(idxUpdate, new Tiket(namaBaru, tanggalBaru, hargaBaru));
                        System.out.println("Tiket berhasil diupdate!");
                    } else {
                        System.out.println("Nomor tiket tidak valid.");
                    }
                    break;

                case 4:
                    System.out.print("Masukkan nomor tiket yang ingin dihapus: ");
                    int idxHapus = input.nextInt() - 1;
                    if (idxHapus >= 0 && idxHapus < daftarTiket.size()) {
                        daftarTiket.remove(idxHapus);
                        System.out.println("Tiket berhasil dihapus!");
                    } else {
                        System.out.println("Nomor tiket tidak valid.");
                    }
                    break;

                case 5:
                    System.out.println("Terima kasih telah menggunakan sistem!");
                    break;

                default:
                    System.out.println("Pilihan tidak valid.");
            }
        } while (pilihan != 5);

        input.close();

   
    }
}
