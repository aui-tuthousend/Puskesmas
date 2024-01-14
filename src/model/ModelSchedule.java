package model;

import com.google.gson.reflect.TypeToken;
import modelGSON.ModelGSON;
import node.Dokter;
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

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("\nShutting down. Saving data to JSON file...");
            modelGSON.writeToFile(schedules);
        }));
    }

    public void addSchedule(Schedule schedule){
        this.schedules.add(schedule);
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
}
