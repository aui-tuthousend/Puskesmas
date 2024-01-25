package view.admin;

import controller.DokterController;
import controller.PoliController;
import node.Admin;
import node.Dokter;
import node.Poli;
import node.Schedule;
import view.component.RoundButton;

import javax.swing.*;
import java.awt.*;

public class ViewDokter extends JFrame {
    int idDokter;
    int idPoli;
    DokterController dokterController;
    PoliController poliController;
    Admin atmin;
    public ViewDokter(int id, int idPol, Admin admin){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 600);
        setVisible(true);
        setLayout(null);
        atmin =admin;
        idDokter = id;
        idPoli= idPol;
        dokterController = new DokterController();
        poliController = new PoliController();

        setResizable(false);
        component();
        getContentPane().setBackground(new Color(248, 244, 236));

    }

    public void component(){
        Dokter dokter = dokterController.searchDokter(idDokter);
        RoundButton back = new RoundButton("Back");
        back.setBounds(30, 30, 90, 30);
        back.setForeground(Color.white);
        back.setBackground(Color.red);

        JLabel judul = new JLabel("Detail Dokter");
        judul.setBounds(350, 150, 300, 20);

        JLabel namaDok = new JLabel(dokter.namaDokter);
        namaDok.setBounds(200, 180, 300, 30);

        Poli poll = poliController.searchPoli(dokter.poli);
        JLabel namaP = new JLabel(poll.namaPoli);
        namaP.setBounds(200, 200, 300, 30);

        JLabel jadPrak = new JLabel("Jadwal Praktek");
        jadPrak.setBounds(200, 230, 200, 30);

        RoundButton tamba = new RoundButton("+");
        tamba.setBounds(300, 235, 50, 20);
        tamba.setForeground(Color.black);
        tamba.setBackground(Color.yellow);

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
        ListDokter listDokter = new ListDokter(atmin);
        this.dispose();
        listDokter.setVisible(true);
    }

    public void viewJadwal(Dokter dokter){
        int y=265;
        for (Schedule jadwal: dokter.schedules){
            JLabel label = new JLabel(jadwal.hari+" "+jadwal.jam);
            label.setBounds(200, y, 200, 20);

            RoundButton edit = new RoundButton("edit");
            edit.setBounds(350, y, 70, 20);
            edit.setForeground(Color.white);
            edit.setBackground(Color.black);

            RoundButton delete = new RoundButton("delete");
            delete.setBounds(430, y, 70, 20);
            delete.setForeground(Color.white);
            delete.setBackground(Color.black);
            y+=30;

            edit.addActionListener(e -> editJadual(jadwal.idSchedule, jadwal.hari, jadwal.jam));
            delete.addActionListener(e -> deleteJadual(idDokter, jadwal.idSchedule, jadwal.namaDoketer));

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

    public void editJadual(int idJadwal, String hr, String jm){
        JPanel inputPanel = new JPanel();
        JTextField textField1 = new JTextField(hr);
        JTextField textField2 = new JTextField(jm);

        inputPanel.setLayout(new GridLayout(2, 2));
        inputPanel.add(new JLabel("Hari:"));
        inputPanel.add(textField1);
        inputPanel.add(new JLabel("Jam:"));
        inputPanel.add(textField2);

        int result = JOptionPane.showConfirmDialog(this, inputPanel, "Edit Hari dan Jam", JOptionPane.OK_CANCEL_OPTION);

        if (result == JOptionPane.OK_OPTION) {
            String hari = textField1.getText().trim();
            String jam = textField2.getText().trim();

            if (!hari.isEmpty() && !jam.isEmpty()) {
                dokterController.editSchedule(idDokter, idJadwal, hari, jam);
                refresh();
            }
        }
    }

    public void deleteJadual(int idD, int idJ, String nmD){
        int result = JOptionPane.showConfirmDialog(
                null,
                "Apakah Anda yakin ingin menghapus?",
                "Konfirmasi",
                JOptionPane.YES_NO_OPTION);

        if (result == JOptionPane.YES_OPTION) {
            dokterController.deleteSchedule(idD, idJ, nmD);
            refresh();
        }
    }

    public void refresh(){
        this.dispose();
        ViewDokter viewDokter = new ViewDokter(idDokter, idPoli, atmin);
    }
}
