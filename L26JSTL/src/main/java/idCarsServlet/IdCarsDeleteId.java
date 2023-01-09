package idCarsServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static idCarsServlet.IdCarsMap.deleteCarMap;
import static idCarsServlet.IdCarsMap.getMapCar;

@WebServlet("/idcarsDeleleId")
public class IdCarsDeleteId extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("mapCar", getMapCar());
        resp.sendRedirect("idcarsList");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        deleteCarMap(id);
        doGet(req, resp);
    }
}
