package org.example;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

@WebFilter("/*")
public class LogFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpSession session = ((HttpServletRequest) servletRequest).getSession();

        String method = ((HttpServletRequest) servletRequest).getMethod();
        String header = ((HttpServletRequest) servletRequest).getHeader("LogIN");
        ((HttpServletResponse) servletResponse).addHeader("Clay", "man");
        System.out.println(header);

        if (("GET".equalsIgnoreCase(method)) || (header.equals("Basquash"))) {
            System.out.println(((HttpServletRequest) servletRequest).getRequestURI());
            System.out.println("LogFilter OK");
            filterChain.doFilter(servletRequest, servletResponse);
        }



    }

    @Override
    public void destroy() {

    }
}
