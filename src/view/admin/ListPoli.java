package view.admin;

import controller.PoliController;
import node.Poli;

import javax.swing.*;

public class ListPoli extends JFrame {
    PoliController poliController;
    public ListPoli(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 600);
        setVisible(true);
        setLayout(null);

        poliController = new PoliController();
        setResizable(false);
        component();
    }

    public void component(){
        getContentPane().removeAll();
        JButton back = new JButton("Back");
        back.setBounds(30, 30, 90, 30);

        JLabel judul = new JLabel("List Poli");
        judul.setBounds(165, 90, 100, 20);

        JButton addPoli = new JButton("+");
        addPoli.setBounds(225, 90, 50, 25);

        int y=130;
        for (Poli poli: poliController.modelPoli.polis){
            JLabel label = new JLabel(poli.namaPoli);
            label.setBounds(165, y, 100, 20);

            JButton edit = new JButton("edit");
            edit.setBounds(265, y, 70, 20);

            edit.addActionListener(e -> editPoli(poli.idPoli));

            JButton delete = new JButton("delete");
            delete.setBounds(355, y, 70, 20);

            delete.addActionListener(e -> deletePoli(poli.idPoli));

            y+=30;
            add(label);
            add(edit);
            add(delete);
        }


        back.addActionListener(e -> event());
        addPoli.addActionListener(e -> tambahPoli());

        add(back);
        add(judul);
        add(addPoli);
    }



    public void tambahPoli() {
        JTextField namaPoli = new JTextField();
        Object[] message = {"Masukkan Nama Poli:", namaPoli};

        int result = JOptionPane.showOptionDialog(
                null,
                message,
                "Tambah Poli",
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.PLAIN_MESSAGE,
                null,
                null,
                null);

        if (result == JOptionPane.OK_OPTION) {
            String nPoli = namaPoli.getText().trim();

            if (!nPoli.isEmpty()) {
                poliController.addPoli(nPoli);
                refresh();
                JOptionPane.showMessageDialog(null, "Poli "+nPoli+" berhasil ditambahkan!", "Sukses", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Nama Poli tidak boleh kosong cuy (emot marah)", "Peringatan", JOptionPane.WARNING_MESSAGE);
                tambahPoli();
            }
        }
    }

    public void editPoli(int id) {
//        System.out.println(id);
        Poli poli = poliController.searchPoli(id);
        JTextField namaPoli = new JTextField(poli.namaPoli);
        Object[] message = {"Edit Nama Poli:", namaPoli};

        int result = JOptionPane.showOptionDialog(
                null,
                message,
                "Edit Poli",
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.PLAIN_MESSAGE,
                null,
                null,
                null);

        if (result == JOptionPane.OK_OPTION) {
            String nPoli = namaPoli.getText().trim();

            if (!nPoli.isEmpty()) {
                poliController.editPoli(poli.idPoli, nPoli);
                refresh();
                JOptionPane.showMessageDialog(null, "Poli "+nPoli+" berhasil diedit!", "Sukses", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Nama Poli tidak boleh kosong cuy (emot marah)", "Peringatan", JOptionPane.WARNING_MESSAGE);
                editPoli(poli.idPoli);
            }
        }
    }

    public void deletePoli(int id){
        Poli poli = poliController.searchPoli(id);
        if (poli.queues.isEmpty() && poli.dokters.isEmpty()){
            int result = JOptionPane.showConfirmDialog(
                    null,
                    "Apakah Anda yakin ingin menghapus?",
                    "Konfirmasi",
                    JOptionPane.YES_NO_OPTION);

            if (result == JOptionPane.YES_OPTION) {
                poliController.deletePoli(id);
                refresh();
            }

        } else {
            JOptionPane.showMessageDialog(null, "Poli masih memiliki antrian / dokter", "Peringatan", JOptionPane.WARNING_MESSAGE);
        }
    }

    public void event(){
        HomeAdmin homeAdmin = new HomeAdmin();
        this.setVisible(false);
        homeAdmin.setVisible(true);
    }

    public void refresh(){
        this.dispose();
        ListPoli lispoli = new ListPoli();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(ListPoli::new);
    }

}
