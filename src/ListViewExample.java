import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ListViewExample extends JFrame {
    private DefaultListModel<String> listModel;
    private JList<String> listView;

    public ListViewExample() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        setTitle("List View Example");

        listModel = new DefaultListModel<>();
        listView = new JList<>(listModel);

        JButton addButton = new JButton("Add Item");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addItem();
            }
        });

        JButton removeButton = new JButton("Remove Item");
        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removeItem();
            }
        });

        JPanel panel = new JPanel();
        panel.add(listView);
        panel.add(addButton);
        panel.add(removeButton);

        add(panel);
        setVisible(true);
    }

    private void addItem() {
        JPanel inputPanel = new JPanel();
        JTextField textField1 = new JTextField(10);
        JTextField textField2 = new JTextField(10);

        inputPanel.setLayout(new GridLayout(2, 2));
        inputPanel.add(new JLabel("Input 1:"));
        inputPanel.add(textField1);
        inputPanel.add(new JLabel("Input 2:"));
        inputPanel.add(textField2);

        int result = JOptionPane.showConfirmDialog(this, inputPanel, "Enter Two Items", JOptionPane.OK_CANCEL_OPTION);

        if (result == JOptionPane.OK_OPTION) {
            String input1 = textField1.getText().trim();
            String input2 = textField2.getText().trim();

            if (!input1.isEmpty() && !input2.isEmpty()) {
                listModel.addElement(input1 + " - " + input2);
            }
        }
    }

    private void removeItem() {
        int selectedIndex = listView.getSelectedIndex();
        if (selectedIndex != -1) {
            listModel.remove(selectedIndex);
        } else {
            JOptionPane.showMessageDialog(this, "Select an item to remove.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ListViewExample());
    }
}
