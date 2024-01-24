package controller;

import model.ModelTransaction;
import node.Poli;
import node.Queue;
import node.Transaction;

public class TransactionController {
    public ModelTransaction modelTransaction;

    public TransactionController(){
        this.modelTransaction = new ModelTransaction();
    }
    public void addTransaction(Queue antrean, String poli){
        int id = modelTransaction.getLastCode()+1;
        Transaction transaction = new Transaction(id, antrean, poli);
        modelTransaction.modelAddTransaction(transaction);
    }

    public Transaction searchTransaksi(int idT){
        return modelTransaction.searchTransaction(idT);
    }
}
