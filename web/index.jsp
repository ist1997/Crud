<%@ page import="dao.FootballerDao" %>
<%@ page import="model.Footballer" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>TransferMarket</title>
</head>
<body>
<form action='add.jsp'>
    <input type='submit' value='Add new footballer'>
</form>
<h1>Footballer List</h1>
<table border='1' width='100%'>
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Team</th>
        <th>Nationality</th>
        <th>Price</th>
        <th>Update</th>
        <th>Delete</th>
    </tr>
    <%
        for (Footballer footballer : FootballerDao.getAllFootballers()) {
            out.print("<tr><td>" +
                    footballer.getId() + "</td><td>" +
                    footballer.getName() + "</td><td>" +
                    footballer.getTeam() + "</td><td>" +
                    footballer.getNationality() + "</td><td>$" +
                    footballer.getPrice() + " m</td><td>" +
                    "<a href='update?id=" + footballer.getId() + "'>update</a></td><td>" +
                    "<a href='delete?id=" + footballer.getId() + "'>delete</a></td></tr>");
        }
    %>
</table>
</body>
</html>
