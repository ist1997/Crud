package servlet;

import dao.FootballerDao;
import model.Footballer;
import org.apache.log4j.Logger;

import java.io.IOException;

@javax.servlet.annotation.WebServlet(name = "AddServlet", value = "/add")
public class AddServlet extends javax.servlet.http.HttpServlet {

    private static final Logger logger = Logger.getLogger(AddServlet.class);

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        String name = request.getParameter("name");
        String team = request.getParameter("team");
        String nationality = request.getParameter("nationality");
        double price = Double.parseDouble(request.getParameter("price"));

        Footballer footballer = new Footballer(name, team, nationality, price);
        FootballerDao.save(footballer);

        logger.info("Added footballer: " + footballer.toString());
        response.sendRedirect("show_list.jsp");
    }
}
