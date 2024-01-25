package view.admin;
import controller.TransactionController;
import node.Admin;
import node.Transaction;
import view.component.RoundButton;

import javax.swing.*;
import java.awt.*;

public class CetakTransaksi extends JFrame {
    Admin atmin;
    JPanel inputPanel;
    TransactionController transactionController;
    public CetakTransaksi(Admin admin){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 600);
        setVisible(true);
        setLayout(null);

        this.atmin = admin;
        this.transactionController = new TransactionController();

        setResizable(false);
        component();
        getContentPane().setBackground(new Color(248, 244, 236));
    }

    public void component(){
        RoundButton back = new RoundButton("Back");
        back.setBounds(30, 30, 90, 30);
        back.setForeground(Color.white);
        back.setBackground(Color.black);

        JLabel judul = new JLabel("List Transaksi");
        judul.setBounds(165, 90, 100, 20);

        int y=130;
        for (Transaction transaction: transactionController.modelTransaction.transactions){
            JLabel label = new JLabel(transaction.poli+" "+transaction.antrean.kodePasien+" "+transaction.antrean.pasien.namaPasien);
            label.setBounds(165, y, 200, 20);

            RoundButton print = new RoundButton("cetak");
            print.setBounds(365, y, 100, 20);
            print.setForeground(Color.white);
            print.setBackground(Color.black);

            print.addActionListener(e -> cetakTransaksi(transaction));
            add(label);
            add(print);
            y+=30;
        }

        back.addActionListener(e -> event());

        add(back);
        add(judul);
    }

    public void event(){
        HomeAdmin homeAdmin = new HomeAdmin(atmin);
        this.dispose();
        homeAdmin.setVisible(true);
    }

    public void cetakTransaksi(Transaction transaction){
        inputPanel = new JPanel();

        inputPanel.setLayout(new GridLayout( 10,1));
        inputPanel.add(new JLabel("+<<Puskesmas SidoMuncul>>+"));
        inputPanel.add(new JLabel("  Kode Antrean : "+transaction.antrean.kodePasien));
        inputPanel.add(new JLabel("  Poli : "+transaction.poli));
        inputPanel.add(new JLabel("  Nama Pasien : "+transaction.antrean.pasien.namaPasien));
        inputPanel.add(new JLabel("  NIK : "+transaction.antrean.pasien.NIK));
        inputPanel.add(new JLabel("  BPJS : "+transaction.antrean.pasien.BPJS));
        inputPanel.add(new JLabel("  Tanggal : "+transaction.tanggal));
        inputPanel.add(new JLabel("  Admin : "+atmin.getUsername()));

        int result = JOptionPane.showConfirmDialog(this, inputPanel, "Data Transaksi Pasien", JOptionPane.OK_CANCEL_OPTION);

    }
}
