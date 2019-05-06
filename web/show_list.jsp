<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="dao.FootballerDao" %>
<%@ page import="dao.UserDao" %>
<%@ page import="model.Role" %>
<c:set var="footballers" value="${FootballerDao.getAllFootballers()}"/>
<html>
<head>
    <title>Footballer list</title>
</head>
<body>
<div style="text-align: center;">
    <c:out value="You entered as ${user.getLogin()} (${UserDao.getUserRole(user)})"/><br>
    <c:if test="${user.getRole()==Role.ADMIN}">
        <form action='addOrUpdate' method="post">
            <input type='submit' value='Add new footballer'>
        </form>
    </c:if>
    <h1>Footballer List</h1>
</div>
<table border='1' width='100%'>
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Team</th>
        <th>Nationality</th>
        <th>Price</th>
        <c:if test="${user.getRole()==Role.ADMIN}">
            <th>Update</th>
            <th>Delete</th>
        </c:if>
    </tr>
    <c:forEach var="footballer" items="${footballers}">
        <tr>
            <td>${footballer.getId()}</td>
            <td>${footballer.getName()}</td>
            <td>${footballer.getTeam()}</td>
            <td>${footballer.getNationality()}</td>
            <td>${footballer.getPrice()} m</td>
            <c:if test="${user.getRole()==Role.ADMIN}">
                <td><a href='addOrUpdate?id=${footballer.getId()}'>update</a></td>
                <td><a href='delete?id=${footballer.getId()}'>delete</a></td>
            </c:if>
        </tr>
    </c:forEach>
</table>
</body>
</html>
