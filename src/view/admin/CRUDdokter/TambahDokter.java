package view.admin.CRUDdokter;

import controller.DokterController;
import controller.PoliController;
import model.ModelPoli;
import node.Poli;
import view.admin.ListDokter;

import javax.swing.*;

public class TambahDokter extends JFrame {
    private DefaultListModel<String> listModel;
    private JList<String> listView;
    private JTextField textField;
    PoliController poliController;
    DokterController dokterController;

    public TambahDokter(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 400);
        setTitle("Tambah Dokter");

        listModel = new DefaultListModel<>();
        listView = new JList<>(listModel);
        textField = new JTextField();
        poliController = new PoliController();

        setLayout(null);
        setResizable(false);
        dokterController = new DokterController();
        component();
        setVisible(true);
    }

    private void component(){
        JLabel label = new JLabel("Nama Dokter");
        label.setBounds(20, 10, 100, 20);

        textField.setBounds(20,30, 150, 20);

        JLabel pilih = new JLabel("Pilih Poli");
        pilih.setBounds(20, 60, 100, 20);

        listView.setBounds(20, 80, 150, 100);
        for (Poli poli: poliController.modelPoli.polis){
            listModel.addElement(poli.namaPoli);
        }

        JButton submit = new JButton("Submit");
        submit.setBounds(20, 200, 80, 20);

        submit.addActionListener(e -> tambahDokter());

        add(label);
        add(pilih);
        add(textField);
        add(listView);
        add(submit);
    }

    public void tambahDokter(){
        int idx = listView.getSelectedIndex();
        if (idx != -1) {
            String namaPoli = listModel.getElementAt(idx);
            dokterController.addDokter(textField.getText(), namaPoli);
            int id = dokterController.modelDokter.getLastCode();
            System.out.println(id);
            poliController.addDoctor(idx, dokterController.modelDokter.dokters.get(id));
        } else {
            JOptionPane.showMessageDialog(this, "Pilih Poli nya banh", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(TambahDokter::new);
    }
}
