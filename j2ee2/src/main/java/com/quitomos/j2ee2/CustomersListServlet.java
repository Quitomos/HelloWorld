package com.quitomos.j2ee2;

import com.quitomos.j2ee2.DAO.CustomersDAO;
import com.quitomos.j2ee2.Obj.Customers;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CustomersListServlet extends HttpServlet {
    @Override
    public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
        Customers c1 = new Customers("1","1",1);
        List<Customers> cs = new CustomersDAO().get();
        StringBuffer sb = new StringBuffer();
        sb.append("<table align='center' border='1' cellspacing='0'>\r\n");
        sb.append("<tr><td>id</td><td>name</td><td>city</td></tr>\r\n");
        String trFormat = "<tr><td>%d</td><td>%s</td><td>%s</td></tr>\r\n";

        for (Customers c: cs) {
            String tr = String.format(trFormat, c.getId(), c.getName(), c.getCity());
            sb.append(tr);
        }
        sb.append("</table>");
        resp.getWriter().write(sb.toString());

    }
}

