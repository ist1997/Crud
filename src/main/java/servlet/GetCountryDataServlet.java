package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@WebServlet(name = "GetCountryDataServlet", value = "/getData")
public class GetCountryDataServlet extends HttpServlet {

    private static final String URL = "jdbc:mysql://localhost:3306/world?useSSL=false&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASSWORD = "1111";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("countries", getAllCountries());
        req.getRequestDispatcher("add.jsp").forward(req, resp);
    }

    private static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static List<String> getAllCountries() {
        List<String> countries = new ArrayList<>();
        try (Connection connection = getConnection()) {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM world.country");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                countries.add(rs.getString(2));
            }
            Collections.sort(countries);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return countries;
    }
}
