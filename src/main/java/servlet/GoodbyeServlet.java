
package servlet;

import java.io.IOException;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(
        name = "MySecondServlet",
        urlPatterns = {"/goodbye"}
    )
public class GoodbyeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

            // Enumeration<String> headerNames = req.getHeaderNames();
            String headers = "";
            for (Enumeration<String> e = req.getHeaderNames(); e.hasMoreElements();) {
                String headerName = e.nextElement();
                headers += (headerName) + " : " + req.getHeader(headerName) + "\n";
            }
            ServletOutputStream out = res.getOutputStream();
            out.write("<h1>The Request Headers</h1>".getBytes());
            out.write("<pre>".getBytes());
            out.write(headers.getBytes());
            out.write("</pre>".getBytes());
            out.flush();
            out.close();
            // req.getRequestDispatcher("index.jsp").forward(req, res);
    }

}
