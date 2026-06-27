
// Nama : Faqihhuddin
// NPM  : 2410010327
package tugas;

public class MainTugas {
    public static void main(String[] args) {
        String namaFile = "barang.txt";

        // 1. Menyimpan dan menampilkan daftar kategori (Array ukuran tetap)
        System.out.println("=== KATEGORI TOKO ===");
        String[] kategori = {"Elektronik", "Pakaian", "Makanan & Minuman", "Alat Tulis"};
        for (int i = 0; i < kategori.length; i++) {
            System.out.println((i + 1) + ". " + kategori[i]);
        }
        System.out.println();

        // 2. Inisialisasi Gudang Pertama & Tambah Minimal 5 Barang
        System.out.println("=== PROSES GUDANG AWAL ===");
        Gudang gudangAwal = new Gudang();
        
        gudangAwal.tambahBarang(new Barang("Laptop Asus", 8500000, 5));
        gudangAwal.tambahBarang(new Barang("Mouse Wireless", 150000, 15));
        gudangAwal.tambahBarang(new Barang("Kemeja Flanel", 200000, 20));
        gudangAwal.tambahBarang(new Barang("Kopi Susu", 15000, 50));
        gudangAwal.tambahBarang(new Barang("Buku Tulis", 7000, 100));

        System.out.println("Daftar Barang Gudang Awal:");
        gudangAwal.tampilkanSemua();
        
        // Simpan data ke berkas
        gudangAwal.simpanKeBerkas(namaFile);
        System.out.println();

        // 3. Membuat Objek Gudang Baru untuk Membuktikan Data Tersimpan
        System.out.println("=== PROSES GUDANG BARU (DARI FILE) ===");
        Gudang gudangBaru = new Gudang();
        
        // Muat data dari berkas
        gudangBaru.muatDariBerkas(namaFile);
        
        System.out.println("\nDaftar Barang di Gudang Baru:");
        gudangBaru.tampilkanSemua();
        
        // Menampilkan total nilai persediaan
        double totalPersediaan = gudangBaru.totalNilai();
        System.out.println("-------------------------------------------------");
        System.out.printf("Total Nilai Persediaan Gudang: RpFormat%.2f\n", totalPersediaan);
        System.out.println("=================================================");
    }
}