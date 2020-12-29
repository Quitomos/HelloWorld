import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        try {
            response.getWriter().println("<h1>Hello Servlet!</h1>");
            response.getWriter().println(new Date().toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void init(ServletConfig config) {
        System.out.println("Init the HelloServlet");
    }
}
