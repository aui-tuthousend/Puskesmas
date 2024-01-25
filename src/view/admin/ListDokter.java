package view.admin;

import controller.DokterController;
import controller.PoliController;
import node.Admin;
import node.Dokter;
import node.Poli;
import view.RoundButton;

import javax.swing.*;
import java.awt.*;

public class ListDokter extends JFrame {
    DokterController dokterController;
    PoliController poliController;
    Admin atmin;
    public ListDokter(Admin admin){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 600);
        setVisible(true);
        setLayout(null);
        atmin = admin;
        dokterController = new DokterController();
        poliController = new PoliController();
        setResizable(false);
        component();
    }

    public void component(){
        RoundButton back = new RoundButton("Back");
        back.setBounds(30, 30, 90, 30);
        back.setForeground(Color.white);
        back.setBackground(Color.black);

        JLabel judul = new JLabel("List Dokter");
        judul.setBounds(165, 90, 100, 20);

        RoundButton tambahDokter = new RoundButton("+");
        tambahDokter.setBounds(235, 90, 50, 25);
        tambahDokter.setForeground(Color.white);
        tambahDokter.setBackground(Color.black);

        int y=130;
        for (Dokter dokter: dokterController.modelDokter.dokters){
            JLabel label = new JLabel(dokter.namaDokter);
            label.setBounds(165, y, 100, 20);
            Poli poll = poliController.searchPoli(dokter.poli);
            JLabel poli = new JLabel(poll.namaPoli);
            poli.setBounds(265, y, 100, 20);

            RoundButton viewDokter = new RoundButton("view");
            viewDokter.setBounds(350, y, 80, 20);
            viewDokter.setForeground(Color.white);
            viewDokter.setBackground(Color.black);

            RoundButton edit = new RoundButton("edit");
            edit.setBounds(440, y, 80, 20);
            edit.setForeground(Color.white);
            edit.setBackground(Color.black);

            RoundButton delete = new RoundButton("hapus");
            delete.setBounds(530, y, 80, 20);
            delete.setForeground(Color.white);
            delete.setBackground(Color.black);

            viewDokter.addActionListener(e -> viuDokter(dokter.idDokter, dokter.poli));
            edit.addActionListener(e -> editDok(dokter.idDokter, dokter.poli));
            delete.addActionListener(e -> deleteDokter(dokter.idDokter));

            add(viewDokter);
            add(delete);
            add(edit);
            add(label);
            add(poli);
            y+=30;
        }

        back.addActionListener(e -> event());
        tambahDokter.addActionListener(e -> tambDok());

        add(back);
        add(tambahDokter);
        add(judul);
    }

    public void event(){
        HomeAdmin homeAdmin = new HomeAdmin(atmin);
        this.setVisible(false);
        homeAdmin.setVisible(true);
    }

    private void tambDok() {
        JPanel inputPanel = new JPanel();

        DefaultListModel<String> listModel = new DefaultListModel<>();
        JList<String> listView = new JList<>(listModel);

        for (Poli poli: poliController.modelPoli.polis){
            listModel.addElement(poli.namaPoli);
        }

        JTextField textField1 = new JTextField(10);

        inputPanel.setLayout(new GridLayout(2, 2));
        inputPanel.add(new JLabel("Nama:"));
        inputPanel.add(textField1);
        inputPanel.add(new JLabel("Pilih Poli:"));
        inputPanel.add(listView);

        int result = JOptionPane.showConfirmDialog(this, inputPanel, "Tambah Data dokter", JOptionPane.OK_CANCEL_OPTION);

        if (result == JOptionPane.OK_OPTION) {
            int idx = listView.getSelectedIndex();
            if (!textField1.getText().isEmpty()){
                if (idx != -1) {
                    dokterController.addDokter(textField1.getText(), idx);
                    refresh();
                    JOptionPane.showMessageDialog(this, "Dokter Berhasil Ditambah!", "Sukses", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this, "Pilih Poli nya banh", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Nama DOkternya banh", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void editDok(int idD, int idP) {
        JPanel inputPanel = new JPanel();

        DefaultListModel<String> listModel = new DefaultListModel<>();
        JList<String> listView = new JList<>(listModel);

        for (Poli poli: poliController.modelPoli.polis){
            listModel.addElement(poli.namaPoli);
        }
        listView.setSelectedIndex(idP);
        JTextField textField1 = new JTextField(10);
        Dokter dokter = dokterController.searchDokter(idD);
        textField1.setText(dokter.namaDokter);

        inputPanel.setLayout(new GridLayout(2, 2));
        inputPanel.add(new JLabel("Nama:"));
        inputPanel.add(textField1);
        inputPanel.add(new JLabel("Pilih Poli:"));
        inputPanel.add(listView);

        int result = JOptionPane.showConfirmDialog(this, inputPanel, "Edit Data dokter", JOptionPane.OK_CANCEL_OPTION);

        if (result == JOptionPane.OK_OPTION) {
            int idx = listView.getSelectedIndex();
            if (!textField1.getText().isEmpty()){
                if (idx != -1) {
                    dokterController.editDokter(idD, textField1.getText(), idx);
                    refresh();
                    JOptionPane.showMessageDialog(this, "Dokter Berhasil Diedit!", "Sukses", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this, "Pilih Poli nya banh", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Nama DOkternya banh", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }


    public void deleteDokter(int idD){
        Dokter dokter = dokterController.searchDokter(idD);
        if (dokter.schedules.isEmpty()){
            int result = JOptionPane.showConfirmDialog(
                    null,
                    "Apakah Anda yakin ingin menghapus?",
                    "Konfirmasi",
                    JOptionPane.YES_NO_OPTION);

            if (result == JOptionPane.YES_OPTION) {
                dokterController.deleteDokter(idD);
                refresh();
            }
        }else {
            JOptionPane.showMessageDialog(null, "Dokter masih memiliki jadwal praktek!", "Peringatan", JOptionPane.WARNING_MESSAGE);
        }
    }

    public void viuDokter(int idD, int nama){
        ViewDokter viewDokter = new ViewDokter(idD, nama, atmin);
        this.setVisible(false);
        viewDokter.setVisible(true);
    }

    public void refresh(){
        this.dispose();
        ListDokter listDokter = new ListDokter(atmin);
    }
}
