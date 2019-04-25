<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
            <td><input type="text" readonly="readonly" name="id" value="<%=request.getAttribute("id")%>"/></td>
        </tr>
        <tr>
            <td>Name:</td>
            <td><input type="text" name="name" value="<%=request.getAttribute("name")%>"/></td>
        </tr>
        <tr>
            <td>Team:</td>
            <td><input type="text" name="team" value="<%=request.getAttribute("team")%>"/></td>
        </tr>
        <tr>
            <td>Nationality:</td>
            <td><input type="text" name="nationality" value="<%=request.getAttribute("nationality")%>"/></td>
        </tr>
        <tr>
            <td>Price:</td>
            <td><input type="number" name="price" value="<%=request.getAttribute("price")%>"/></td>
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
