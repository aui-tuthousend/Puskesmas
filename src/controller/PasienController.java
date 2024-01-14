package controller;

import model.ModelPasien;
import node.Pasien;

public class PasienController {
    ModelPasien modelPasien;

    public PasienController() {
        this.modelPasien = new ModelPasien();
    }

    public void addPasien(String namaPasien, String alamat, String gender, String TTL, String NIK, String BPJS){
        int id = modelPasien.getLastCode();
        Pasien pasien = new Pasien(id, namaPasien, alamat, gender, TTL, NIK, BPJS);
        modelPasien.addPasienModel(pasien);
    }

    public Pasien searchPasien(int id){
        Pasien pasien = modelPasien.searchPasien(id);
        return pasien;
    }
}
