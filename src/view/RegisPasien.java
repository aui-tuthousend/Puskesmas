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
        String[] data = {"Nama Pasien", "Alamat", "Gender [L/P]", "Tempat Tanggal Lahir", "NIK", "BPJS"};
        int y = 100;
        for (int i =0; i<6; i++){
            JLabel label = new JLabel(data[i]);
            label.setBounds(160, y, 200, 20);

            JTextField txt = new JTextField();
            txt.setBounds(160, y+20, 300, 30);

            y+=60;
            add(label);
            add(txt);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new RegisPasien());
    }
}
