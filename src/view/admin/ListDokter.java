package view.admin;

import controller.DokterController;

import javax.swing.*;

public class ListDokter extends JFrame {
//    DokterController dokterController;
    public ListDokter(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 600);
        setVisible(true);
        setLayout(null);
        setResizable(false);
//        dokterController = new DokterController();
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


        back.addActionListener(e -> event());

        add(back);
        add(tambahDokter);
        add(judul);
    }

    public void event(){
        HomeAdmin homeAdmin = new HomeAdmin();
        this.setVisible(false);
        homeAdmin.setVisible(true);
    }

//    public static void main(String[] args) {
//        SwingUtilities.invokeLater(ListDokter::new);
//    }
}
