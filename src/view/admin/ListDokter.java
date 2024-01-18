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
            edit.setBounds(310, y, 80, 20);

            JButton delete = new JButton("hapus");
            delete.setBounds(400, y, 80, 20);

            edit.addActionListener(e -> editDokter(dokter.idDokter, dokter.poli));
            delete.addActionListener(e -> deleteDokter(dokter.idDokter));

            add(delete);
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

    public void tambahJadwal(int idD){

    }

    public void refresh(){
        this.dispose();
        ListDokter listDokter = new ListDokter();
    }
//    public static void main(String[] args) {
//        SwingUtilities.invokeLater(ListDokter::new);
//    }
}
