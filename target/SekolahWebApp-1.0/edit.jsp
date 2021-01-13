<%-- 
    Document   : edit
    Created on : Dec 23, 2020, 10:30:05 PM
    Author     : akunf
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Edit</title>
    </head>
    <body>
        <h1>Edit Record</h1>
        <form action="siswa" method="post">
            <label for="nisn">NISN</label>
            <input type="text" name="nisn" value="${nisn}" disabled="yes"><br/>
            <label for="nama">Nama</label>
            <input type="text" name="nama"><br/>
            <label for="kelas">Kelas</label>
            <input type="text" name="kelas"><br/>
            <input type="hidden" name="action" value="edit"><br/>
            <input type="hidden" name="n" value="${nisn}"><br/>
            <input type="submit"><br/>
        </form>
    </body>
</html>
