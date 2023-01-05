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
                String id = mapCar.get(list1.get(i)).getId();
            out.print(
                    "id = " + mapCar.get(list1.get(i)).getId() + ";  " +
                            "type = " + mapCar.get(list1.get(i)).getType() + ";  " +
                            "color = " + mapCar.get(list1.get(i)).getColor() + ";  " +
                            "price = " + mapCar.get(list1.get(i)).getPrice() +
                            "<form method='post' action='idcarsDeleleId'>" +
                            "<input type='hidden' name='id' value='"+id+"'><input type=\"submit\" value=\"deleteCar\">" +
                            "</form>");
            out.println("<br>");
        }
    }
%>
<%--<input type="submit" value="deleteCar">--%>
<%--<input type="hidden" name="id" value="${mapCar.get(list1.get(i)).getId()}">--%>
<br>
<button onclick="location.href='../start.jsp'">Back to main</button>

</body>
</html>
