package Modul4_Kel24;

public class Function {

    static void penjumlahan(int a, int b) {
        int c = a + b;
        System.out.println("Hasil penjumlahan: " + c);
    }

    static void pengurangan() {
        int c = 10 - 20;
        System.out.println("Hasil pengurangan: " + c);
    }

    static int pembagian(int a, int b) {
        int c = a / b;
        return c;
    }

    static int perkalian() {
        int c = 10 * 20;
        return c;
    }

    public static void main(String[] args) {
        penjumlahan(10, 20);

        pengurangan();

        System.out.println("Hasil perkalian: " + perkalian());

        int d = pembagian(100, 20);
        System.out.println("Hasil pembagian: " + d);

        System.out.println();
        System.out.println("-----------------");

        Method objek = new Method();   // <- ini yang dibenerin

        objek.sapa();

        System.out.println(objek.perkenalan("Tyo", "Jember", "Denger musik Nuts - Lil peep"));

        objek.umur(1000);
    }
}
