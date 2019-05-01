<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add new footballer</title>
</head>
<body>
<form action="add" method="post">
    <table>
        <tr>
            <td>Name:</td>
            <td><input type="text" name="name"/></td>
        </tr>
        <tr>
            <td>Team:</td>
            <td><input type="text" name="team"/></td>
        </tr>
        <tr>
            <td>Nationality:</td>
            <td>
                <select size="1" required name="nationality">
                    <c:forEach var="country" items="${countries}">
                        <option value="${country}">${country}</option>
                    </c:forEach>
                </select>
            </td>
        </tr>
        <tr>
            <td>Price:</td>
            <td><input type="number" name="price"/></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" value="Add footballer"/></td>
        </tr>
    </table>
</form>
<br/>
<form action="index.jsp">
    <input type="submit" value="Back to footballer list">
</form>
</body>
</html>
