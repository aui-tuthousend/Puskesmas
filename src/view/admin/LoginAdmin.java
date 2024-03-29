package view.admin;

import node.Admin;
import view.HomePage;
import view.component.RoundButton;
import view.component.RoundJTextField;

import javax.swing.*;
import java.awt.*;

public class LoginAdmin extends JFrame {
    JTextField uname;
    JLabel label;

    JPasswordField pass;


    public LoginAdmin(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 600);
        setVisible(true);
        setLayout(null);
        setResizable(false);
        component();
        getContentPane().setBackground(new Color(248, 244, 236));
    }

    public void component(){
        RoundButton back = new RoundButton("Back");
        back.setBounds(30, 30, 90, 30);
        back.setForeground(Color.white);
        back.setBackground(new Color(172, 125, 136));
        back.setBorderPainted(false);

        JLabel judul = new JLabel("Ini Perintah Atmin! ___*( ￣皿￣)/#____");
        judul.setBounds(350, 160, 300, 30);

        JLabel username = new JLabel("Input Username");
        username.setBounds(350, 200, 200, 20);

        uname = new RoundJTextField(15);
        uname.setBounds(350, 220, 200, 30);

        JLabel pw = new JLabel("Input Password");
        pw.setBounds(350, 250, 200, 20);

        pass = new JPasswordField();
        pass.setBounds(350, 270, 200, 30);

        RoundButton login = new RoundButton("Login");
        login.setBounds(350, 340, 200, 30);
        login.setForeground(Color.white);
        login.setBackground(new Color(172, 125, 136));
        login.setBorderPainted(false);

        label = new JLabel();
        label.setBounds(350, 380, 200, 30);
        add(label);


        back.addActionListener(e -> event());
        login.addActionListener(e -> lojinBang());

        add(back);
        add(judul);
        add(username);
        add(uname);
        add(pw);
        add(pass);
        add(login);
    }

    public void lojinBang(){
        char[] paswod = pass.getPassword();
        String passwordReal = String.valueOf(paswod);

        if (uname.getText().equals("ayo")&&passwordReal.equals("123")){
            Admin atmin = new Admin(uname.getText(),passwordReal);
            HomeAdmin homeAdmin = new HomeAdmin(atmin);
            this.setVisible(false);
            homeAdmin.setVisible(true);
        } else {
            label.setText("ID PW sala ea");
            label.setVisible(true);
        }
    }



    public void event(){
        HomePage homePage = new HomePage();
        this.setVisible(false);
        homePage.setVisible(true);
    }
}
