package servlet;

import dao.UserDao;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {

    private static final UserDao userDao = new UserDao();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        User user = userDao.getUserFromDatabase(login, password);
        if (user.getId() != 0) {
            request.getSession().setAttribute("user", user);
            request.getRequestDispatcher("show_list.jsp").forward(request, response);
        } else {
            request.setAttribute("userDoesntExist", true);
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }
}
