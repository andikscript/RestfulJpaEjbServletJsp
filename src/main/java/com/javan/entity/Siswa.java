/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javan.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author akunf
 */
@Entity
@Table(name = "siswa")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Siswa.findAll", query = "SELECT s FROM Siswa s"),
    @NamedQuery(name = "Siswa.findByNisn", query = "SELECT s FROM Siswa s WHERE s.nisn = :nisn"),
    @NamedQuery(name = "Siswa.findByNama", query = "SELECT s FROM Siswa s WHERE s.nama = :nama"),
    @NamedQuery(name = "Siswa.findByKelas", query = "SELECT s FROM Siswa s WHERE s.kelas = :kelas")})
public class Siswa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "nisn")
    private String nisn;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nama")
    private String nama;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "kelas")
    private String kelas;

    public Siswa() {
    }

    public Siswa(String nisn) {
        this.nisn = nisn;
    }

    public Siswa(String nisn, String nama, String kelas) {
        this.nisn = nisn;
        this.nama = nama;
        this.kelas = kelas;
    }

    public String getNisn() {
        return nisn;
    }

    public void setNisn(String nisn) {
        this.nisn = nisn;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getKelas() {
        return kelas;
    }

    public void setKelas(String kelas) {
        this.kelas = kelas;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nisn != null ? nisn.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Siswa)) {
            return false;
        }
        Siswa other = (Siswa) object;
        if ((this.nisn == null && other.nisn != null) || (this.nisn != null && !this.nisn.equals(other.nisn))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.javan.entity.Siswa[ nisn=" + nisn + " ]";
    }
    
}
