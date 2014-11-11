package DAOAccessor;

import Framework.LogFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Logger;

public class DBFactory {

    private static Connection connection = null;

    private final static String DriverName = "com.mysql.jdbc.Driver";
    private final static String DBConnect = "jdbc:mysql://localhost:3306/CheckIn";
    private final static String Username = "root";
    private final static String Password = "root";

    public static Connection getConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                return connection;
            }

            Class.forName(DriverName);
            connection = DriverManager.getConnection(DBConnect, Username, Password);
            return connection;
        } catch (Exception e) {
            throw new RuntimeException("Error while try initialize db connection", e);
        }
    }

    public static ResultSet executeQuery(String query) {
        try {
            LogFactory.getLogger().info(String.format("Execute query : %s", query));
            Connection currentConnection = getConnection();
            Statement statement = currentConnection.createStatement();
            return statement.executeQuery(query);
        } catch (Exception e) {
            throw new RuntimeException(String.format("Can't execute SQL query '%s'", query), e);
        }
    }

    public static int executeUpdate(String query) {
        try {
            LogFactory.getLogger().info(String.format("Execute query : %s", query));
            Connection currentConnection = getConnection();
            Statement statement = currentConnection.createStatement();
            return statement.executeUpdate(query);
        } catch (Exception e) {
            throw new RuntimeException(String.format("Can't execute SQL query '%s'", query), e);
        }
    }
}
