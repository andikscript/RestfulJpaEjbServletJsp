<%-- 
    Document   : add
    Created on : Dec 23, 2020, 10:23:33 PM
    Author     : akunf
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP ADD</title>
    </head>
    <body>
        <h1>ADD Record</h1>
        <form action="siswa" method="post">
            <label for="nim">NISN</label>
            <input type="text" name="nisn"><br/>
            <label for="nama">Nama</label>
            <input type="text" name="nama"><br/>
            <label for="prodi">Kelas</label>
            <input type="text" name="kelas"><br/>
            <input type="hidden" name="action" value="add"><br/>
            <input type="submit"><br/>
        </form>
    </body>
</html>
