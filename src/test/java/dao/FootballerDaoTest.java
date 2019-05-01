package dao;

import db.DatabaseConnector;
import model.Footballer;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class FootballerDaoTest {

    private static final String COUNT_QUERY = "SELECT COUNT(*) FROM transfermarket.footballers";
    private static final String SELECT_QUERY = "SELECT * FROM transfermarket.footballers WHERE name='Mane'";
    private static final String TRANSFERMARKET_DB_NAME = "transfermarket";
    private Footballer footballer;
    private Connection connection;
    private Statement statement;

    @Before
    public void setUp() throws Exception {
        footballer = new Footballer(28, "Mane", "Liverpool", "Senegal", 75);
        connection = DatabaseConnector.getConnection(TRANSFERMARKET_DB_NAME);
        statement = connection.createStatement();
    }

    @Test
    public void saveTest() throws SQLException {
        ResultSet rs = statement.executeQuery(COUNT_QUERY);
        rs.next();
        int startCount = rs.getInt(1);
        //FootballerDao.save(footballer);
        rs = statement.executeQuery(COUNT_QUERY);
        rs.next();
        Assert.assertEquals(startCount + 1, rs.getInt(1));
    }

    @Test
    public void updateTest() throws SQLException {
        //FootballerDao.update(footballer);
        ResultSet rs = statement.executeQuery(SELECT_QUERY);
        rs.next();
        Assert.assertEquals("Mane", rs.getString(2));
    }

    @Test
    public void deleteTest() throws SQLException {
        ResultSet rs = statement.executeQuery(COUNT_QUERY);
        rs.next();
        int startCount = rs.getInt(1);
        //FootballerDao.delete(1);
        rs = statement.executeQuery(COUNT_QUERY);
        rs.next();
        Assert.assertEquals(startCount - 1, rs.getInt(1));
    }

    @Test
    public void getAllFootballersTest() throws SQLException {
        List<Footballer> list = FootballerDao.getAllFootballers();
        ResultSet rs = statement.executeQuery(COUNT_QUERY);
        rs.next();
        int count = rs.getInt(1);
        Assert.assertEquals(count, list.size());
    }

    @Test
    public void getFootballerByIdTest() {
        int id = 1;
        Assert.assertEquals(id, FootballerDao.getFootballerById(id).getId());
    }
}