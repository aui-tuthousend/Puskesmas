package node;

import java.util.List;

public class Poli {
    public int idPoli;
    public String namaPoli;
    List<Dokter> dokters;
    public List<Queue> queues;

    public Poli(int idPoli, String namaPoli) {
        this.idPoli = idPoli;
        this.namaPoli = namaPoli;
    }

    public void addDokter(Dokter dokter){
        this.dokters.add(dokter);
    }

    public void addQueue(Queue queue){
        this.queues.add(queue);
    }

    public void viewPoli(){
        System.out.println("List Dokter Poli "+namaPoli);
        for (Dokter dokter: dokters){
            dokter.viewDokter();
        }
    }
}
