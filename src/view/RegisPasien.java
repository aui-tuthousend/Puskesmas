package view;

import javax.swing.*;

public class RegisPasien extends JFrame {
    public RegisPasien(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 600);
        setLayout(null);
        setResizable(false);
        components();
        setVisible(true);
    }

    public void components(){
        JButton back = new JButton("Back");
        back.setBounds(30, 30, 90, 30);

        String[] data = {"Nama Pasien", "Alamat", "Gender [L/P]", "Tempat Tanggal Lahir", "NIK", "BPJS"};
        int y = 100;
        for (String val: data){
            JLabel label = new JLabel(val);
            label.setBounds(165, y, 200, 20);

            JTextField txt = new JTextField();
            txt.setBounds(160, y+20, 300, 30);

            y+=60;
            add(label);
            add(txt);
        }

        back.addActionListener(e -> event());
        add(back);

    }

    public void event(){
        HomePage homePage = new HomePage();
        this.setVisible(false);
        homePage.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new RegisPasien());
    }
}
