import view.HomePage;

import javax.swing.*;

public class Main {
    public Main(){
        Runtime.getRuntime().addShutdownHook(new Thread(() -> System.out.println("\nShutting down. Saving data to JSON file...")));
    }
    public static void main(String[] args) {
        Main main = new Main();
        try {
            SwingUtilities.invokeLater(HomePage::new);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error Gagal Membuat GUI: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

    }
}
