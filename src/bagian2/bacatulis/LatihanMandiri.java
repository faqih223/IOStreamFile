package bagian2.bacatulis;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class LatihanMandiri {
    public static void main(String[] args) {
        String namaBerkas = "hari.txt";

        //soal 1
        System.out.println("--- Soal 1: Menulis & Membaca 5 Hari ---");
        
        
        try (PrintWriter penulis = new PrintWriter(new FileWriter(namaBerkas))) {
            penulis.println("Senin");
            penulis.println("Selasa");
            penulis.println("Rabu");
            penulis.println("Kamis");
            penulis.println("Jumat");
            System.out.println("Berhasil menulis 5 nama hari ke " + namaBerkas + "\n");
        } catch (IOException e) {
            System.out.println("Gagal menulis: " + e.getMessage());
        }

       
        System.out.println("Isi berkas saat ini:");
        bacaDanTampilkanBerkas(namaBerkas);


        //soal 2
        System.out.println("\n--- Soal 2: Menambah (Append) 2 Hari ---");
        
      
        try (PrintWriter penulis = new PrintWriter(new FileWriter(namaBerkas, true))) {
            penulis.println("Sabtu");
            penulis.println("Minggu");
            System.out.println("Berhasil menambahkan 2 hari lagi.\n");
        } catch (IOException e) {
            System.out.println("Gagal menambah data: " + e.getMessage());
        }

     
        System.out.println("Isi berkas setelah ditambahkan:");
        bacaDanTampilkanBerkas(namaBerkas);


        //soal 3
        System.out.println("\n--- Soal 3: Menghitung Jumlah Baris ---");
        
        try (BufferedReader pembaca = new BufferedReader(new FileReader(namaBerkas))) {
            int jumlahBaris = 0;
            while (pembaca.readLine() != null) {
                jumlahBaris++;
            }
            System.out.println("Jumlah total baris di dalam berkas " + namaBerkas + " adalah: " + jumlahBaris + " baris.");
        } catch (IOException e) {
            System.out.println("Gagal membaca jumlah baris: " + e.getMessage());
        }
    }

    private static void bacaDanTampilkanBerkas(String namaBerkas) {
        try (BufferedReader pembaca = new BufferedReader(new FileReader(namaBerkas))) {
            String baris;
            int nomor = 1;
            while ((baris = pembaca.readLine()) != null) {
                System.out.println(nomor + ". " + baris);
                nomor++;
            }
        } catch (IOException e) {
            System.out.println("Gagal membaca berkas: " + e.getMessage());
        }
    }
}