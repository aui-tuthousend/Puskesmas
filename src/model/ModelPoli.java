package model;

import com.google.gson.reflect.TypeToken;
import modelGSON.ModelGSON;
import node.Dokter;
import node.Poli;
import node.Queue;

import java.util.ArrayList;

public class ModelPoli {
    public ArrayList<Poli> polis;
    ModelGSON modelGSON;

    public ModelPoli(){
        modelGSON = new ModelGSON("src/database/poli.json");
        polis = modelGSON.readFromFile(new TypeToken<ArrayList<Poli>>() {
        }.getType());
        if (polis == null){
            this.polis = new ArrayList<>();
        }
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
//            System.out.println("\nShutting down. Saving data to JSON file...");
            modelGSON.writeToFile(polis);
        }));
    }

    public void addPolisModel(Poli poli){
        this.polis.add(poli);
    }
    public Poli searchPoli(int id){
        for (Poli poli: polis){
            if (poli.idPoli == id){
                return poli;
            }
        }

        return null;
    }
    public int getLastCode(){
        int idx;
        if(polis.isEmpty()) {
            return -1;
        } else {
            idx = polis.size() - 1;
            return polis.get(idx).idPoli;
        }
    }
    public void addPoliDoctor(int id, Dokter dokter){
        Poli poli = searchPoli(id);
        poli.addDokter(dokter);
    }
    public void addPoliQueue(int id, Queue queue){
        Poli poli = searchPoli(id);
        polis.get(poli.idPoli).addQueue(queue);
//        poli.addQueue(queue);
    }

    public int getLastQueueIndex(int id){
        Poli poli = searchPoli(id);
        int idx;
        if (poli.queues.isEmpty()){
            return -1;
        } else {
            idx = poli.queues.size()-1;
            return poli.queues.get(idx).index;
        }
    }
    public void viewPoliDokter(int id){
        Poli poli = searchPoli(id);
        for (Dokter dokter: poli.dokters){
            dokter.viewDokter();
        }
    }

    public void viewAllPoli(){
        for (Poli poli: polis){
            poli.viewPoli();
        }
    }

}
