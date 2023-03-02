<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 21.02.2023
  Time: 19:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Menu</title>
</head>
<body>
<h1> Menu program. </h1>
<br/>


<c:if test="${money < 10}">
    !!!not enough money!!! Bye Bye! see you...
</c:if>
<c:if test="${money > 9}">

    <form action="/circle/add" method="post">
        <input type="text" name="nameHorse"> Horse name | ${err_nameHorse}<br/>
        <input type="text" name="nameRider"> Rider name | ${err_nameRider}<br/>
        <input type="submit" value="saved">
    </form>
    <br/>

    <br/>
    <hr>
    Your money: ${money} |
    <c:if test="${isThereAWinner == true}">
        ${endOfRaceMessage}
    </c:if>
    <br/>
    <hr/>

    <c:if test="${pairList != null}">
        <c:if test="${pairSize > 1}">

            <form action="/circle/toStart" method="post">
            Place your BET (10-30): <input type="text" name="bet">
            <input type="submit" value="go Race"> | ${err_bet}
            <hr/>
        </c:if>

        <c:forEach items="${pairList}" var="pair" varStatus="ien">
            ${ien.index + 1} ${pair} <input type="radio" name="choose" value="${ien.index + 1}"> | ${err_choose}
            <br/>
        </c:forEach>
        <hr/>
        </form>
    </c:if>

</c:if>
</body>
</html>
