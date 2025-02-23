/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ModelMhs;

import java.util.List;
import javax.swing.table.AbstractTableModel;
/**
 *
 * @author FahmiAyyub
 */
public class tableModelMahasiswa  extends AbstractTableModel{
    
    List<mahasiswa> lb;

    public tableModelMahasiswa(List<mahasiswa> lb) {
        this.lb = lb;
    }

    @Override
    public int getColumnCount() {
        return 5;
    }


    public int getRowCount() {
        return lb.size();
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "ID";
            case 1:
                return "Nim";
            case 2:
                return "Nama";
            case 3:
                return "Kelamin";
            case 4:
                return "Alamat";
            default:
                return null;
        }
    }

    @Override
    public Object getValueAt(int row, int column) {
        switch (column) {
            case 0:
                return lb.get(row).getId();
            case 1:
                return lb.get(row).getNim();
            case 2:
                return lb.get(row).getNama();
            case 3:
                return lb.get(row).getJk();
            case 4:
                return lb.get(row).getAlamat();
            default:
                return null;
        }
    }
}
