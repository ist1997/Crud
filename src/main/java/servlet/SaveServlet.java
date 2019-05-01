package servlet;

import dao.FootballerDao;
import model.Footballer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "SaveServlet", value = "/save")
public class SaveServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String team = request.getParameter("team");
        String nationality = request.getParameter("nationality");
        double price = Double.parseDouble(request.getParameter("price"));

        Footballer footballer = new Footballer(id, name, team, nationality, price);
        FootballerDao.update(footballer);

        response.sendRedirect("index.jsp");
    }
}
