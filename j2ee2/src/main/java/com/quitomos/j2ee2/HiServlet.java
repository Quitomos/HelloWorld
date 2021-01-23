package com.quitomos.j2ee2;

import com.quitomos.j2ee2.Obj.Customers;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class HiServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter pw = resp.getWriter();
        pw.println("<html><body>");
        pw.println("<h1>" + "Hi, Servlet" + "</h1>");
        pw.println("</body></html>");

    }
}
