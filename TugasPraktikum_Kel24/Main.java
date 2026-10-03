package Tugas_Kel24;

import java.util.Scanner;

public class Main {

    // FUNCTION: return, tanpa parameter
    static String ambilWatermark() {
        return "Kelompok 24";
    }

    // FUNCTION: non-return, berparameter
    static void cetakGaris(int panjang) {
        for (int i = 1; i <= panjang; i++) {
            System.out.print("=");
        }
        System.out.println();
    }

    // FUNCTION: non-return, tanpa parameter
    static void tampilHeader() {
        cetakGaris(35);
        System.out.println("     RENTAL PLAYSTATION TEKKOM");
        System.out.println("        " + ambilWatermark());
        cetakGaris(35);
    }

    // FUNCTION: non-return, tanpa parameter
    static void tampilMenu() {
        System.out.println("\n--- PILIH KONSOL ---");
        System.out.println("1. PS4             - Rp8000/jam");
        System.out.println("2. PS5             - Rp12000/jam");
        System.out.println("3. Nintendo Switch - Rp10000/jam");
        System.out.println("0. Selesai");
    }

    // FUNCTION: return, berparameter
    static int ambilPilihan(Scanner input) {
        System.out.print("Pilihan: ");
        return input.nextInt();
    }

    // FUNCTION: return, berparameter
    static int ambilTarif(int pilihan) {
        if (pilihan == 1) {
            return 8000;
        } else if (pilihan == 2) {
            return 12000;
        } else {
            return 10000;
        }
    }

    // FUNCTION: return, berparameter
    static String namaKonsol(int pilihan) {
        switch (pilihan) {
            case 1:
                return "PS4";
            case 2:
                return "PS5";
            default:
                return "Nintendo Switch";
        }
    }

    // FUNCTION: return, berparameter
    static int hitungDiskon(int jam) {
        if (jam >= 6) {
            return 20;
        } else if (jam >= 3) {
            return 10;
        } else {
            return 0;
        }
    }

    // FUNCTION: non-return, berparameter
    static void cetakStruk(Rental r, int diskon) {
        System.out.println("\n--------- STRUK ---------");
        r.tampilData();
        System.out.println("Total   : Rp" + r.hitungTotal());
        System.out.println("Diskon  : " + diskon + "%");
        System.out.println("Bayar   : Rp" + r.hitungBayar(diskon));
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int jumlah = 0;
        int pendapatan = 0;
        int pilihan = 1;

        tampilHeader();

        while (pilihan != 0) {                          // perulangan
            tampilMenu();
            pilihan = ambilPilihan(input);

            if (pilihan == 0) {                         // pengkondisian
                System.out.println("Selesai.");
            } else if (pilihan < 0) {
                System.out.println("Pilihan tidak ada!");
            } else if (pilihan > 3) {
                System.out.println("Pilihan tidak ada!");
            } else {
                System.out.print("Lama sewa (jam) : ");
                int jam = input.nextInt();

                if (jam <= 0) {
                    System.out.println("Jam harus lebih dari 0!");
                } else {
                    Rental r = new Rental();
                    r.setPesanan(namaKonsol(pilihan), jam, ambilTarif(pilihan));
                    int diskon = hitungDiskon(jam);
                    cetakStruk(r, diskon);
                    pendapatan = pendapatan + r.hitungBayar(diskon);
                    jumlah++;
                }
            }
        }

        System.out.println("\nJumlah pesanan   : " + jumlah);
        System.out.println("Total pendapatan : Rp" + pendapatan);
        System.out.println("Dibuat oleh " + ambilWatermark());
    }
}