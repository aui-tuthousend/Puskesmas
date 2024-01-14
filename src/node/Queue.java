package node;

public class Queue {
    public int index;
    public Pasien pasien;
    public String poli;

    public Queue(int index, Pasien pasien, String poli) {
        this.index = index;
        this.pasien = pasien;
        this.poli = poli;
    }

    public void viewQueue(){
        System.out.println("Poli        : "+poli);
        System.out.println("No Antrean  : "+index);
        System.out.println("Nama pasien : "+pasien.namaPasien);
    }
}
