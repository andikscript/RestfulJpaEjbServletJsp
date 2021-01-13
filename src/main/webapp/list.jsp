<%-- 
    Document   : list
    Created on : Dec 18, 2020, 8:12:48 PM
    Author     : akunf
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>List Page</title>
    </head>
    <body>
        <h1>List Siswa</h1>
        
        <table border="1">
            <tr>
                <td>NISN</td>
                <td>Nama Siswa</td>
                <td>Kelas</td>'
                <td colspan="2">Action</td>
            </tr>
            <c:forEach items="${allSiswa}" var="siswa">
                <tr>
                    <td>${siswa.nisn}</td>
                    <td>${siswa.nama}</td>
                    <td>${siswa.kelas}</td>
                    <td><a href="siswa?action=edit&nisn=${siswa.nisn}"/>Edit</td>
                    <td><a href="siswa?action=delete&nisn=${siswa.nisn}"/>Delete</td>
                </tr>
            </c:forEach>
        </table>
        <br/><a href="add.jsp"> Tambah Data </a>
    </body>
</html>
