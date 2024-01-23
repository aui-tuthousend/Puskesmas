package node;

import java.util.ArrayList;

public class Poli {
    public int idPoli;
    public String namaPoli;
    public ArrayList<Queue> queues;

    public Poli(int idPoli, String namaPoli) {
        this.idPoli = idPoli;
        this.namaPoli = namaPoli;
        this.queues = new ArrayList<>();
    }

    public void addQueue(Queue queue){
        this.queues.add(queue);
    }

    public void setNamaPoli(String namaPoli) {
        this.namaPoli = namaPoli;
    }
}
