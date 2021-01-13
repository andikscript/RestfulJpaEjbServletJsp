/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javan.sekolahwebapp.resources;

import com.javan.entity.Siswa;
import com.javan.model.SiswaDaoLocal;
import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author akunf
 */
@Path("SiswaService")
public class SiswaServices {
    
    @EJB
    private SiswaDaoLocal siswaDao;
    
    @GET
    @Path("/siswa")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Siswa> getAll() {
        return siswaDao.getAll();
    }
    
    @GET
    @Path("/siswa/{nisn}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Siswa getSiswa(@PathParam ("nisn") String nisn){
        return siswaDao.getSiswa(nisn);
    }
    
    @POST
    @Path("/siswa")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Siswa addSiswa(@FormParam ("nisn") String nisn, @FormParam ("nama") String nama, @FormParam ("kelas") String kelas) {
        Siswa s = new Siswa(nisn, nama, kelas);
        siswaDao.addSiswa(s);
        return s;
    }
    
    @PUT
    @Path("/siswa")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Siswa editSiswa(@FormParam ("nisn") String nisn, @FormParam ("nama") String nama, @FormParam ("kelas") String kelas) {
        Siswa s = new Siswa(nisn, nama, kelas);
        siswaDao.editSiswa(s);
        return s;
    }
    
    @DELETE
    @Path("/siswa/{nisn}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Siswa deleteSiswa(@PathParam ("nisn") String nisn) {
        Siswa s = siswaDao.getSiswa(nisn);
        siswaDao.deleteSiswa(nisn);
        return s;
    }
}
