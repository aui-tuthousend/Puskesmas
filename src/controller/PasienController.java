package controller;

import model.ModelPasien;
import node.Pasien;

public class PasienController {
    public ModelPasien modelPasien;

    public PasienController() {
        this.modelPasien = new ModelPasien();
    }

    public void addPasien(String namaPasien, String alamat, String gender, String TTL, String NIK, String BPJS){
        int id = modelPasien.getLastCode()+1;
        Pasien pasien = new Pasien(id, namaPasien, alamat, gender, TTL, NIK, BPJS);
        modelPasien.addPasienModel(pasien);
    }

    public Pasien searchPasien(int id){
        Pasien pasien = modelPasien.searchPasien(id);
        return pasien;
    }

    public boolean isNIKAda(String NIK){
        for (Pasien pasien: modelPasien.pasiens){
            if (pasien.NIK.equals(NIK)){
                return false;
            }
        }
        return true;
    }
}
