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

import static idCarsServlet.IdCarsMap.takeAllCar;

@WebServlet("/idcarsList")
public class IdCarsList extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String, CarCreate> takeAllCar = takeAllCar();
        if ((takeAllCar.size() != 0) && (takeAllCar != null)) {
            req.setAttribute("takeAllCar", true);

            List<String> list1 = new ArrayList<>();
            list1.addAll(takeAllCar.keySet());
            List<CarCreate> allCarsList = new ArrayList<>();
            for (int i = 0; i < list1.size(); i++) {
                allCarsList.add(takeAllCar.get(list1.get(i)));
            }
            req.setAttribute("allCarsList", allCarsList);
        }
        req.getRequestDispatcher("Menu/idcarsList.jsp").forward(req, resp);
    }
}
