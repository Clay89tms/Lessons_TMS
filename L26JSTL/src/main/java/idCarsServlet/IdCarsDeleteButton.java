package idCarsServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static idCarsServlet.IdCarsMap.deleteCarById;
import static idCarsServlet.IdCarsMap.takeAllCar;
import static idCarsServlet.IdCarsDataBase.deleteCarInDataBase;

@WebServlet("/idcarsDeleleButton")
public class IdCarsDeleteButton extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("takeAllCar", takeAllCar());
        resp.sendRedirect("idcarsList");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        deleteCarById(id);
        deleteCarInDataBase(id);
        doGet(req, resp);
    }
}
