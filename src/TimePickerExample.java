import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimePickerExample extends JFrame {
    private JSpinner timeSpinner;

    public TimePickerExample() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        setLocationRelativeTo(null);

        timeSpinner = new JSpinner(new SpinnerDateModel());
        JSpinner.DateEditor timeEditor = new JSpinner.DateEditor(timeSpinner, "HH:mm:ss");
        timeSpinner.setEditor(timeEditor);

        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(e -> onSubmitButtonClicked());

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 2));
        panel.add(new JLabel("Select Time:"));
        panel.add(timeSpinner);
        panel.add(submitButton);

        add(panel);
    }

    private void onSubmitButtonClicked() {
        // Mendapatkan nilai dari JSpinner (Date)
        Date selectedTime = (Date) timeSpinner.getValue();

        // Mengubah nilai Date ke dalam bentuk string
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        String formattedTime = sdf.format(selectedTime);

        // Menampilkan nilai dalam bentuk string
        System.out.println("Selected Time: " + formattedTime);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TimePickerExample().setVisible(true));
    }
}
