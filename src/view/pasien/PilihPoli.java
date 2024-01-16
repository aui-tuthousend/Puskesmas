package view.pasien;

import view.pasien.LoginPasien;

import javax.swing.*;

public class PilihPoli extends JFrame {
    public PilihPoli(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 600);
        setVisible(true);
        setLayout(null);
        setResizable(false);
        component();
    }

    public void component(){
        JButton back = new JButton("Kembali");
        back.setBounds(30, 30, 90, 30);


        back.addActionListener(e -> event());

        add(back);
    }

    public void event(){
        LoginPasien loginPasien = new LoginPasien();
        this.setVisible(false);
        loginPasien.setVisible(true);
    }
}
