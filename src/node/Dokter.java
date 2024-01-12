package node;

import java.util.ArrayList;

public class Dokter {
    public int idDokter;
    public String namaDokter;
    public String poli;
    public ArrayList<Schedule> schedules;

    public Dokter(int idDokter, String namaDokter, String poli) {
        this.idDokter = idDokter;
        this.namaDokter = namaDokter;
        this.poli = poli;
    }

    public void addSchedule(Schedule schedule){
        this.schedules.add(schedule);
    }

    public void viewDokter(){
        System.out.println("Nama Dokter    : "+namaDokter);
        System.out.println("Poli           : "+poli);
        System.out.println("Jadwal Praktek : ");
        for (Schedule jadwal: schedules){
            jadwal.viewJadwal();
        }
    }
}
