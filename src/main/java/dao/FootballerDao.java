package dao;


import model.Footballer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FootballerDao {
    private static final String URL = "jdbc:mysql://localhost:3306/transfermarket?useSSL=false&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASSWORD = "1111";

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

    public static int save(Footballer footballer) {
        int status = 0;
        try {
            Connection con = FootballerDao.getConnection();
            PreparedStatement ps = con.prepareStatement("insert into footballers(name, team, nationality, price) values (?, ?, ?, ?)");
            ps.setString(1, footballer.getName());
            ps.setString(2, footballer.getTeam());
            ps.setString(3, footballer.getNationality());
            ps.setDouble(4, footballer.getPrice());

            status = ps.executeUpdate();
            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return status;
    }

    public static List<Footballer> getAllFootballers() {
        List<Footballer> footballers = new ArrayList<>();
        try (Connection connection = FootballerDao.getConnection()) {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM transfermarket.footballers");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Footballer footballer = new Footballer(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getDouble(5)
                );
                footballers.add(footballer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return footballers;
    }
}
