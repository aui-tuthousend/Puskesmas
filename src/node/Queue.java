package node;

public class Queue {
    public int index;
    public Pasien pasien;

    public Queue(int index, Pasien pasien) {
        this.index = index;
        this.pasien = pasien;
    }

    public void viewQueue(){
        System.out.println("Antrean ke  : "+index);
        System.out.println("Nama pasien : "+pasien.namaPasien);
    }
}
