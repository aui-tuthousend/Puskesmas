package node;

public class Pasien {
    public int idPasien;
    public String namaPasien;
    public String alamat;
    public String gender;
    public String TTL;
    public String NIK;
    public String BPJS;

    public Pasien(int idPasien, String namaPasien, String alamat, String gender, String TTL, String NIK, String BPJS) {
        this.idPasien = idPasien;
        this.namaPasien = namaPasien;
        this.alamat = alamat;
        this.gender = gender;
        this.TTL = TTL;
        this.NIK = NIK;
        this.BPJS = BPJS;
    }
}
