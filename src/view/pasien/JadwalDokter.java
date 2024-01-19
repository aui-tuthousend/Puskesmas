package view.pasien;

import view.HomePage;
import javax.swing.*;

public class JadwalDokter extends JFrame {

    public JadwalDokter(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 600);
        setLayout(null);
        setResizable(false);
        components();
        setVisible(true);
    }

    public void components(){
        JButton back = new JButton("LogOut");
        back.setBounds(30, 30, 90, 30);

        JLabel label = new JLabel("Jadwal Praktek Dokter");
        label.setBounds(165, 120, 200, 20);

        back.addActionListener(e -> event());
        add(back);
        add(label);
    }

    public void event(){
        HomePage homePage = new HomePage();
        this.dispose();
        homePage.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(JadwalDokter::new);
    }


}