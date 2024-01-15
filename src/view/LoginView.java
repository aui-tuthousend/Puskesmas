package view;

import javax.swing.*;

public class LoginView extends JFrame {
    public LoginView(){
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

        JLabel judul = new JLabel("LOgin Atmin");
        judul.setBounds(350, 160, 200, 30);

        JLabel username = new JLabel("Input Username");
        username.setBounds(350, 200, 200, 20);

        JTextField uname = new JTextField();
        uname.setBounds(350, 220, 200, 30);

        JLabel pw = new JLabel("Input Password");
        pw.setBounds(350, 250, 200, 20);

        JPasswordField pass = new JPasswordField();
        pass.setBounds(350, 270, 200, 30);



        back.addActionListener(e -> event());
        add(back);
        add(judul);
        add(username);
        add(uname);
        add(pw);
        add(pass);
    }

    public void event(){
        HomePage homePage = new HomePage();
        this.setVisible(false);
        homePage.setVisible(true);
    }
}
