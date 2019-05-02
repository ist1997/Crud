package dao;

import db.DatabaseConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CountryDao {

    private static final String DATABASE_NAME = "world";
    private static final String SELECT_QUERY = "SELECT * FROM world.country";

    public List<String> getAllCountries() {
        List<String> countries = new ArrayList<>();
        try (Connection connection = DatabaseConnector.getConnection(DATABASE_NAME)) {
            PreparedStatement ps = connection.prepareStatement(SELECT_QUERY);
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
