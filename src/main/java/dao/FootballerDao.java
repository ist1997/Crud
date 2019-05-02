package dao;

import db.DatabaseConnector;
import model.Footballer;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FootballerDao {

    private static final String SAVE_METHOD_QUERY = "INSERT INTO footballers(name, team, nationality, price) VALUES (?, ?, ?, ?)";
    private static final String UPDATE_METHOD_QUERY = "UPDATE transfermarket.footballers SET name=?,team=?,nationality=?,price=? WHERE id=?";
    private static final String DELETE_METHOD_QUERY = "DELETE FROM transfermarket.footballers WHERE id=?";
    private static final String GET_ALL_METHOD_QUERY = "SELECT * FROM transfermarket.footballers";
    private static final String DATABASE_NAME = "transfermarket";
    private static final Logger logger = Logger.getLogger(FootballerDao.class);

    public static void save(Footballer footballer) {
        try (Connection connection = DatabaseConnector.getConnection(DATABASE_NAME)) {
            PreparedStatement ps = connection.prepareStatement(SAVE_METHOD_QUERY);
            ps.setString(1, footballer.getName());
            ps.setString(2, footballer.getTeam());
            ps.setString(3, footballer.getNationality());
            ps.setDouble(4, footballer.getPrice());
            logger.debug("SQL query for save method: " + SAVE_METHOD_QUERY);
            ps.executeUpdate();
        } catch (SQLException e) {
            logger.error("Can`t connect to database", e);
        }
    }

    public static void update(Footballer footballer) {
        try (Connection connection = DatabaseConnector.getConnection(DATABASE_NAME)) {
            PreparedStatement ps = connection.prepareStatement(UPDATE_METHOD_QUERY);
            ps.setString(1, footballer.getName());
            ps.setString(2, footballer.getTeam());
            ps.setString(3, footballer.getNationality());
            ps.setDouble(4, footballer.getPrice());
            ps.setInt(5, footballer.getId());
            logger.debug("SQL query for update method: " + UPDATE_METHOD_QUERY);
            ps.executeUpdate();
        } catch (SQLException e) {
            logger.error("Can`t connect to database", e);
        }
    }

    public static void delete(int id) {
        try (Connection connection = DatabaseConnector.getConnection(DATABASE_NAME)) {
            PreparedStatement ps = connection.prepareStatement(DELETE_METHOD_QUERY);
            ps.setLong(1, id);
            logger.debug("SQL query for delete method: " + DELETE_METHOD_QUERY);
            ps.executeUpdate();
        } catch (SQLException e) {
            logger.error("Can`t connect to database", e);
        }
    }

    public static List<Footballer> getAllFootballers() {
        List<Footballer> footballers = new ArrayList<>();
        try (Connection connection = DatabaseConnector.getConnection(DATABASE_NAME)) {
            PreparedStatement ps = connection.prepareStatement(GET_ALL_METHOD_QUERY);
            logger.debug("SQL query for getALLFootballers method: " + GET_ALL_METHOD_QUERY);
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
            logger.error("Can`t connect to database", e);
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
