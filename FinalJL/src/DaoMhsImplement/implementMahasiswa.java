/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DaoMhsImplement;

import ModelMhs.mahasiswa;
import java.util.List;
/**
 *
 * @author FahmiAyyub
 */
public interface implementMahasiswa {
    
    public void insert(mahasiswa b);

    public void update(mahasiswa b);

    public void delete(int id);

    public List<mahasiswa> getALL();

    public List<mahasiswa> getCariNama(String nama);
}
