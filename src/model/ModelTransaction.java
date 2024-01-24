package model;

import com.google.gson.reflect.TypeToken;
import modelGSON.ModelGSON;
import node.Transaction;

import java.util.ArrayList;

public class ModelTransaction {
    public ArrayList<Transaction> transactions;
    ModelGSON modelGSON;

    public ModelTransaction() {
        modelGSON = new ModelGSON<>("src/database/transaction.json");
        transactions = modelGSON.readFromFile(new TypeToken<ArrayList<Transaction>>() {
        }.getType());
        if (transactions == null){
            this.transactions = new ArrayList<>();
        }
    }

    public void modelAddTransaction(Transaction transaction){
        transactions.add(transaction);
        modelGSON.writeToFile(transactions);
    }

    public Transaction searchTransaction(int id){
        for (Transaction data: transactions){
            if (data.idTransaksi == id){
                return data;
            }
        }
        return null;
    }

    public int getLastCode(){
        int idx;
        if(transactions.isEmpty()) {
            return -1;
        } else {
            idx = transactions.size() - 1;
            return transactions.get(idx).idTransaksi;
        }
    }

}
