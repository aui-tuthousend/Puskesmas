package view.admin.CRUDdokter;

import controller.DokterController;
import controller.PoliController;
import model.ModelPoli;
import node.Dokter;
import node.Poli;
import view.admin.ListDokter;

import javax.swing.*;

public class EditDokter extends JFrame {
    private DefaultListModel<String> listModel;
    private JList<String> listView;
    private JTextField textField;
    PoliController poliController;
    DokterController dokterController;
    int idPoli;
    int idDokter;

    public EditDokter(int idDok, int idPol){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 400);
        setTitle("Tambah Dokter");

        listModel = new DefaultListModel<>();
        listView = new JList<>(listModel);
        textField = new JTextField();
        poliController = new PoliController();
        idDokter = idDok;
        idPoli= idPol;

        setLayout(null);
        setResizable(false);
        dokterController = new DokterController();
        component();
        setVisible(true);
    }

    private void component(){
        JLabel label = new JLabel("Nama Dokter");
        label.setBounds(20, 10, 100, 20);

        Dokter dokter = dokterController.searchDokter(idDokter);
        textField.setText(dokter.namaDokter);
        textField.setBounds(20,30, 150, 20);

        JLabel pilih = new JLabel("Pilih Poli");
        pilih.setBounds(20, 60, 100, 20);

        listView.setBounds(20, 80, 150, 100);
        for (Poli poli: poliController.modelPoli.polis){
            listModel.addElement(poli.namaPoli);
        }
        listView.setSelectedIndex(idPoli);

        JButton submit = new JButton("Submit");
        submit.setBounds(20, 200, 80, 20);

        JButton cancel = new JButton("Cancel");
        cancel.setBounds(105, 200, 80, 20);

        submit.addActionListener(e -> edit());
        cancel.addActionListener(e -> back());

        add(label);
        add(pilih);
        add(textField);
        add(listView);
        add(submit);
        add(cancel);
    }

    public void edit(){
        int idx = listView.getSelectedIndex();
        if (!textField.getText().isEmpty()){
            if (idx != -1) {
                dokterController.editDokter(idDokter, textField.getText(), idx);
                int id = dokterController.modelDokter.getLastCode();
                System.out.println(id);
                poliController.addDoctor(idx, dokterController.modelDokter.dokters.get(id));
                JOptionPane.showMessageDialog(this, "Dokter Berhasil Diedit!", "Sukses", JOptionPane.INFORMATION_MESSAGE);
                back();
            } else {
                JOptionPane.showMessageDialog(this, "Pilih Poli nya banh", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Nama DOkternya banh", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void back(){
        ListDokter listDokter = new ListDokter();
        this.dispose();
        listDokter.setVisible(true);
    }

//    public static void main(String[] args) {
//        SwingUtilities.invokeLater(TambahDokter::new);
//    }
}
