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

import static idCarsServlet.IdCarsMap.getCarCreateList;
import static idCarsServlet.IdCarsMap.getMapCar;

@WebServlet("/idcarsList")
public class IdCarsList extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String, CarCreate> mapCar = getMapCar();
        if ((mapCar.size() != 0) && (mapCar != null)) {
            req.setAttribute("mapCar", true);

            List<String> list1 = new ArrayList<>();
            list1.addAll(mapCar.keySet());
            List<CarCreate> allCarsList = new ArrayList<>();
            for (int i = 0; i < list1.size(); i++) {
                allCarsList.add(mapCar.get(list1.get(i)));
            }
            req.setAttribute("allCarsList", allCarsList);
        }
        req.getRequestDispatcher("Menu/idcarsList.jsp").forward(req, resp);
    }
}
