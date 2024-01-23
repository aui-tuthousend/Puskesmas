package controller;

import model.ModelDokter;
import model.ModelPoli;
import model.ModelSchedule;
import node.Dokter;
import node.Poli;
import node.Schedule;

import java.util.ArrayList;

public class DokterController {
    public ModelDokter modelDokter;
    public ModelSchedule modelSchedule;
    ModelPoli modelPoli;

    public DokterController() {
        this.modelDokter = new ModelDokter();
        this.modelSchedule = new ModelSchedule();
        this.modelPoli = new ModelPoli();
    }

    public void addDokter(String nama, int idPoli){
        int id = modelDokter.getLastCode()+1;
        Poli poli = modelPoli.searchPoli(idPoli);
        Dokter dokter = new Dokter(id, nama, poli);
        modelDokter.addDokterModel(dokter);
    }

    public void editDokter(int id, String nama, int idPoli){
        Poli poli = modelPoli.searchPoli(idPoli);
        modelDokter.editDokter(id, nama, poli);
    }

    public void deleteDokter(int id){
        modelDokter.deleteDokter(id);
    }

    public Dokter searchDokter(int id){
        return modelDokter.searchDokter(id);
    }


    public void addSchedule(int idDokter, String hari, String jam){
        Dokter dokter = modelDokter.searchDokter(idDokter);
        int id = modelDokter.getLastScheduleIndex(idDokter)+1;
        Schedule schedule = new Schedule(id, hari, jam, dokter.namaDokter);
        modelDokter.addScheduleDoctor(idDokter, schedule);
        modelSchedule.addSchedule(schedule);
    }

    public void editSchedule(int idD, int idJ, String har, String jam){
        modelDokter.editJadwal(idD, idJ, har, jam);
        modelSchedule.editSchedule(idJ, har, jam);
    }

    public void deleteSchedule(int idD, int idJ, String nmD){
        modelDokter.deleteJadwal(idD, idJ);
        modelSchedule.deleteSchedule(idJ, nmD);
    }

    public ArrayList<Schedule> viewDoctorSchedule(String day){
        ArrayList<Schedule> schedules = modelSchedule.getDaySchedules(day);

        return schedules;
    }
}
