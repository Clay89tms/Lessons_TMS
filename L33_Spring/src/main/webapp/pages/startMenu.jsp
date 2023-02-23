<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 21.02.2023
  Time: 19:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Menu</title>
</head>
<body>
<h1> Menu program. </h1>
<br/>

Hello
<%--${pair1}--%>

<form action="/circle/add" method="post">
    <input type="text" name="nameHorse"> Horse name | ${err_nameHorse}<br/>
    <input type="text" name="nameRider"> Rider name | ${err_nameRider}<br/>
    <input type="submit" value="saved">
</form>
<br/>
<br/>
<hr/>
<form action="/circle/toStart" method="get">
    <input type="submit" value="go Race">
</form>
<hr/>


<%--${pairList.horse.nameHorse}--%>
<c:if test="${list}">
    new pairList
</c:if>

<br/><hr>
${money}
<br/>
${moneyA}
<br/>
<c:if test="${pairList != null}">

<c:forEach items="${pairList}" var="pair" varStatus="ien">
    ${ien.index + 1} ${pair}<br/>
</c:forEach>

</c:if>


</body>
</html>
