import view.HomePage;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        try {
            SwingUtilities.invokeLater(HomePage::new);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error Gagal Membuat GUI: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

    }
}
