package controller;

import model.ModelDokter;
import model.ModelPoli;
import model.ModelQueue;
import model.ModelTransaction;
import node.*;

public class PoliController {
    public ModelPoli modelPoli;
    ModelDokter modelDokter;
    ModelQueue modelQueue;
    TransactionController transactionController;

    public PoliController() {
        this.modelPoli = new ModelPoli();
        this.modelQueue = new ModelQueue();
        this.modelDokter = new ModelDokter();
        this.transactionController = new TransactionController();
    }

    public void addPoli(String nama){
        int id = modelPoli.getLastCode()+1;
        Poli poli = new Poli(id, nama);
        modelPoli.addPolisModel(poli);
    }

    public void editPoli(int id, String nama){
        modelPoli.editPoli(id, nama);
    }
//    public void removeDoctor(int idD, int idP){
//        Dokter dokter = modelDokter.searchDokter(idD);
//        modelPoli.removePoliDoctor(idP, dokter);
//    }
    public void deletePoli(int id){
        modelPoli.deletePoli(id);
    }

    public Poli searchPoli(int id){
        return modelPoli.searchPoli(id);
    }

    public int addQueue(int idPoli, Pasien pasien, String poli){
        int id = modelPoli.getLastQueueIndex(idPoli)+1;
        String k = String.valueOf(poli.charAt(0));
        String kodeP = k+(id+1);
        node.Queue queue = new node.Queue(id, kodeP, pasien, poli);
        transactionController.addTransaction(queue, poli);
        modelPoli.addPoliQueue(idPoli, queue);
        modelQueue.addQueue(queue);

        return id;
    }

    public boolean getLastPasien(int idPoli, int idP){

        return modelPoli.getLastQueuePasien(idPoli, idP);
    }


}
