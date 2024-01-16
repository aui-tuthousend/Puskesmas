package controller;

import model.ModelDokter;
import model.ModelSchedule;
import node.Dokter;
import node.Schedule;

import java.util.ArrayList;

public class DokterController {
    ModelDokter modelDokter;
    ModelSchedule modelSchedule;

    public DokterController() {
        this.modelDokter = new ModelDokter();
        this.modelSchedule = new ModelSchedule();
    }

    public void addDokter(String nama, String poli){
        int id = modelDokter.getLastCode()+1;
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

    public ArrayList<Schedule> viewDoctorSchedule(String day){
        ArrayList<Schedule> schedules = modelSchedule.getDaySchedules(day);

        return schedules;
    }
}
