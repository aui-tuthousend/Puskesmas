package view;

import javax.swing.*;
import java.awt.*;

public class HomePage extends JFrame {

    public HomePage(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 600);
        setLayout(null);
        setResizable(false);
        components();
        setVisible(true);
    }

    public void components(){
        JLabel judul = new JLabel("Pendaftaran Puskesmas Online🩺");
        judul.setBounds(350, 200, 200, 30);

        JButton daftarPasien = new JButton("Daftar Pasien");
        daftarPasien.setBounds(350, 230, 200, 30);

        JButton ambilAntrean = new JButton("Ambil Antrean");
        ambilAntrean.setBounds(350, 270, 200, 30);

        JButton loginAdmin = new JButton("Login admin");
        loginAdmin.setBounds(700, 500, 150, 30);

        daftarPasien.addActionListener(e -> daftarPasienView());
        ambilAntrean.addActionListener(e -> ambilAntreanView());
        loginAdmin.addActionListener(e -> loginAdminView());


        add(daftarPasien);
        add(ambilAntrean);
        add(loginAdmin);
        add(judul);
    }

    public void actionHandler(){

    }
    public void daftarPasienView(){
        RegisPasien regisPasien = new RegisPasien();
        this.setVisible(false);
        regisPasien.setVisible(true);
    }

    public void ambilAntreanView(){

    }

    public void loginAdminView(){
        LoginView loginView = new LoginView();
        this.setVisible(false);
        loginView.setVisible(true);
    }

    public static void main(String[] args) {
        HomePage homePage = new HomePage();
    }

}
