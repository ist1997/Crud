package dao;

import db.DatabaseConnector;
import model.Footballer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FootballerDao {

    private static final String DATABASE_NAME = "transfermarket";

    public static void save(Footballer footballer) {
        try (Connection connection = DatabaseConnector.getConnection(DATABASE_NAME)) {
            String sqlQuery = "insert into footballers(name, team, nationality, price) values (?, ?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(sqlQuery);
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
        try (Connection connection = DatabaseConnector.getConnection(DATABASE_NAME)) {
            String sqlQuery = "update transfermarket.footballers set name=?,team=?,nationality=?,price=? where id=?";
            PreparedStatement ps = connection.prepareStatement(sqlQuery);
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
        try (Connection connection = DatabaseConnector.getConnection(DATABASE_NAME)) {
            PreparedStatement ps = connection.prepareStatement("delete from transfermarket.footballers where id=" + id);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static List<Footballer> getAllFootballers() {
        List<Footballer> footballers = new ArrayList<>();
        try (Connection connection = DatabaseConnector.getConnection(DATABASE_NAME)) {
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
        Footballer returnFootballer = new Footballer();
        for (Footballer footballer : getAllFootballers()) {
            if (footballer.getId() == id) {
                returnFootballer = footballer;
            }
        }
        return returnFootballer;
    }
}
