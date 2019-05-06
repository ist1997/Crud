package servlet;

import dao.UserDao;
import model.User;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {

    private static final UserDao userDao = new UserDao();
    private static final Logger logger = Logger.getLogger(LoginServlet.class);

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        User user = userDao.getUserFromDatabase(login, password);
        if (user.getId() != 0) {
            request.getSession().setAttribute("user", user);
            logger.debug("Logged in! User: " + user.toString());
            request.getRequestDispatcher("show_list.jsp").forward(request, response);
        } else {
            request.setAttribute("userDoesntExist", true);
            logger.debug("User does not exist: " + user.toString());
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }
}
