package servlet;

import dao.CountryDao;
import dao.FootballerDao;
import model.Footballer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "OpenAddOrUpdateServlet", value = "/addOrUpdate")
public class OpenAddOrUpdateServlet extends HttpServlet {

    private static final CountryDao countryDao = new CountryDao();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("countries", countryDao.getAllCountries());
        req.getRequestDispatcher("add.jsp").forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Footballer footballer = FootballerDao.getFootballerById(id);
        req.setAttribute("footballer", footballer);
        req.setAttribute("countries", countryDao.getAllCountries());
        req.getRequestDispatcher("update.jsp").forward(req, resp);
    }
}
