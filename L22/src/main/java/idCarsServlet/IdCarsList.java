package idCarsServlet;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

import static idCarsServlet.IdCarsMap.*;

@WebServlet("/idcarsList")
public class IdCarsList extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String, CarCreate> mapCar = getMapCar();
        req.setAttribute("mapCar", mapCar);
        req.getRequestDispatcher("Menu/idcarsList.jsp").forward(req, resp);

    }
}
