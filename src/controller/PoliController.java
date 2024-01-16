package controller;

import model.ModelPoli;
import model.ModelQueue;
import node.Dokter;
import node.Pasien;
import node.Poli;
import node.Queue;

public class PoliController {
    ModelPoli modelPoli;
    ModelQueue modelQueue;

    public PoliController() {
        this.modelPoli = new ModelPoli();
        this.modelQueue = new ModelQueue();
    }

    public void addPoli(String nama){
        int id = modelPoli.getLastCode()+1;
        Poli poli = new Poli(id, nama);
    }

    public Poli searchPoli(int id){
        Poli poli = modelPoli.searchPoli(id);
        return poli;
    }

    public void addQueue(int idPoli, Pasien pasien, String poli){
        int id = modelPoli.getLastQueueIndex(idPoli);
        Queue queue = new Queue(id, pasien, poli);
        modelPoli.addPoliQueue(idPoli, queue);
        modelQueue.addQueue(queue);
    }

    public void addDoctor(int idPoli, Dokter dokter){
        modelPoli.addPoliDoctor(idPoli, dokter);
    }

    public void viewPoliDoctor(int id){
        modelPoli.viewPoliDokter(id);
    }

    public void viewAllPoli(){
        modelPoli.viewAllPoli();
    }
}
