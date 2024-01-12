package node;

import java.util.ArrayList;

public class Poli {
    public int idPoli;
    public String namaPoli;
    public ArrayList<Dokter> dokters = null;
    public ArrayList<Queue> queues = null;

    public Poli(int idPoli, String namaPoli) {
        this.idPoli = idPoli;
        this.namaPoli = namaPoli;
        this.dokters = new ArrayList<>();
        this.queues = new ArrayList<>();
    }

    public void addDokter(Dokter dokter){
        this.dokters.add(dokter);
    }

    public void addQueue(Queue queue){
        this.queues.add(queue);
    }

    public void viewPoli(){
        System.out.println("List Dokter Poli "+namaPoli+" :");
        for (Dokter dokter: dokters){
            dokter.viewDokter();
        }
    }
}
