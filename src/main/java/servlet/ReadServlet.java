package servlet;

import dao.FootballerDao;
import model.Footballer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "ReadServlet", value = "/read")
public class ReadServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        List<Footballer> footballers = FootballerDao.getAllFootballers();

        out.println("<form action=\"index.jsp\">\n" +
                "    <input type=\"submit\" value=\"Add new footballer\">\n" +
                "  </form>");
        out.println("<h1>Footballer List</h1>");
        out.print("<table border='1' width='100%'");
        out.print("<tr><th>Id</th>" +
                "<th>Name</th>" +
                "<th>Team</th>" +
                "<th>Nationality</th>" +
                "<th>Price</th>" +
                "<th>Edit</th>" +
                "<th>Delete</th></tr>");
        for (Footballer footballer : footballers) {
            out.print("<tr><td>" +
                    footballer.getId() + "</td><td>" +
                    footballer.getName() + "</td><td>" +
                    footballer.getTeam() + "</td><td>" +
                    footballer.getNationality() + "</td><td>$" +
                    footballer.getPrice() + " m</td><td>" +
                    "<a href='update?id=" + footballer.getId() + "'>update</a></td><td>" +
                    "<a href='delete?id=" + footballer.getId() + "'>delete</a></td></tr>");
        }
        out.print("</table>");
        out.close();
    }
}