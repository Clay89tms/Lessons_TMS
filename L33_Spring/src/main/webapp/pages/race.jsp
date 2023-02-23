<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 22.02.2023
  Time: 22:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Race</title>
</head>
<body>
<h1> Race menu </h1>
<br/><hr/>

<%--<c:if test="${model == true}">--%>
Pairs:
<br/>

    <c:forEach items="${pairList}" var="pair">
        ${pair}<br/>
    </c:forEach>

<%--</c:if>--%>



</body>
</html>
