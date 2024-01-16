package view.pasien;

import controller.PasienController;
import model.ModelPasien;
import node.Pasien;
import view.HomePage;

import javax.swing.*;

public class LoginPasien extends JFrame {
    JTextField uname;
    JButton login;
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
    }

    public void component(){
        JButton back = new JButton("Back");
        back.setBounds(30, 30, 90, 30);

        JLabel judul = new JLabel("Ini Ambil Tikek Pasien! ___*( ￣皿￣)/#____");
        judul.setBounds(350, 160, 300, 30);

        JLabel username = new JLabel("Input NIK/BPJS");
        username.setBounds(350, 200, 200, 20);

        uname = new JTextField();
        uname.setBounds(350, 220, 200, 30);

        login = new JButton("Lanjut");
        login.setBounds(350, 260, 200, 30);


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

        for (Pasien pasien : ModelPasien.pasiens) {
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
