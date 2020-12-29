import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        request.setCharacterEncoding("GBK");
        String name = request.getParameter("user");
        String password = request.getParameter("password");

//        System.out.println("user: " + name);
//        System.out.println("password: " + password);

        response.setCharacterEncoding("GBK");

        String ms = null;
        if ("admin".equals(name) && "123".equals(password))
            ms = "<div style='color:green'>success</div>";
            //request.getRequestDispatcher("success.html").forward(request,response);
            //response.sendRedirect("success.html");
        else
            //response.sendRedirect("fail.html");
            //request.getRequestDispatcher("fail.html").forward(request,response);
            ms = "<div style='color:red'>失败</div>";
        PrintWriter pw = response.getWriter();
        pw.println(ms);

    }
}
