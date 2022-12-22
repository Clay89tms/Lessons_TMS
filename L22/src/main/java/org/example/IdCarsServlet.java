package org.example;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

public class IdCarsServlet extends HttpServlet {

    private static Map<String, CarCreate> map = new HashMap<>();
    private static CarCreate car;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String id = req.getParameter("id");
        if (id != null) {
            resp.getOutputStream().print(
                    "id = " + map.get(id).getId() +
                            "\ntype = " + map.get(id).getType() +
                            "\ncolor = " + map.get(id).getColor() +
                            "\nprice = " + map.get(id).getPrice()
            );
        }

        if ((id == null) && (!map.isEmpty())) {
            List<String> list = new ArrayList<>();
            list.addAll(map.keySet());
            for (int i = 0; i < list.size(); i++) {
                resp.getOutputStream().println(list.get(i) +
                        "\t" + map.get(list.get(i)).getType() +
                        "\t" + map.get(list.get(i)).getColor() +
                        "\t" + map.get(list.get(i)).getPrice());
                System.out.println(carToString(map, list, i));
            }
        }
    }

    private String carToString(Map<String, CarCreate> map, List<String> list, int i) {
        return "[id = " + map.get(list.get(i)).getId() + "\t" +
                    ", type = " + map.get(list.get(i)).getType() + "\t" +
                    ", color = " + map.get(list.get(i)).getColor() + "\t" +
                    ", price = " + map.get(list.get(i)).getPrice() + "]";
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        String type = req.getParameter("type");
        String color = req.getParameter("color");
        String price = req.getParameter("price");
        car = new CarCreate();
        carSetData(id, type, color, price);

        Enumeration<String> parameterNames = req.getParameterNames();
        while (parameterNames.hasMoreElements()) {
            String key = parameterNames.nextElement();
            String value = req.getParameter(key);
            System.out.println(key + " " + value);
        }
    }


    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        String type = req.getParameter("type");
        String color = req.getParameter("color");
        String price = req.getParameter("price");
        carSetData(id, type, color, price);

        if ((id != null) && (!map.isEmpty())) {
            List<String> list1 = new ArrayList<>();
            list1.addAll(map.keySet());
            for (int i = 0; i < list1.size(); i++) {
                if (list1.get(i).equals(id)) {
                    map.put(id, car);
                }
            }
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        if ((id != null) && (!map.isEmpty())) {
            List<String> list2 = new ArrayList<>();
            list2.addAll(map.keySet());
            for (int i = 0; i < list2.size(); i++) {
                if (list2.get(i).equals(id)) {
                    map.remove(id);
                }
            }
        }
    }

    private Map carSetData(String id, String type, String color, String price) {
        car.setId(id);
        car.setType(type);
        car.setColor(color);
        car.setPrice(price);
        map.put(id, car);
        return map;
    }
}
