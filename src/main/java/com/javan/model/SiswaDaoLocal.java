/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javan.model;

import com.javan.entity.Siswa;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author akunf
 */
@Local
public interface SiswaDaoLocal {

    void addSiswa(Siswa siswa);

    void editSiswa(Siswa siswa);

    void deleteSiswa(String nisn);

    Siswa getSiswa(String nisn);

    List<Siswa> getAll();
    
}
