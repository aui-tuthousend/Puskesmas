package view.pasien;

import controller.PasienController;
import controller.PoliController;
import node.Pasien;
import node.Poli;
import view.HomePage;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class PilihPoli extends JFrame {
    int idPasien;
    PoliController poliController;
    PasienController pasienController;
    List<JButton> buttons;
    List<Integer> idPolis;


    public PilihPoli(int idPasien){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 600);
        setVisible(true);
        setLayout(null);

        this.idPasien = idPasien;
        this.pasienController = new PasienController();
        this.poliController=new PoliController();
        this.buttons = new ArrayList<>();
        this.idPolis = new ArrayList<>();

        setResizable(false);
        component();
        actionHandler();
    }

    public void component(){
        JButton back = new JButton("Kembali");
        back.setBounds(30, 30, 90, 30);
        int y = 150;
        for (Poli poli: poliController.modelPoli.polis){
            JButton button = new JButton(poli.namaPoli);
            button.setBounds(165, y, 200, 50);

            y+=65;
            buttons.add(button);
            idPolis.add(poli.idPoli);
            add(button);
        }


        back.addActionListener(e -> event());

        add(back);
    }

    public void actionHandler(){
        for (Integer id: idPolis){
           buttons.get(id).addActionListener(e -> {
               Pasien pasien = pasienController.searchPasien(idPasien);
               boolean cek = poliController.getLastPasien(id, idPasien);
               if (cek){
                   int q = poliController.addQueue(id, pasien, buttons.get(id).getText())+1;
                   JOptionPane.showMessageDialog(this, "Sukses Mendaftar! \nNo antrean anda: "+q, "Sukses", JOptionPane.INFORMATION_MESSAGE);

                   HomePage homePage = new HomePage();
                   dispose();
                   homePage.setVisible(true);
               } else {
                JOptionPane.showMessageDialog(null, "Anda sudah daftar di poli ini :D", "Peringatan", JOptionPane.WARNING_MESSAGE);
               }

           });
        }
    }

    public void event(){
        LoginPasien loginPasien = new LoginPasien();
        this.setVisible(false);
        loginPasien.setVisible(true);
    }
}
