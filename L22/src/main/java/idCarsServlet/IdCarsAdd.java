package idCarsServlet;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static idCarsServlet.IdCarsMap.*;

@WebServlet("/idcarsAdd")
public class IdCarsAdd extends HttpServlet {
    CarCreate carCreate;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("mapCar", getMapCar());
        req.getRequestDispatcher("Menu/idcarsAdd.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        String type = req.getParameter("type");
        String color = req.getParameter("color");
        String price = req.getParameter("price");
        carCreate = new CarCreate();

        carAddNew(id, type, color, price);
        setMapCar(id, carCreate);


        System.out.println("Add new Car: " + "id= " + id + "; type= " + type + "; color= " + color + "; price= " + price);
        resp.sendRedirect("/idcarsAdd");
    }

    private CarCreate carAddNew(String id, String type, String color, String price) {
        carCreate.setId(id);
        carCreate.setType(type);
        carCreate.setColor(color);
        carCreate.setPrice(price);
        return carCreate;
    }


}
