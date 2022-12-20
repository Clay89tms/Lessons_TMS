package org.example;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.*;

public class IdCarsServlet extends HttpServlet {

    private static Map<String, String> map = new HashMap<>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String id = req.getParameter("id");
        if (id != null) {
            resp.getOutputStream().print(map.get(id));
        }

        if ((id == null) && (!map.isEmpty())) {
            List<String> list = new ArrayList<>();
            list.addAll(map.keySet());
            for (int i = 0; i < list.size(); i++) {
                resp.getOutputStream().println(list.get(i) + "\t " + map.get(list.get(i)));
            }
            System.out.println(map);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        String name = req.getParameter("name");
        map.put(id, name);
//        map = req.getParameterMap();


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
        String name = req.getParameter("name");
        if ((id != null) && (!map.isEmpty())) {
            List<String> list1 = new ArrayList<>();
            list1.addAll(map.keySet());
            for (int i = 0; i < list1.size(); i++) {
                if (list1.get(i).equals(id)){
                    map.put(id, name);
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
                if (list2.get(i).equals(id)){
                    map.remove(id);
                }
            }
        }
    }
}
