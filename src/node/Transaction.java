package node;

import java.time.LocalDate;

public class Transaction {
    public int idTransaksi;
    public Queue antrean;
    public String poli;
    public String tanggal;
    public Transaction(int id, Queue antrean, String poli) {
        this.idTransaksi = id;
        this.antrean = antrean;
        this.poli = poli;

        LocalDate tgl = LocalDate.now();
        this.tanggal = tgl.toString();
    }
}
