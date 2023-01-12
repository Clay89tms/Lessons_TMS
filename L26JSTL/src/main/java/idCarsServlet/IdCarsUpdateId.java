package idCarsServlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static idCarsServlet.IdCarsMap.getMapCar;

@WebServlet("/idcarsUpdate")
public class IdCarsUpdateId extends HttpServlet {
    @Override
    public void init(ServletConfig config) throws ServletException {
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = getConnection();

            getConnection().createStatement().execute("drop table if exists cars");
            getConnection().createStatement().execute("" +
                    " create table cars (" +
                    " id int primary key, " +
                    " type varchar (50)," +
                    " color varchar (50)," +
                    " price varchar (50)" +
                    ")");
            getConnection().createStatement().close();

        } catch (Exception exc) {
            System.out.println(exc);
            throw new RuntimeException();
        }
    }

    public static Connection getConnection() {


        try {
            return DriverManager.getConnection("jdbc:postgresql://localhost:5432/cars", "postgres", "sagarA1");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void addCarFromDataBase (String id, String type, String color, String price){
        try {
            getConnection().createStatement().execute("" +
                    " insert into cars (id, type, color, price) " +
                    "values (" + id + ", \'" + type + "\', \'" + color + "\', \'" + price + "\'" +
                    ")"
            );
        } catch (SQLException e) {
            System.out.println(e);
            throw new RuntimeException(e);
        }
    }

    public static void deleteCarFromDataBase (String id){
        try {
            getConnection().createStatement().execute("" +
                    " delete from cars where id=" + id
            );
        } catch (SQLException e) {
            System.out.println(e);
            throw new RuntimeException(e);
        }
    }
}
