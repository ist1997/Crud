package db;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;

public class DatabaseConnectorTest {

    private static final String TRANSFERMARKET_DB_NAME = "transfermarket";
    private static final String WORLD_DB_NAME = "world";
    private Connection transfermarketConnection, worldConnection;

    @Before
    public void setUp() throws Exception {
        transfermarketConnection = DatabaseConnector.getConnection(TRANSFERMARKET_DB_NAME);
        worldConnection = DatabaseConnector.getConnection(WORLD_DB_NAME);
    }

    @Test
    public void getConnectionTest() throws SQLException {
        Assert.assertEquals(TRANSFERMARKET_DB_NAME, transfermarketConnection.getCatalog());
        Assert.assertEquals(WORLD_DB_NAME, worldConnection.getCatalog());
        Assert.assertEquals("MySQL", worldConnection.getMetaData().getDatabaseProductName());
        Assert.assertEquals("MySQL Connector/J", transfermarketConnection.getMetaData().getDriverName());
    }
}