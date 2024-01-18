package view.admin.CRUDdokter;

import controller.DokterController;
import node.Dokter;
import node.Schedule;
import view.admin.ListDokter;

import javax.swing.*;
import java.awt.*;

public class ViewDokter extends JFrame {
    int idDokter;
    String namaPoli;
    DokterController dokterController;
    public ViewDokter(int id, String nama){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 600);
        setVisible(true);
        setLayout(null);

        idDokter = id;
        namaPoli= nama;
        dokterController = new DokterController();

        setResizable(false);
        component();
    }

    public void component(){
        Dokter dokter = dokterController.searchDokter(idDokter);
        JButton back = new JButton("Back");
        back.setBounds(30, 30, 90, 30);

        JLabel judul = new JLabel("Detail Dokter");
        judul.setBounds(350, 150, 300, 20);

        JLabel namaDok = new JLabel(dokter.namaDokter);
        namaDok.setBounds(200, 180, 300, 30);

        JLabel namaP = new JLabel(namaPoli);
        namaP.setBounds(200, 200, 300, 30);

        JLabel jadPrak = new JLabel("Jadwal Praktek");
        jadPrak.setBounds(200, 230, 200, 30);

        JButton tamba = new JButton("+");
        tamba.setBounds(300, 235, 50, 20);

        viewJadwal(dokter);

        tamba.addActionListener(e -> tambaJadwal());
        back.addActionListener(e -> event());

        add(judul);
        add(tamba);
        add(jadPrak);
        add(namaP);
        add(back);
        add(namaDok);
    }

    public void event(){
        ListDokter listDokter = new ListDokter();
        this.dispose();
        listDokter.setVisible(true);
    }

    public void viewJadwal(Dokter dokter){
        int y=265;
        for (Schedule jadwal: dokter.schedules){
            JLabel label = new JLabel(jadwal.hari+" "+jadwal.jam);
            label.setBounds(200, y, 200, 20);

            JButton edit = new JButton("edit");
            edit.setBounds(350, y, 70, 20);

            JButton delete = new JButton("delete");
            delete.setBounds(430, y, 70, 20);
            y+=30;

            add(delete);
            add(edit);
            add(label);
        }
    }

    private void tambaJadwal() {
        JPanel inputPanel = new JPanel();
        JTextField textField1 = new JTextField(10);
        JTextField textField2 = new JTextField(10);

        inputPanel.setLayout(new GridLayout(2, 2));
        inputPanel.add(new JLabel("Hari:"));
        inputPanel.add(textField1);
        inputPanel.add(new JLabel("Jam:"));
        inputPanel.add(textField2);

        int result = JOptionPane.showConfirmDialog(this, inputPanel, "Masukkan Hari dan Jam", JOptionPane.OK_CANCEL_OPTION);

        if (result == JOptionPane.OK_OPTION) {
            String hari = textField1.getText().trim();
            String jam = textField2.getText().trim();

            if (!hari.isEmpty() && !jam.isEmpty()) {
                dokterController.addSchedule(idDokter, hari, jam);
                refresh();
            }
        }
    }

    public void refresh(){
        this.dispose();
        ViewDokter viewDokter = new ViewDokter(idDokter, namaPoli);
    }
}
