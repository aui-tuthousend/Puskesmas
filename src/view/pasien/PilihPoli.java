package view.pasien;

import node.Pasien;

import javax.swing.*;

public class PilihPoli extends JFrame {
    Pasien pasien;
    public PilihPoli(Pasien pasien){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 600);
        setVisible(true);
        setLayout(null);

        this.pasien = pasien;

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
