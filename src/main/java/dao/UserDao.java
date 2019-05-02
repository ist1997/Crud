package dao;

import db.DatabaseConnector;
import model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {

    private static final String SELECT_USER_QUERY = "SELECT * FROM transfermarket.users WHERE login=? AND password=?";
    private static final String SELECT_USER_EXIST_QUERY = "SELECT * FROM transfermarket.users WHERE login=?";
    private static final String INSERT_ROLE_QUERY = "SELECT * FROM transfermarket.roles WHERE id=?";
    private static final String INSERT_QUERY = "insert into transfermarket.users(login, password, role_id) values (?, ?, ?)";
    private static final String DATABASE_NAME = "transfermarket";


    public User getUserFromDatabase(String login, String password) {
        User user = new User();
        try (Connection connection = DatabaseConnector.getConnection(DATABASE_NAME)) {
            PreparedStatement ps = connection.prepareStatement(SELECT_USER_QUERY);
            ps.setString(1, login);
            ps.setString(2, password);
            ResultSet getUser = ps.executeQuery();
            if (getUser.next()) {
                user = new User(
                        Long.valueOf(getUser.getString(1)),
                        getUser.getString(2),
                        getUser.getString(3),
                        Long.valueOf(getUser.getString(4)));
            }
        } catch (SQLException e) {
            e.printStackTrace(); //logger
        }
        return user;
    }

    public boolean isUserExistsInDatabase(User user) {
        try (Connection connection = DatabaseConnector.getConnection(DATABASE_NAME)) {
            PreparedStatement ps = connection.prepareStatement(SELECT_USER_EXIST_QUERY);
            ps.setString(1, user.getLogin());
            ResultSet getUser = ps.executeQuery();
            if (getUser.next()) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace(); //logger
        }
        return false;
    }

    public void addUserToDatabase(User user) {
        try (Connection connection = DatabaseConnector.getConnection(DATABASE_NAME)) {
            PreparedStatement ps = connection.prepareStatement(INSERT_QUERY);
            ps.setString(1, user.getLogin());
            ps.setString(2, user.getPassword());
            ps.setLong(3, user.getRoleId());
            ps.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static String getUserRole(User user) {
        String role = "";
        try (Connection connection = DatabaseConnector.getConnection(DATABASE_NAME)) {
            PreparedStatement ps = connection.prepareStatement(INSERT_ROLE_QUERY);
            ps.setLong(1, user.getRoleId());
            ResultSet getRole = ps.executeQuery();
            if (getRole.next()) {
                role = getRole.getString(2);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return role;
    }
}
