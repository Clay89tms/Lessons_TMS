package idCarsServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static idCarsServlet.IdCarsMap.*;
@WebServlet("/idcarsDelele")
public class IdCarsDelete extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        deleteCarMap(id);
        req.getRequestDispatcher("Menu/idcarsAdd.jsp").forward(req, resp);
    }
}
