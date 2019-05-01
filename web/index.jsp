<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="dao.FootballerDao" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="footballers" value="${FootballerDao.getAllFootballers()}"/>
<html>
<head>
    <title>TransferMarket</title>
</head>
<body>
<form action='getData' method="post">
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
    <c:forEach var="footballer" items="${footballers}">
        <tr>
            <td>${footballer.getId()}</td>
            <td>${footballer.getName()}</td>
            <td>${footballer.getTeam()}</td>
            <td>${footballer.getNationality()}</td>
            <td>${footballer.getPrice()} m</td>
            <td><a href='update?id=${footballer.getId()}'>update</a></td>
            <td><a href='delete?id=${footballer.getId()}'>delete</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
