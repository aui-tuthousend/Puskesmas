package controller;

import model.ModelDokter;
import model.ModelSchedule;
import node.Dokter;
import node.Schedule;

public class DokterController {
    ModelDokter modelDokter;
    ModelSchedule modelSchedule;

    public void addDokter(String nama, String poli){
        int id = modelDokter.getLastCode();
        Dokter dokter = new Dokter(id, nama, poli);
        modelDokter.addDokterModel(dokter);
    }

    public void viewAllDoctor(){
        modelDokter.viewAllDoctor();
    }

    public void addSchedule(int idDokter, String hari, String jam){
        Dokter dokter = modelDokter.searchDokter(idDokter);
        int id = modelSchedule.getLastCode();
        Schedule schedule = new Schedule(id, hari, jam, dokter.namaDokter);
        modelDokter.addScheduleDoctor(idDokter, schedule);
        modelSchedule.addSchedule(schedule);
    }
}
