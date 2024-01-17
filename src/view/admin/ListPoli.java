package view.admin;

import controller.PoliController;
import node.Poli;
import view.HomePage;
import view.admin.HomeAdmin;

import javax.swing.*;

public class ListPoli extends JFrame {
    PoliController poliController;
    public ListPoli(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 600);
        setVisible(true);
        setLayout(null);

        poliController = new PoliController();
        setResizable(false);
        component();
    }

    public void component(){
        JButton back = new JButton("Back");
        back.setBounds(30, 30, 90, 30);

        JLabel judul = new JLabel("List Poli");
        judul.setBounds(165, 90, 100, 20);

        JButton addPoli = new JButton("+");
        addPoli.setBounds(225, 90, 50, 25);

        int y=120;
        for (Poli poli: poliController.modelPoli.polis){
            JLabel label = new JLabel(poli.namaPoli);
            label.setBounds(165, y, 100, 20);
            y+=25;
            add(label);
        }


        back.addActionListener(e -> event());

        add(back);
        add(judul);
        add(addPoli);
    }

    public void event(){
        HomeAdmin homeAdmin = new HomeAdmin();
        this.setVisible(false);
        homeAdmin.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(ListPoli::new);
    }

}
