package servlet;

import dao.FootballerDao;
import model.Footballer;

import java.io.IOException;
import java.io.PrintWriter;

@javax.servlet.annotation.WebServlet(name = "CreateServlet", value = "/create")
public class CreateServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String name = request.getParameter("name");
        String team = request.getParameter("team");
        String nationality = request.getParameter("nationality");
        double price = Double.parseDouble(request.getParameter("price"));

        Footballer footballer = new Footballer(name, team, nationality, price);
        int status = FootballerDao.save(footballer);
        if (status > 0) {
            out.println("Record saved successfully!");
        } else {
            out.println("Sorry! Unable to save record");
        }
        out.println("<form action=\"read\">\n" +
                "    <input type=\"submit\" value=\"Show footballer list\">\n" +
                "  </form>");
        out.close();
    }
}
