package bagian3.kontak;

public class Kontak {
    private String nama;
    private String nomor;
    private String email; // No. 2: Tambah atribut email

    // No. 2: Lengkapi constructor
    public Kontak(String nama, String nomor, String email) {
        this.nama = nama;
        this.nomor = nomor;
        this.email = email;
    }

    // Getter
    public String getNama() {
        return nama;
    }

    public String getNomor() {
        return nomor;
    }

    // No. 2: Tambah getter untuk email
    public String getEmail() {
        return email;
    }

    // No. 2: Sesuaikan keBaris menjadi 3 bagian
    public String keBaris() {
        return nama + ";" + nomor + ";" + email;
    }

    // No. 2: Sesuaikan info kontak
    public String info() {
        return nama + " - " + nomor + " (" + email + ")";
    }
}