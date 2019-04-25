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

    public static void save(Footballer footballer) {
        try (Connection con = FootballerDao.getConnection()) {
            String sqlQuery = "insert into footballers(name, team, nationality, price) values (?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sqlQuery);
            ps.setString(1, footballer.getName());
            ps.setString(2, footballer.getTeam());
            ps.setString(3, footballer.getNationality());
            ps.setDouble(4, footballer.getPrice());
            ps.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void update(Footballer footballer) {
        try (Connection con = FootballerDao.getConnection()) {
            String sqlQuery = "update transfermarket.footballers set name=?,team=?,nationality=?,price=? where id=?";
            PreparedStatement ps = con.prepareStatement(sqlQuery);
            ps.setString(1, footballer.getName());
            ps.setString(2, footballer.getTeam());
            ps.setString(3, footballer.getNationality());
            ps.setDouble(4, footballer.getPrice());
            ps.setInt(5, footballer.getId());
            ps.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void delete(int id) {
        try (Connection con = FootballerDao.getConnection()) {
            PreparedStatement ps = con.prepareStatement("delete from transfermarket.footballers where id=" + id);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
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

    public static Footballer getFootballerById(int id) {
        for (Footballer footballer : getAllFootballers()) {
            if (footballer.getId() == id) {
                return footballer;
            }
        }
        return null;
    }
}
