import javax.swing.*;

public class SetujuDialog {
    public static void main(String[] args) {
        showSetujuDialog();
    }

    public static void showSetujuDialog() {
        // Munculkan dialog dengan JTextArea untuk memasukkan "Setuju"
        JTextArea textArea = new JTextArea(5, 20);
        JScrollPane scrollPane = new JScrollPane(textArea);

        int result = JOptionPane.showOptionDialog(
                null,
                scrollPane,
                "Konfirmasi",
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.PLAIN_MESSAGE,
                null,
                null,
                null);

        if (result == JOptionPane.OK_OPTION) {
            String userInput = textArea.getText().trim();

            // Periksa apakah input setuju sesuai
            if ("Setuju".equals(userInput)) {
                JOptionPane.showMessageDialog(null, "Anda setuju. Lanjutkan registrasi.");
                // Lanjutkan dengan proses registrasi di sini
            } else {
                JOptionPane.showMessageDialog(null, "Input tidak sesuai. Registrasi dibatalkan.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Registrasi dibatalkan.");
        }
    }
}
