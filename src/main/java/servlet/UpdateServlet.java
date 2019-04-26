package servlet;

import dao.FootballerDao;
import model.Footballer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UpdateServlet", value = "/update")
public class UpdateServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Footballer footballer = FootballerDao.getFootballerById(id);
        request.setAttribute("footballer", footballer);
        request.setAttribute("countries", GetCountryDataServlet.getAllCountries());
        request.getRequestDispatcher("update.jsp").forward(request, response);
    }
}
