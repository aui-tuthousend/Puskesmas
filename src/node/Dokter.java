package node;

import java.util.ArrayList;

public class Dokter {
    public int idDokter;
    public String namaDokter;
    public int poli;
    public ArrayList<Schedule> schedules;

    public Dokter(int idDokter, String namaDokter, int poli) {
        this.idDokter = idDokter;
        this.namaDokter = namaDokter;
        this.poli = poli;
        this.schedules = new ArrayList<>();
    }

    public void addSchedule(Schedule schedule){
        this.schedules.add(schedule);
    }
}
