package lab5;

import laba5.DBConnectionException;
import laba5.DataBaseStructure;
import laba5.DatabaseConnection;
import org.testng.annotations.Test;

import java.sql.Connection;
import java.sql.SQLException;

public class TestDatabase {

    @Test
    public void testDatabaseConnection() throws DBConnectionException {
        Connection connection = new DatabaseConnection().createConnection();
    }

    @Test
    public void testCreateTables() throws DBConnectionException, SQLException {
        DataBaseStructure.createTables();
    }

    @Test
    public void testDropTables() throws SQLException, DBConnectionException {
        DataBaseStructure.dropTables();
    }

}
