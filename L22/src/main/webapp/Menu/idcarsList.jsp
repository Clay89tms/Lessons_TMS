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
<html>
<head>
    <title>Title</title>
</head>
<body>

<p style="background-color:aquamarine">Menu Cars</p>

<%

    if (request.getAttribute("mapCar") != null) {
        Map<String, CarCreate> mapCar = (Map<String, CarCreate>) request.getAttribute("mapCar");
        List<String> list1 = new ArrayList<>();
        list1.addAll(mapCar.keySet());
        for (int i = 0; i < list1.size(); i++) {
            out.println(
                    "id = " + mapCar.get(list1.get(i)).getId() + ";\t" +
                            "type = " + mapCar.get(list1.get(i)).getType() + ";\t" +
                            "color = " + mapCar.get(list1.get(i)).getColor() + ";\t" +
                            "price = " + mapCar.get(list1.get(i)).getPrice() + "<br>");
        }
        out.println("<br><a href=\"../start.jsp\">Back menu</a><br>");
    }
%>
    <button onclick="location.href='../index.html'">Back to main</button>

</body>
</html>
