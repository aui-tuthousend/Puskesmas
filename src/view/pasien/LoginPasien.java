package view.pasien;

import controller.PasienController;
import model.ModelPasien;
import node.Pasien;
import view.HomePage;
import view.component.RoundButton;
import view.component.RoundJTextField;

import javax.swing.*;
import java.awt.*;

public class LoginPasien extends JFrame {
    JTextField uname;
    RoundButton login;
    JLabel warn;
    PasienController pasienController;
    PilihPoli pilihPoli;
    public LoginPasien(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 600);
        setVisible(true);
        setLayout(null);

        pasienController = new PasienController();

        setResizable(false);
        component();
        getContentPane().setBackground(new Color(248, 244, 236));
    }

    public void component(){
        RoundButton back = new RoundButton("Back");
        back.setBounds(30, 30, 90, 30);
        back.setForeground(Color.white);
        back.setBackground(Color.black);

        JLabel judul = new JLabel("Ini Ambil Tikek Pasien! ___*( ￣皿￣)/#____");
        judul.setBounds(350, 160, 300, 30);

        JLabel username = new JLabel("Input NIK/BPJS");
        username.setBounds(350, 200, 200, 20);

        uname = new RoundJTextField(15);
        uname.setBounds(350, 220, 200, 30);

        login = new RoundButton("Lanjut");
        login.setBounds(350, 260, 200, 30);
        login.setForeground(Color.white);
        login.setBackground(Color.black);

        warn = new JLabel();
        warn.setBounds(350, 290, 200, 30);


        back.addActionListener(e -> event());
        login.addActionListener(e -> lojinBang());

        add(warn);
        add(back);
        add(judul);
        add(username);
        add(uname);
        add(login);
    }

    public void lojinBang() {
        boolean found = false;

        for (Pasien pasien : pasienController.modelPasien.pasiens) {
            if (uname.getText().equals(pasien.NIK) || uname.getText().equals(pasien.BPJS)) {
                found = true;
                pilihPoli = new PilihPoli(pasien.idPasien);
                this.setVisible(false);
                pilihPoli.setVisible(true);
                break;
            }
        }

        if (!found) {
            warn.setText("NIK/BPJS belum terdaftar :)");
            warn.setVisible(true);
        }
    }


    public void event(){
        HomePage homePage = new HomePage();
        this.setVisible(false);
        homePage.setVisible(true);
    }

}
