<%@ page import="java.util.Map" %>
<%@ page import="idCarsServlet.CarCreate" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: User
  Date: 30.12.2022
  Time: 18:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<p style="background-color:aquamarine">Menu Cars</p>

<c:if test="${mapCar == true}">
<c:forEach items="${allCarsList}" var="car">
<form method="post" action="idcarsDeleleId">
    <li>
        <input type="hidden" name="id" value="${car.id}">
    ${car.id}; ${car.type}; ${car.color}; ${car.price};
        <input type="submit" value="Delete"><br>
    </li>
</form>
</c:forEach>

</c:if>


<br>
<button onclick="location.href='../start27.jsp'">Back to main</button>

</body>
</html>
