package model;

import com.google.gson.reflect.TypeToken;
import modelGSON.ModelGSON;
import node.Schedule;

import java.util.ArrayList;

public class ModelSchedule {
    private ArrayList<Schedule> schedules;
    ModelGSON modelGSON;

    public ModelSchedule(){
        modelGSON = new ModelGSON("src/database/schedule.json");

        schedules = modelGSON.readFromFile(new TypeToken<ArrayList<Schedule>>() {
        }.getType());
        if (schedules == null){
            this.schedules = new ArrayList<>();
        }
    }

    public void addSchedule(Schedule schedule){
        this.schedules.add(schedule);
        modelGSON.writeToFile(schedules);
    }

    public void editSchedule(int idJ, String hr, String jm){
        Schedule schedule = searchSchedule(idJ);
        schedule.hari = hr;
        schedule.jam = jm;
        modelGSON.writeToFile(schedules);
    }

    public void deleteSchedule(int id, String nama){
        for (Schedule schedule: schedules){
            if (schedule.idSchedule == id && schedule.namaDoketer.equals(nama)){
                schedules.remove(schedule);
            }
        }
        modelGSON.writeToFile(schedules);
    }

    public ArrayList<Schedule> getDaySchedules(String day){
        ArrayList<Schedule> result = new ArrayList<>();
        for (Schedule schedule: schedules){
            if (schedule.hari.equals(day)){
                result.add(schedule);
            }
        }
        return result;
    }

    public Schedule searchSchedule(int id){
        for (Schedule schedule: schedules){
            if (schedule.idSchedule == id){
                return schedule;
            }
        }
        return null;
    }

    public int getLastCode(){
        int idx;
        if(schedules.isEmpty()) {
            return -1;
        } else {
            idx = schedules.size() - 1;
            return schedules.get(idx).idSchedule;
        }
    }
}
