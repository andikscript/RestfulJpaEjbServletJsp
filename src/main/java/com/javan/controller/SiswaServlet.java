/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javan.controller;

import com.javan.model.SiswaDaoLocal;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.javan.entity.Siswa;

/**
 *
 * @author akunf
 */
@WebServlet(name = "SiswaServlet", urlPatterns = {"/siswa"})
public class SiswaServlet extends HttpServlet {
    
    @EJB
    private SiswaDaoLocal siswaDao;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String action = request.getParameter("action");
        
        if (action == null || action == "") {
            action = "";
        }
        
        if (action.equalsIgnoreCase("edit")) {
            String nisn = request.getParameter("nisn");
            request.setAttribute("nisn", nisn);
            request.getRequestDispatcher("edit.jsp").forward(request, response);
        } else if (action.equalsIgnoreCase("add")) {
            request.getRequestDispatcher("add.jsp").forward(request, response);
        } else if (action.equalsIgnoreCase("delete")) {
            String nisn = (String) request.getParameter("nisn");
            request.setAttribute("nisn", nisn);
            request.getRequestDispatcher("konfirmasi.jsp").forward(request, response);
        } else if (action.equalsIgnoreCase("konfirmasi")) {
            String nisn = request.getParameter("nisn");
            siswaDao.deleteSiswa(nisn);
            request.getRequestDispatcher("success.jsp").forward(request, response);
        } else {
            request.setAttribute("allSiswa", siswaDao.getAll());
            request.getRequestDispatcher("list.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action.equalsIgnoreCase("add")) {
            String nisn = request.getParameter("nisn");
            String nama = request.getParameter("nama");
            String kelas = request.getParameter("kelas");
            Siswa s = new Siswa(nisn, nama, kelas);
            siswaDao.addSiswa(s);
        } else if (action.equalsIgnoreCase("edit")) {
            String nisn = request.getParameter("n");
            String nama = request.getParameter("nama");
            String kelas = request.getParameter("kelas");
            Siswa s = new Siswa(nisn, nama, kelas);
            System.out.println(nisn);
            siswaDao.editSiswa(s);
        }
        response.sendRedirect("siswa");
    }
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
