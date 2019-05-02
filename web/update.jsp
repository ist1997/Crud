<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="nationality" value="${footballer.getNationality()}"/>
<html>
<head>
    <title>Update information about footballer</title>
</head>
<body>
<h1>Update information about footballer</h1>
<form action="update" method="post">
    <table>
        <tr>
            <td>Id:</td>
            <td><input type="text" readonly name="id" value="${footballer.getId()}"/></td>
        </tr>
        <tr>
            <td>Name:</td>
            <td><input type="text" name="name" value="${footballer.getName()}"/></td>
        </tr>
        <tr>
            <td>Team:</td>
            <td><input type="text" name="team" value="${footballer.getTeam()}"/></td>
        </tr>
        <tr>
            <td>Nationality:</td>
            <td>
                <select size="1" name="nationality">
                    <c:forEach var="country" items="${countries}">
                        <c:if test="${country.equals(nationality)}">
                            <option selected value="${country}">${country}</option>
                        </c:if>
                        <c:if test="${!country.equals(nationality)}">
                            <option value="${country}">${country}</option>
                        </c:if>
                    </c:forEach>
                </select>
            </td>
        </tr>
        <tr>
            <td>Price:</td>
            <td><input type="number" name="price" value="${footballer.getPrice()}"/></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" value="Save"/></td>
        </tr>
    </table>
</form>
<br/>
<form action="show_list.jsp">
    <input type="submit" value="Back to footballer list">
</form>
</body>
</html>
