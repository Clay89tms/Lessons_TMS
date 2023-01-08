package idCarsServlet;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static idCarsServlet.IdCarsMap.carCreateSearch;
import static idCarsServlet.IdCarsMap.getMapCar;

@WebServlet("/idcarsList")
public class IdCarsList extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String, CarCreate> mapCar = getMapCar();
        if (mapCar != null){
//            List<String> list1 = new ArrayList<>();
//            list1.addAll(mapCar.keySet());
//            CarCreate carCreateS;
//            for (int i = 0; i < list1.size(); i++) {
//                String id = mapCar.get(list1.get(i)).getId();
//                carCreateS = mapCar.get(list1.get(i));
//                String carSearch = carCreateSearch(carCreateS);
//                req.setAttribute("carCreateSearch", carSearch);
//                out.print(
//                        "id = " + mapCar.get(list1.get(i)).getId() + ";  " +
//                                "type = " + mapCar.get(list1.get(i)).getType() + ";  " +
//                                "color = " + mapCar.get(list1.get(i)).getColor() + ";  " +
//                                "price = " + mapCar.get(list1.get(i)).getPrice() +
//                                "<form method='post' action='idcarsDeleleId'>" +
//                                "<input type='hidden' name='id' value='"+id+"'><input type=\"submit\" value=\"deleteCar\">" +
//                                "</form>");
//                out.println("<br>");
//            }
        }
        req.setAttribute("mapCar", mapCar);
        req.getRequestDispatcher("Menu/idcarsList.jsp").forward(req, resp);

    }
}
