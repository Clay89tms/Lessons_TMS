package org.example;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

public class BookSrevlet extends HttpServlet {

    private static Map<String, String> books = new HashMap<>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("GET BOOK");
        req.setAttribute("attr", new UserNew("login"));

//        resp.sendRedirect("http://google.com");

        req.getRequestDispatcher("/car").forward(req, resp);

//        String head1 = req.getHeader("head1");
//        System.out.println(head1);
//        String id = req.getParameter("id");
//        resp.getOutputStream().print(books.get(id));

//        resp.addHeader("test", "test1");
//        resp.setStatus(200);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        ServletInputStream inputStream = req.getInputStream();
//        byte[] bytes = inputStream.readAllBytes();
//        var body = new String(bytes);
//        resp.getOutputStream().print(body);


//        String id = req.getParameter("id");
//        String title = req.getParameter("title");
//        books.put(id, title);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        books.remove(id);
    }

    /*
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String value = req.getParameter("param1");
        System.out.println(value);

        Map<String, String[]> parameterMap = req.getParameterMap();

        Enumeration<String> parameterNames = req.getParameterNames();
        while (parameterNames.hasMoreElements()) {
            String s = parameterNames.nextElement();
            System.out.println(s);
        }
        req.getRequestDispatcher("/book.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String value = req.getParameter("param1");
        System.out.println(value);

        Map<String, String[]> parameterMap = req.getParameterMap();

        Enumeration<String> parameterNames = req.getParameterNames();
        while (parameterNames.hasMoreElements()) {
            String s = parameterNames.nextElement();
            System.out.println(s);
        }
        req.getRequestDispatcher("/book.jsp").forward(req, resp);
    }
 */
}
