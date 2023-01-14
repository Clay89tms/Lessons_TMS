package idCarsServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static idCarsServlet.IdCarsDataBase.updateCarInDataBase;
import static idCarsServlet.IdCarsMap.putNewCar;

@WebServlet("/idcarsUpdate")
public class IdCarsUpdate extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("idcarsList");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        String type = req.getParameter("type");
        String color = req.getParameter("color");
        String price = req.getParameter("price");

        CarCreate carCreate = new CarCreate(id, type, color, price);
        putNewCar(id, carCreate);
        updateCarInDataBase(id,type,color,price);

        System.out.println("update a Car: " + "id= " + id + "; type= " + type + "; color= " + color + "; price= " + price);
        doGet(req, resp);
    }
}
