package DAOAccessor;

import java.sql.ResultSet;

public class DBUtils {

    private static final String DB_EXISTS_QUERY = "SELECT SCHEMA_NAME FROM INFORMATION_SCHEMA.SCHEMATA WHERE SCHEMA_NAME = \"%s\"";
    private static final String CREATE_DB_SAFE_QUERY = "CREATE DATABASE IF NOT EXISTS %s";
    private static final String TABLE_EXISTS_QUERY = "SELECT * FROM information_schema.tables WHERE table_schema = \"%s\" AND table_name = \"%s\"";

    public static boolean dbExists(String dbName) {
        ResultSet resultSet = DBFactory.executeQuery(String.format(DB_EXISTS_QUERY, dbName));
        return ResultSetExtensions.next(resultSet);
    }

    public static void createDbSafe(String dbName) {
        DBFactory.executeUpdate(String.format(CREATE_DB_SAFE_QUERY, dbName));
    }

    public static boolean tableExists(String dbName, String tableName) {
        ResultSet resultSet = DBFactory.executeQuery(String.format(TABLE_EXISTS_QUERY, dbName, tableName));
        return ResultSetExtensions.next(resultSet);
    }
}
