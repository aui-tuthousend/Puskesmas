package model;

import com.google.gson.reflect.TypeToken;
import modelGSON.ModelGSON;
import node.Transaction;

import java.util.ArrayList;

public class ModelTransaction {
    private ArrayList<Transaction> transactions;
    ModelGSON modelGSON;

    public ModelTransaction() {
        modelGSON = new ModelGSON<>("src/database/transaction.json");
        transactions = modelGSON.readFromFile(new TypeToken<ArrayList<Transaction>>() {
        }.getType());
        if (transactions == null){
            this.transactions = new ArrayList<>();
        }
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
//            System.out.println("\nShutting down. Saving data to JSON file...");
            modelGSON.writeToFile(transactions);
        }));
    }

    public void modelAddTransaction(Transaction transaction){
        transactions.add(transaction);
    }

    public Transaction searchTransaction(int id){
        for (Transaction data: transactions){
            if (data.idTransaksi == id){
                return data;
            }
        }
        return null;
    }
    public void showAllTransaction(){
        for (Transaction data: transactions){
            data.viewTransaction();
        }
    }

}
