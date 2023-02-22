<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 21.02.2023
  Time: 19:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Menu</title>
</head>
<body>
<h1> Menu program. </h1>
<br/>

Hello
${pair1}

<form action="/circle" method="post">
    <input type="text" name="nameHorse"> Horse<br/>
    <input type="text" name="nameRider"> Rider<br/>
    <input type="submit" value="saved">
</form>
<br/>
<br/>
<hr/>
${pairs0}
${pairs1}

<c:if test="${model == true}">
    test1
</c:if>

<c:if test="${map == true}">
asd
    <c:forEach items="pairList" var="pair">
        ${pair.horse} <br/>
    </c:forEach>

</c:if>


</body>
</html>
