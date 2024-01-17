package view.admin;

import controller.DokterController;
import controller.PoliController;
import node.Dokter;
import node.Poli;
import view.admin.CRUDdokter.EditDokter;
import view.admin.CRUDdokter.TambahDokter;

import javax.swing.*;

public class ListDokter extends JFrame {
    DokterController dokterController;
    PoliController poliController;
    public ListDokter(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 600);
        setVisible(true);
        setLayout(null);
        dokterController = new DokterController();
        poliController = new PoliController();
        setResizable(false);
        component();
    }

    public void component(){
        JButton back = new JButton("Back");
        back.setBounds(30, 30, 90, 30);

        JLabel judul = new JLabel("List Dokter");
        judul.setBounds(165, 90, 100, 20);

        JButton tambahDokter = new JButton("+");
        tambahDokter.setBounds(235, 90, 50, 25);

        int y=130;
        for (Dokter dokter: dokterController.modelDokter.dokters){
            JLabel label = new JLabel(dokter.namaDokter);
            label.setBounds(165, y, 100, 20);
            Poli pyoli = poliController.searchPoli(dokter.poli);
            JLabel poli = new JLabel(pyoli.namaPoli);
            poli.setBounds(265, y, 100, 20);

            JButton edit = new JButton("edit");
            edit.setBounds(365, y, 80, 20);

            edit.addActionListener(e -> editDokter(dokter.idDokter, dokter.poli));

            add(edit);
            add(label);
            add(poli);
            y+=30;
        }


        back.addActionListener(e -> event());
        tambahDokter.addActionListener(e -> tambaDokter());

        add(back);
        add(tambahDokter);
        add(judul);
    }

    public void event(){
        HomeAdmin homeAdmin = new HomeAdmin();
        this.setVisible(false);
        homeAdmin.setVisible(true);
    }

    public void tambaDokter(){
        TambahDokter tambahDokter = new TambahDokter();
        this.setVisible(false);
        tambahDokter.setVisible(true);

    }

    public void editDokter(int idD, int idP){
        EditDokter editDokter = new EditDokter(idD, idP);
        this.setVisible(false);
        editDokter.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(ListDokter::new);
    }
}
