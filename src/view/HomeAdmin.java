package view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class HomeAdmin extends JFrame {

    List<JButton> buttons;
    public HomeAdmin(){
        this.buttons = new ArrayList<>();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 600);
        setLayout(null);
        setResizable(false);
        components();
        actionHandler();
        setVisible(true);
    }

    public void components(){
        JButton back = new JButton("LogOut");
        back.setBounds(30, 30, 90, 30);

        JLabel label = new JLabel("Menu Admin");
        label.setBounds(165, 120, 200, 20);


        String[] data = {"List Poli", "List Dokter", "Jadwal Praktek Dokter", "Cetak Transaksi"};
        int y = 150;
        for (String txt: data){
            JButton button = new JButton(txt);
            button.setBounds(165, y, 200, 50);

            y+=65;
            buttons.add(button);
            add(button);
        }

        back.addActionListener(e -> event());
        add(back);
        add(label);
    }

    public void event(){
        HomePage homePage = new HomePage();
        this.setVisible(false);
        homePage.setVisible(true);
    }

    public void actionHandler(){
        buttons.get(0).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        buttons.get(1).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        buttons.get(2).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        buttons.get(3).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
}
