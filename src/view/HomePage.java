package view;

import controller.DokterController;
import node.Dokter;
import node.Schedule;
import view.admin.LoginAdmin;
import view.pasien.LoginPasien;
import view.pasien.RegisPasien;

import javax.swing.*;
import java.awt.*;

public class HomePage extends JFrame {
    LoginPasien loginPasien;
    RegisPasien regisPasien;
    JPanel inputPanel;
    DokterController dokterController;


    public HomePage(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 600);
        setLayout(null);
        setResizable(false);
        dokterController = new DokterController();

        components();
        setVisible(true);
    }

    public void components(){
//        gambar();
        Font font = new Font("HelveticaNeue", Font.ITALIC, 20);

        JLabel judul = new JLabel("Pendaftaran Puskesmas Online🩺");
        judul.setForeground(Color.green);
        judul.setFont(font);
        judul.setBounds(310, 180, 300, 40);

        JButton daftarPasien = new JButton("registrasi pasien");
        daftarPasien.setBounds(350, 230, 200, 30);
        daftarPasien.setForeground(Color.white);
        daftarPasien.setBackground(Color.blue);
        daftarPasien.setBorderPainted(false);

        JButton ambilAntrean = new JButton("ambil antrean");
        ambilAntrean.setBounds(350, 270, 200, 30);
        ambilAntrean.setForeground(Color.white);
        ambilAntrean.setBackground(Color.blue);
        ambilAntrean.setBorderPainted(false);

        JButton jadwalPrak = new JButton("Jadwal Praktek Dokter");
        jadwalPrak.setBounds(350, 310, 200, 30);
        jadwalPrak.setForeground(Color.white);
        jadwalPrak.setBackground(Color.blue);
        jadwalPrak.setBorderPainted(false);

        JButton loginAdmin = new JButton("Login admin");
        loginAdmin.setBounds(700, 500, 150, 30);
        loginAdmin.setForeground(Color.white);
        loginAdmin.setBackground(Color.DARK_GRAY);
        loginAdmin.setBorderPainted(false);

        daftarPasien.addActionListener(e -> daftarPasienView());
        ambilAntrean.addActionListener(e -> ambilAntreanView());
        loginAdmin.addActionListener(e -> loginAdminView());
        jadwalPrak.addActionListener(e -> jadwalPraktek());

        add(judul);
        add(daftarPasien);
        add(ambilAntrean);
        add(jadwalPrak);
        add(loginAdmin);
    }

    public void gambar(){
        ImageIcon icon = new ImageIcon("src/gambar/1211469.jpg");
        Image gambar = icon.getImage();

        Image resized = gambar.getScaledInstance(900, 600, Image.SCALE_SMOOTH);
        ImageIcon resizedd = new ImageIcon(resized);
        JLabel gamba = new JLabel(resizedd);
        gamba.setBounds(0, 0, 900, 600);

        add(gamba);
    }

    public void daftarPasienView(){
        regisPasien = new RegisPasien();
        this.setVisible(false);
        regisPasien.setVisible(true);
    }

    public void ambilAntreanView(){
        loginPasien = new LoginPasien();
        this.setVisible(false);
        loginPasien.setVisible(true);
    }

    public void loginAdminView(){
        LoginAdmin loginView = new LoginAdmin();
        this.setVisible(false);
        loginView.setVisible(true);
    }

    public void jadwalPraktek(){
        inputPanel = new JPanel();

        inputPanel.setLayout(new GridLayout( 10,1));
        for (Dokter dokter: dokterController.modelDokter.dokters){
            inputPanel.add(new JLabel("Dokter : "+dokter.namaDokter));
            for (Schedule schedule: dokter.schedules){
                inputPanel.add(new JLabel(schedule.hari+" "+schedule.jam));
            }
            inputPanel.add(new JLabel("\n"));

        }
        int result = JOptionPane.showConfirmDialog(this, inputPanel, "Jadwal Praktek dokter", JOptionPane.OK_CANCEL_OPTION);

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(HomePage::new);
    }

}
