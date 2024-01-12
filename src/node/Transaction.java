package node;

public class Transaction {
    public Queue antrean;
    public Pasien pasien;
    public Poli poli;
    public Schedule tanggal;
    public Dokter dokter;

    public Transaction(Queue antrean, Pasien pasien, Poli poli, Schedule tanggal, Dokter dokter) {
        this.antrean = antrean;
        this.pasien = pasien;
        this.poli = poli;
        this.tanggal = tanggal;
        this.dokter = dokter;
    }
}
