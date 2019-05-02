package dao;

import db.DatabaseConnector;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CountryDao {

    private static final String GET_ALL_METHOD_QUERY = "SELECT * FROM world.country";
    private static final String DATABASE_NAME = "world";
    private static final Logger logger = Logger.getLogger(CountryDao.class);

    public List<String> getAllCountries() {
        List<String> countries = new ArrayList<>();
        try (Connection connection = DatabaseConnector.getConnection(DATABASE_NAME)) {
            PreparedStatement ps = connection.prepareStatement(GET_ALL_METHOD_QUERY);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                countries.add(rs.getString(2));
            }
            Collections.sort(countries);
        } catch (SQLException e) {
            logger.error("Can`t connect to database", e);
        }
        return countries;
    }
}
