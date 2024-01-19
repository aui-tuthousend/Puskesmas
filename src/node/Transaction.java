package node;

public class Transaction {
    public int idTransaksi;
    public Queue antrean;
    public Poli poli;

    public Transaction(int id, Queue antrean, Poli poli) {
        this.idTransaksi = id;
        this.antrean = antrean;
        this.poli = poli;
    }
}
