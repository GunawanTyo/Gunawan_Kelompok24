<?php
class Rental
{
    public $konsol;
    public $jam;
    public $tarifPerJam;
    
    public function setPesanan($k, $j, $t)
    {
        $this->konsol = $k;
        $this->jam = $j;
        $this->tarifPerJam = $t;
    }

    public function tampilData()
    {
        echo "Konsol      : " . $this->konsol . "\n";
        echo "Durasi      : " . $this->jam . " jam x Rp" . $this->tarifPerJam . "\n";
    }
}

function namaKelompok()
{
    return "Kelompok 24";
}

function cetakGaris($panjang)
{
    for ($i = 1; $i <= $panjang; $i++) {
        echo "=";
    }
    echo "\n";
}

function tampilHeader()
{
    cetakGaris(35);
    echo "    RENTAL PLAYSTATION TEKKOM\n";
    echo "           " . namaKelompok() . "\n";
    cetakGaris(35);
}

function tampilMenu()
{
    echo "\n-------  PILIH KONSOL -------\n";
    echo "1. PS4             -> Rp8000/jam\n";
    echo "2. PS5             -> Rp12000/jam\n";
    echo "3. Nintendo Switch -> Rp10000/jam\n";
    echo "0. Jam Pulang (Selesai)\n";
}

function ambilTarif($pilihan)
{
    if ($pilihan == 1) {
        return 8000;
    } elseif ($pilihan == 2) {
        return 12000;
    } else {
        return 10000;
    }
}

function namaKonsol($pilihan)
{
    switch ($pilihan) {
        case 1:
            return "PS4";
        case 2:
            return "PS5";
        default:
            return "Nintendo Switch";
    }
}

function hitungDiskon($jam)
{
    if ($jam >= 6) {
        return 20;
    } elseif ($jam >= 3) {
        return 10;
    } else {
        return 0;
    }
}

function hitungTotal($jam, $tarif)
{
    return $jam * $tarif;
}

function hitungBayar($total, $diskon)
{
    return $total - ($total * $diskon / 100);
}

function hitungKembalian($uang, $totalBayar)
{
    return $uang - $totalBayar;
}

$jumlah = 0;
$pendapatan = 0;
$lanjut = "y";

tampilHeader();

while ($lanjut == "y") {

    tampilMenu();

    echo "Pilihan: ";
    $inputPilihan = trim(fgets(STDIN));

    if (!is_numeric($inputPilihan)) {
        echo "Input harus berupa angka (0-3)!\n";
        continue; // Mengulang ke awal loop (tampil menu)
    }

    $pilihan = intval($inputPilihan);

    if ($pilihan == 0) {
        echo "\nJam pulang...\n";
        break;

    } elseif ($pilihan < 1 || $pilihan > 3) {
        echo "Pilihan tidak ada!\n";

    } else {

        echo "Lama sewa (jam) : ";
        $inputJam = trim(fgets(STDIN));

        if (!is_numeric($inputJam) || intval($inputJam) <= 0) {
            echo "Jam sewa tidak valid! Harus angka lebih dari 0.\n";
            continue;
        }

        $jam = intval($inputJam);

        $rental = new Rental();
        $konsol = namaKonsol($pilihan);
        $tarif = ambilTarif($pilihan);

        $rental->setPesanan($konsol, $jam, $tarif);

        $diskon = hitungDiskon($jam);
        $total = hitungTotal($jam, $tarif);
        $totalBayar = hitungBayar($total, $diskon);

        echo "\n--------- PEMBAYARAN ---------\n";
        $rental->tampilData();
        echo "Total       : Rp$total\n";
        echo "Diskon      : $diskon%\n";
        echo "Total Bayar : Rp$totalBayar\n";

        // Input pembayaran
        do {
            echo "Uang Pelanggan : Rp";
            $uang = intval(trim(fgets(STDIN)));

            if ($uang < $totalBayar) {
                echo "Uang kurang! Silakan minta kembali ke pelanggan.\n";
            }
        } while ($uang < $totalBayar);

        $kembalian = hitungKembalian($uang, $totalBayar);

        echo "\n--------- STRUK ---------\n";
        $rental->tampilData();
        echo "Total       : Rp$total\n";
        echo "Diskon      : $diskon%\n";
        echo "Total Bayar : Rp$totalBayar\n";
        echo "Uang        : Rp$uang\n";
        echo "Kembalian   : Rp$kembalian\n";
        echo "-------------------------\n";
        echo "Terima kasih sudah menyewa!\n";

        $pendapatan += $totalBayar;
        $jumlah++;

        echo "\nAda pelanggan lagi? (y/n): ";
        $lanjut = strtolower(trim(fgets(STDIN)));

        while ($lanjut != "y" && $lanjut != "n") {
            echo "Input harus y atau n. Masukkan kembali: ";
            $lanjut = strtolower(trim(fgets(STDIN)));
        }
    }
}


echo "\n====== LAPORAN AKHIR KASIR ======\n";
echo "Total pelanggan dilayani : $jumlah orang\n";
echo "Total pendapatan shift   : Rp$pendapatan\n";
echo "===================================\n";
?>