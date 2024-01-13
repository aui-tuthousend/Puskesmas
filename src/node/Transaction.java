package node;

public class Transaction {
    public int idTransaksi;
    public Queue antrean;
    public Pasien pasien;
    public Poli poli;

    public Transaction(int id, Queue antrean, Pasien pasien, Poli poli) {
        this.idTransaksi = id;
        this.antrean = antrean;
        this.pasien = pasien;
        this.poli = poli;
    }

    public void viewTransaction(){
        System.out.println("      Detail Transaksi");
        System.out.println("Nomor Antrean: " + antrean.index);
        System.out.println("Nama Pasien  : " + pasien.namaPasien);
        System.out.println("Poli         : " + poli.namaPoli);
    }
}
