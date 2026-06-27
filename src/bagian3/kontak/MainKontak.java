package bagian3.kontak;

public class MainKontak {
    public static void main(String[] args) {
        // Pembuatan objek BukuKontak dengan data baru yang memiliki email
        BukuKontak buku = new BukuKontak("kontak_baru.txt");
        
        System.out.println("--- 1. MENAMBAH KONTAK BARU ---");
        buku.tambahKontak(new Kontak("Andi", "0811111", "andi@email.com"));
        buku.tambahKontak(new Kontak("Budi", "0822222", "budi@email.com"));
        buku.tambahKontak(new Kontak("Citra", "0833333", "citra@email.com"));
        buku.tampilkanSemua();
        buku.simpanKeBerkas();
        System.out.println();

        System.out.println("--- 2. UJI COBA PENCARIAN (No. 1) ---");
        buku.cariKontak("Budi");  // Skenario: Ditemukan
        buku.cariKontak("Dedi");  // Skenario: Tidak ditemukan
        System.out.println();

        System.out.println("--- 3. UJI COBA PENGHAPUSAN (No. 3) ---");
        buku.hapusKontak("Andi"); // Menghapus Andi dan otomatis menyimpan ke file
        System.out.println();

        System.out.println("--- 4. MEMBUAT OBJEK BARU & MEMUAT DARI BERKAS (No. 2) ---");
        BukuKontak bukuLain = new BukuKontak("kontak_baru.txt");
        bukuLain.muatDariBerkas();
        bukuLain.tampilkanSemua(); // Seharusnya Andi sudah tidak ada di sini
        System.out.println("Jumlah kontak tersisa: " + bukuLain.jumlahKontak());
    }
}