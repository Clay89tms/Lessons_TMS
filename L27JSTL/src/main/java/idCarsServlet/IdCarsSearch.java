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

@WebServlet("/idcarsSearch")
public class IdCarsSearch extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        if (id != null) {
            req.setAttribute("id", true);
            Map<String, CarCreate> mapCar = getMapCar();
            List<String> list1 = new ArrayList<>();
            list1.addAll(mapCar.keySet());
            CarCreate carCreateS;
            for (int i = 0; i < list1.size(); i++) {
                if (id.equals(list1.get(i))) {
                    carCreateS = mapCar.get(list1.get(i));
                    String carSearch = carCreateSearch(carCreateS);
                    req.setAttribute("carCreateSearch", carSearch);
                }
            }
        }

        req.getRequestDispatcher("Menu/idcarsAdd.jsp").forward(req, resp);
    }


}
