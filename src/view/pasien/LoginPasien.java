package view.pasien;

import view.HomePage;

import javax.swing.*;

public class LoginPasien extends JFrame {
    JTextField uname;
    JLabel label;

    JButton login;
    public LoginPasien(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 600);
        setVisible(true);
        setLayout(null);
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

        label = new JLabel();
        label.setBounds(350, 380, 200, 30);
        add(label);


        back.addActionListener(e -> event());
        login.addActionListener(e -> lojinBang());

        add(back);
        add(judul);
        add(username);
        add(uname);
        add(login);
    }

    public void lojinBang(){
        PilihPoli pilihPoli = new PilihPoli();
        this.setVisible(false);
        pilihPoli.setVisible(true);
    }

    public void event(){
        HomePage homePage = new HomePage();
        this.setVisible(false);
        homePage.setVisible(true);
    }
}
