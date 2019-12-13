package laba5;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBaseStructure {

        private static final String CREATE_BOOK = "CREATE TABLE book(\n"+
                "b_id integer PRIMARY KEY,\n" +
                " b_name VARCHAR(20) ,\n " +
                "b_dateOut DATE,\n" +
                "b_dateIn DATE\n" + ");";

        private static final String CREATE_READER = "CREATE TABLE reader (\n" +
                "    lastname        varchar(40),\n" +
                "    firstname       varchar(40),\n" +
                "    id              integer,\n" +
                "    telefone        varchar(10),\n" +
                "    address          varchar(40)\n" +
                ");";


        private static final String CREATE_SUBSCRIPTION = "CREATE TABLE subscription(d_id INTEGER , " +
                "d_book VARCHAR(20) NOT NULL," +
                " d_reader VARCHAR(20) NOT NULL" +
                ");";

        private static final String DROP_BOOK = "DROP TABLE book";
        private static final String DROP_READER = "DROP TABLE reader";
        private static final String DROP_SUBSCRIPTION = "DROP TABLE subscription";


    public static void createTables() throws DBConnectionException, SQLException {
            DatabaseConnection connectionManager = new DatabaseConnection();
            try (Connection connection = connectionManager.createConnection()) {
                Statement statement = connection.createStatement();
                statement.executeUpdate(CREATE_READER);
                statement.executeUpdate(CREATE_SUBSCRIPTION);
                statement.executeUpdate(CREATE_BOOK);

            } catch (SQLException ex) {
                throw new SQLException(ex.getMessage());
            }
    }

    public static void dropTables() throws SQLException, DBConnectionException {
        DatabaseConnection connectionManager = new DatabaseConnection();
        try (Connection connection = connectionManager.createConnection()) {
            Statement statement = connection.createStatement();
            statement.execute(DROP_SUBSCRIPTION);
            statement.execute(DROP_READER);
            statement.execute(DROP_BOOK);
        }
        catch(SQLException | DBConnectionException ex){
            throw new SQLException(ex.getMessage());
        }
    }
}
