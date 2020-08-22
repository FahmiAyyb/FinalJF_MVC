/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ControllerMhs;

import DaoMhs.daoMahasiswa;
import DaoMhsImplement.implementMahasiswa;
import ModelMhs.mahasiswa;
import ModelMhs.tableModelMahasiswa;
import ViewMhs.FormMahasiswa;
import java.util.List;
import javax.swing.JOptionPane;
/**
 *
 * @author FahmiAyyub 
 */
public class controllerMahasiswa {
    
    FormMahasiswa frame;
    implementMahasiswa implMahasiswa;
    List<mahasiswa> lb;

    public controllerMahasiswa(FormMahasiswa frame) {
        this.frame = frame;
        implMahasiswa = new daoMahasiswa();
        lb = implMahasiswa.getALL();
    }

    //mengosongkan field
    public void reset() {
        frame.getTxtID().setText("");
        frame.getTxtNim().setText("");
        frame.getTxtNama().setText("");
        frame.getTxtJk().setSelectedItem("");
        frame.getTxtAlamat().setText("");
        
    }

    //menampilkan data ke dalam tabel
    public void isiTable() {
        lb = implMahasiswa.getALL();
        tableModelMahasiswa tmb = new tableModelMahasiswa(lb);
        frame.getTabelData().setModel(tmb);
    }

    //merupakan fungsi untuk menampilkan data yang dipilih dari tabel
    public void isiField(int row) {
        frame.getTxtID().setText(lb.get(row).getId().toString());
        frame.getTxtNim().setText(lb.get(row).getNim());
        frame.getTxtNama().setText(lb.get(row).getNama());
        frame.getTxtJk().setSelectedItem(lb.get(row).getJk());
        frame.getTxtAlamat().setText(lb.get(row).getAlamat());
    }

    //merupakan fungsi untuk insert data berdasarkan inputan user dari textfield di frame
    public void insert() {
        
      if (!frame.getTxtNim().getText().trim().isEmpty()& !frame.getTxtNama().getText().trim().isEmpty()) {
          
        mahasiswa b = new mahasiswa();
        b.setNim(frame.getTxtNim().getText());
        b.setNama(frame.getTxtNama().getText());
        b.setJk(frame.getTxtJk().getSelectedItem().toString());
        b.setAlamat(frame.getTxtAlamat().getText());

        implMahasiswa.insert(b);
        JOptionPane.showMessageDialog(null, "Simpan Data sukses");
        
        } else {
            JOptionPane.showMessageDialog(frame, "Data Tidak Boleh Kosong");
        }
    }

    //berfungsi untuk update data berdasarkan inputan user dari textfield di frame
    public void update() {
   if (!frame.getTxtID().getText().trim().isEmpty()) {
             
        mahasiswa b = new mahasiswa();
        b.setNim(frame.getTxtNim().getText());
        b.setNama(frame.getTxtNama().getText());
        b.setJk(frame.getTxtJk().getSelectedItem().toString());
        b.setAlamat(frame.getTxtAlamat().getText());
        b.setId(Integer.parseInt(frame.getTxtID().getText()));
        implMahasiswa.update(b);
        
        JOptionPane.showMessageDialog(null, "Update Data  sukses");
        } else {
            JOptionPane.showMessageDialog(frame, "Pilih data yang akan di ubah");
        }
    }

    //berfungsi menghapus data yang dipilih
    public void delete() {
        if (!frame.getTxtID().getText().trim().isEmpty()) {
            int id = Integer.parseInt(frame.getTxtID().getText());
            implMahasiswa.delete(id);
            
            JOptionPane.showMessageDialog(null, "Hapus Data  sukses");
        } else {
            JOptionPane.showMessageDialog(frame, "Pilih data yang akan di hapus");
        }
    }

    public void isiTableCariNama() {
        lb = implMahasiswa.getCariNama(frame.getTxtCariNama().getText());
        tableModelMahasiswa tmb = new tableModelMahasiswa(lb);
        frame.getTabelData().setModel(tmb);
    }

    public void carinama() {
        if (!frame.getTxtCariNama().getText().trim().isEmpty()) {
            implMahasiswa.getCariNama(frame.getTxtCariNama().getText());
            isiTableCariNama();
        } else {
            JOptionPane.showMessageDialog(frame, "SILAHKAN PILIH DATA");
        }
    }
}
