package servlet;

import dao.FootballerDao;
import model.Footballer;

import java.io.IOException;

@javax.servlet.annotation.WebServlet(name = "AddServlet", value = "/add")
public class AddServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        String name = request.getParameter("name");
        String team = request.getParameter("team");
        String nationality = request.getParameter("nationality");
        double price = Double.parseDouble(request.getParameter("price"));

        Footballer footballer = new Footballer(name, team, nationality, price);
        FootballerDao.save(footballer);
        response.sendRedirect("show_list.jsp");
    }
}
