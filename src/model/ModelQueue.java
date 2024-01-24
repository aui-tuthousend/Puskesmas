package model;

import com.google.gson.reflect.TypeToken;
import modelGSON.ModelGSON;
import node.Queue;
import node.Schedule;

import java.util.ArrayList;

public class ModelQueue {
    private ArrayList<node.Queue> queues;
    ModelGSON modelGSON;

    public ModelQueue(){
        modelGSON = new ModelGSON("src/database/queue.json");

        queues = modelGSON.readFromFile(new TypeToken<ArrayList<Queue>>() {
        }.getType());
        if (queues == null){
            this.queues = new ArrayList<>();
        }
    }

    public void addQueue(node.Queue queue){
        this.queues.add(queue);
        modelGSON.writeToFile(queues);
    }

}
