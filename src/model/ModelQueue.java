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

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
//            System.out.println("\nShutting down. Saving data to JSON file...");
            modelGSON.writeToFile(queues);
        }));
    }

    public void addQueue(node.Queue queue){
        this.queues.add(queue);
    }

    public void showAllQueues(){
        for (node.Queue queue: queues){
            queue.viewQueue();
        }
    }
}
