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
<a href="../start.jsp">Back</a>
<br>
<hr>
<hr>
Metod Search

<%

    if (!request.getAttribute("mapCar").equals(null)) {
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


</body>
</html>
