package Framework;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Igor Sychev on 08.11.14.
 */
public class ResultSetExtensions {

    public static boolean next(ResultSet resultSet) {
        boolean result = false;
        try {
            result = resultSet.next();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            return result;
        }
    }
}
