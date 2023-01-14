package idCarsServlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@WebServlet(value = "/init", loadOnStartup = 1)
public class IdCarsDataBase extends HttpServlet {
    @Override
    public void init(ServletConfig config) throws ServletException {
        try {
            Class.forName("org.postgresql.Driver");

            getConnection().createStatement().execute("drop table if exists cars");
            getConnection().createStatement().execute
                    ("" +
                            " create table cars (" +
                            " id int primary key, " +
                            " type varchar (50)," +
                            " color varchar (50)," +
                            " price varchar (50)" +
                            ")"
                    );
            getConnection().close();

        } catch (Exception exc) {
            System.out.println(exc);
            throw new RuntimeException();
        }
    }

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection("jdbc:postgresql://localhost:5432/cars", "postgres", "postgres");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void addCarInDataBase(String id, String type, String color, String price) {
        try {
            getConnection().createStatement().execute
                    ("" +
                            " insert into cars (id, type, color, price) " +
                            " values (" + id + ", \'" + type + "\', \'" + color + "\', \'" + price + "\'" +
                            ")"
                    );

            getConnection().close();
        } catch (SQLException e) {
            System.out.println(e);
            throw new RuntimeException(e);
        }
    }

    public static void updateCarInDataBase(String id, String type, String color, String price){
        try {
            getConnection().createStatement().execute
                    ("" +
                            " update cars " +
                            "set type=\'" + type + "\'," +
                            " color=\'" + color + "\' ," +
                            " price=\'" + price + "\' " +
                            "where id=\'" + id+"\'"
                    );

            getConnection().close();
        } catch (SQLException e) {
            System.out.println(e);
            throw new RuntimeException(e);
        }
    }

    public static void deleteCarInDataBase(String id) {
        try {
            getConnection().createStatement().execute("" +
                    " delete from cars where id=" + id
            );

            getConnection().close();
        } catch (SQLException e) {
            System.out.println(e);
            throw new RuntimeException(e);
        }
    }
}
