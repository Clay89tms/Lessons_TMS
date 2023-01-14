<%@ page import="idCarsServlet.CarCreate" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: User
  Date: 30.12.2022
  Time: 18:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Add/Search Menu</title>
</head>
<body>
<p style="background-color:aquamarine">Menu Cars</p>
<hr>
Metod Add
<form method="post" action="idcarsAdd" style="width: 100px">
    <label>ID:
        <input type="text" name="id"><br>
    </label><br>
    <label>Type:
        <input type="text" name="type"><br>
    </label><br>
    <label>Color:
        <input type="text" name="color"><br>
    </label><br>
    <label>Pcice:
        <input type="text" name="price"><br>
    </label><br><br>
    <button type="submit">Add Car</button>
</form>
<hr>
<br>
Metod Delete
<form method="post" action="idcarsDelele">
    <input type="text" name="id">
    <button style="width: 150px">Delete</button>

</form>

<br>
<hr>
Metod Search
<br>
<form method="post" action="idcarsSearch">
    <input type="text" name="id">
    <button style="width: 150px">Search</button>
</form>
<br>

<c:if test="${id == true}">
    <c:out value="${carCreateSearch}"></c:out>
</c:if>

<br>
<br>
<button onclick="location.href='../start27.jsp'">Back to main</button>
</body>
</html>
