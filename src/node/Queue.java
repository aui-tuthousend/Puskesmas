package node;

public class Queue {
    public int index;
    public String kodePasien;
    public Pasien pasien;
    public String poli;

    public Queue(int index, String kodePasien, Pasien pasien, String poli) {
        this.index = index;
        this.kodePasien = kodePasien;
        this.pasien = pasien;
        this.poli = poli;
    }
}
