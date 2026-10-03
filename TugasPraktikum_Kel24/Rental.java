package Tugas_Kel24;

public class Rental {
    String konsol;
    int jam;
    int tarifPerJam;

    // METHOD: non-return, berparameter
    public void setPesanan(String k, int j, int t) {
        konsol = k;
        jam = j;
        tarifPerJam = t;
    }

    // METHOD: non-return, tanpa parameter
    public void tampilData() {
        System.out.println("Konsol  : " + konsol);
        System.out.println("Durasi  : " + jam + " jam x Rp" + tarifPerJam);
    }

    // METHOD: return, tanpa parameter
    public int hitungTotal() {
        return jam * tarifPerJam;
    }

    // METHOD: return, berparameter
    public int hitungBayar(int diskonPersen) {
        int total = hitungTotal();
        return total - (total * diskonPersen / 100);
    }
}
