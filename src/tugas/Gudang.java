package tugas;

import java.io.*;
import java.util.ArrayList;

public class Gudang {
    private ArrayList<Barang> daftarBarang;

    public Gudang() {
        this.daftarBarang = new ArrayList<>();
    }

    public void tambahBarang(Barang b) {
        daftarBarang.add(b);
    }

    public void tampilkanSemua() {
        if (daftarBarang.isEmpty()) {
            System.out.println("(Gudang kosong)");
            return;
        }
        for (Barang b : daftarBarang) {
            b.info();
        }
    }

    // Menyimpan data ke berkas teks
    public void simpanKeBerkas(String namaBerkas) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(namaBerkas))) {
            for (Barang b : daftarBarang) {
                writer.write(b.keBaris());
                writer.newLine();
            }
            System.out.println("-> Data berhasil disimpan ke " + namaBerkas);
        } catch (IOException e) {
            System.out.println("Gagal menyimpan berkas: " + e.getMessage());
        }
    }

    // Memuat kembali data dari berkas teks
    public void muatDariBerkas(String namaBerkas) {
        daftarBarang.clear(); // Bersihkan data lama jika ada
        try (BufferedReader reader = new BufferedReader(new FileReader(namaBerkas))) {
            String baris;
            while ((baris = reader.readLine()) != null) {
                String[] data = baris.split(",");
                if (data.length == 3) {
                    String nama = data[0];
                    double harga = Double.parseDouble(data[1]);
                    int stok = Integer.parseInt(data[2]);
                    daftarBarang.add(new Barang(nama, harga, stok));
                }
            }
            System.out.println("-> Data berhasil dimuat dari " + namaBerkas);
        } catch (IOException e) {
            System.out.println("Gagal memuat berkas: " + e.getMessage());
        }
    }

    // Menghitung total nilai persediaan (harga * stok)
    public double totalNilai() {
        double total = 0;
        for (Barang b : daftarBarang) {
            total += b.getHarga() * b.getStok();
        }
        return total;
    }
}