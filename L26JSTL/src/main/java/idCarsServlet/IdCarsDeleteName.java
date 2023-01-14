package idCarsServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static idCarsServlet.IdCarsMap.deleteCarById;
import static idCarsServlet.IdCarsDataBase.deleteCarInDataBase;

@WebServlet("/idcarsDelele")
public class IdCarsDeleteName extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        deleteCarById(id);
        deleteCarInDataBase(id);
        req.getRequestDispatcher("Menu/idcarsAdd.jsp").forward(req, resp);
    }
}
