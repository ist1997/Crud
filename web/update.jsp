<%@ page import="model.Footballer" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Footballer footballer = (Footballer) request.getAttribute("footballer");
    String nationality = footballer.getNationality();
    List<String> countries = (List<String>) request.getAttribute("countries");
%>
<html>
<head>
    <title>Update information about footballer</title>
</head>
<body>
<h1>Update information about footballer</h1>
<form action="save" method="post">
    <table>
        <tr>
            <td>Id:</td>
            <td><input type="text" readonly name="id" value="<%=footballer.getId()%>"/></td>
        </tr>
        <tr>
            <td>Name:</td>
            <td><input type="text" name="name" value="<%=footballer.getName()%>"/></td>
        </tr>
        <tr>
            <td>Team:</td>
            <td><input type="text" name="team" value="<%=footballer.getTeam()%>"/></td>
        </tr>
        <tr>
            <td>Nationality:</td>
            <td>
                <select size="1" name="nationality">
                    <%for (String country : countries) {
                        if (country.equals(nationality)){%>
                    <option selected value="<%=country%>"><%=country%></option>
                    <%} else {%>
                    <option value="<%=country%>"><%=country%></option>
                    <%}%>
                    <%}%>
                </select>
            </td>
        </tr>
        <tr>
            <td>Price:</td>
            <td><input type="number" name="price" value="<%=footballer.getPrice()%>"/></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" value="Save"/></td>
        </tr>
    </table>
</form>
<br/>
<form action="index.jsp">
    <input type="submit" value="Back to footballer list">
</form>
</body>
</html>
