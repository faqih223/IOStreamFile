package bagian3.kontak;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.ArrayList;

public class BukuKontak {
    private ArrayList<Kontak> daftar = new ArrayList<>();
    private String namaBerkas;

    public BukuKontak(String namaBerkas) {
        this.namaBerkas = namaBerkas;
    }

    public void tambahKontak(Kontak kontak) {
        daftar.add(kontak);
    }

    public void tampilkanSemua() {
        System.out.println("== Daftar Kontak ==");
        if (daftar.isEmpty()) {
            System.out.println("(Belum ada kontak)");
            return;
        }
        for (int i = 0; i < daftar.size(); i++) {
            Kontak k = daftar.get(i);
            System.out.println((i + 1) + ". " + k.info());
        }
    }

    // No. 1: Method cariKontak berdasarkan nama
    public void cariKontak(String nama) {
        System.out.println("== Hasil Pencarian: " + nama + " ==");
        boolean ditemukan = false;
        for (Kontak k : daftar) {
            // Menggunakan equalsIgnoreCase agar pencarian tidak sensitif huruf besar/kecil
            if (k.getNama().equalsIgnoreCase(nama)) {
                System.out.println("Ditemukan: " + k.info());
                ditemukan = true;
                break; // Hentikan perulangan jika sudah ketemu
            }
        }
        if (!ditemukan) {
            System.out.println("Kontak dengan nama \"" + nama + "\" tidak ditemukan.");
        }
    }

    // No. 3: Method hapusKontak berdasarkan nama
    public void hapusKontak(String nama) {
        boolean ditemukan = false;
        for (int i = 0; i < daftar.size(); i++) {
            if (daftar.get(i).getNama().equalsIgnoreCase(nama)) {
                daftar.remove(i);
                ditemukan = true;
                System.out.println("Kontak \"" + nama + "\" berhasil dihapus.");
                break;
            }
        }
        
        if (ditemukan) {
            // Panggil simpanKeBerkas agar perubahan ikut tersimpan di berkas teks
            simpanKeBerkas();
        } else {
            System.out.println("Gagal menghapus: Kontak \"" + nama + "\" tidak ditemukan.");
        }
    }

    public void simpanKeBerkas() {
        try (PrintWriter penulis = new PrintWriter(new FileWriter(namaBerkas))) {
            for (Kontak k : daftar) {
                penulis.println(k.keBaris());
            }
            System.out.println("Kontak disimpan ke " + namaBerkas);
        } catch (IOException e) {
            System.out.println("Gagal menyimpan: " + e.getMessage());
        }
    }

    public void muatDariBerkas() {
        daftar.clear();
        File berkas = new File(namaBerkas);
        if (!berkas.exists()) {
            return;
        }

        try (BufferedReader pembaca = new BufferedReader(new FileReader(berkas))) {
            String baris;
            while ((baris = pembaca.readLine()) != null) {
                String[] bagian = baris.split(";");
                // No. 2: Sesuaikan pemisahan menjadi tiga bagian (nama, nomor, email)
                if (bagian.length == 3) {
                    daftar.add(new Kontak(bagian[0], bagian[1], bagian[2]));
                }
            }
            System.out.println("Kontak dimuat dari " + namaBerkas);
        } catch (IOException e) {
            System.out.println("Gagal memuat: " + e.getMessage());
        }
    }

    public int jumlahKontak() {
        return daftar.size();
    }
}