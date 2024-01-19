package model;

import com.google.gson.reflect.TypeToken;
import modelGSON.ModelGSON;
import node.Dokter;
import node.Poli;
import node.Schedule;

import java.util.ArrayList;

public class ModelDokter {
    public ArrayList<Dokter> dokters;
    ModelGSON modelGSON;

    public ModelDokter(){
        modelGSON = new ModelGSON("src/database/dokter.json");

        dokters = modelGSON.readFromFile(new TypeToken<ArrayList<Dokter>>() {
        }.getType());
        if (dokters == null){
            this.dokters = new ArrayList<>();
        }

//        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
////            System.out.println("\nShutting down. Saving data to JSON file...");
////            modelGSON.writeToFile(dokters);
//        }));
    }

    public void addDokterModel(Dokter dokter){
        dokters.add(dokter);
        modelGSON.writeToFile(dokters);
    }

    public void editDokter(int id, String nama, int idP){
        Dokter dokter = searchDokter(id);
        dokter.namaDokter = nama;
        dokter.poli = idP;
        modelGSON.writeToFile(dokters);

    }
    public void deleteDokter(int id){
        this.dokters.remove(id);
        modelGSON.writeToFile(dokters);
    }
    public Dokter searchDokter(int id){
        for (Dokter dokter: dokters){
            if (dokter.idDokter == id){
                return dokter;
            }
        }

        return null;
    }

    public int getLastScheduleIndex(int id){
        Dokter dokter = searchDokter(id);
        int idx;
        if (dokter.schedules.isEmpty()){
            return -1;
        } else {
            idx = dokter.schedules.size()-1;
            return dokter.schedules.get(idx).idSchedule;
        }
    }
    public void editJadwal(int idD, int idJ, String hr, String jm){
        Dokter dokter = searchDokter(idD);
        dokter.schedules.get(idJ).hari = hr;
        dokter.schedules.get(idJ).jam = jm;
        modelGSON.writeToFile(dokters);
    }
    public void deleteJadwal(int idD, int idJ){
        Dokter dokter = searchDokter(idD);
        dokter.schedules.remove(idJ);
        modelGSON.writeToFile(dokters);
    }
    public int getLastCode(){
        int idx;
        if(dokters.isEmpty()) {
            return -1;
        } else {
            idx = dokters.size() - 1;
            return dokters.get(idx).idDokter;
        }
    }

    public void addScheduleDoctor(int id, Schedule schedule){
        Dokter dokter = searchDokter(id);
        dokter.addSchedule(schedule);
        modelGSON.writeToFile(dokters);
    }

    public void viewAllDoctor(){
        System.out.println("List Seluruh Dokter: ");
        for (Dokter dokter: dokters){
            dokter.viewDokter();
        }
    }
}
