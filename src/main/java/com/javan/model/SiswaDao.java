/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javan.model;

import com.javan.entity.Siswa;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

/**
 *
 * @author akunf
 */
@Stateless
public class SiswaDao implements SiswaDaoLocal {
    
    private EntityManager em;
    
    public SiswaDao() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("my_persistence");
        em = emf.createEntityManager();
    }

    @Override
    public void addSiswa(Siswa siswa) {
        em.getTransaction().begin();
        em.persist(siswa);
        em.getTransaction().commit();
    }

    @Override
    public void editSiswa(Siswa siswa) {
        em.getTransaction().begin();
        em.merge(siswa);
        em.getTransaction().commit();
    }

    @Override
    public void deleteSiswa(String nisn) {
        em.getTransaction().begin();
        em.remove(em.find(Siswa.class, nisn));
        em.getTransaction().commit();
    }

    @Override
    public Siswa getSiswa(String nisn) {
        return em.find(Siswa.class, nisn);
    }

    @Override
    public List<Siswa> getAll() {
        return em.createNamedQuery("Siswa.findAll", Siswa.class).getResultList();
    }
}
