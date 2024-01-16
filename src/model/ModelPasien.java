package model;

import com.google.gson.reflect.TypeToken;
import modelGSON.ModelGSON;
import node.Dokter;
import node.Pasien;

import java.util.ArrayList;

public class ModelPasien {
    public static ArrayList<Pasien> pasiens;
    ModelGSON modelGSON;

    public ModelPasien(){
        modelGSON = new ModelGSON("src/database/pasien.json");
        pasiens = modelGSON.readFromFile(new TypeToken<ArrayList<Pasien>>() {
        }.getType());
        if (pasiens == null){
            this.pasiens = new ArrayList<>();
        }
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
//            System.out.println("\nShutting down. Saving data to JSON file...");
            modelGSON.writeToFile(pasiens);
        }));
    }

    public void addPasienModel(Pasien pasien){
        this.pasiens.add(pasien);
        modelGSON.writeToFile(pasiens);
        System.out.println("GG");
    }
    public Pasien searchPasien(int id){
        for (Pasien pasien: pasiens){
            if (pasien.idPasien == id){
                return pasien;
            }
        }

        return null;
    }
    public int getLastCode(){
        int idx;
        if(pasiens.isEmpty()) {
            return -1;
        } else {
            idx = pasiens.size() - 1;
            return pasiens.get(idx).idPasien;
        }
    }
}
