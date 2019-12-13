package laba5;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseConnection {

        protected Connection connection;

        private Properties properties;
        private Connection con = null;

        {
            properties = new Properties();
        }

        public DatabaseConnection() {
            try {
                Class.forName("org.postgresql.Driver");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

        public Connection createConnection() throws DBConnectionException {
            try {
                properties.load(getClass().getResourceAsStream("/database.properties"));
                con = DriverManager.getConnection(
                        properties.getProperty("connection.url"),
                        properties.getProperty("connection.user"),
                        properties.getProperty("connection.password")
                );
            }
            catch (SQLException | IOException ex) {
                throw new DBConnectionException(ex.getMessage());
            }
            return con;
        }

        public void closeConnection() {
            try {
                this.con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
}
