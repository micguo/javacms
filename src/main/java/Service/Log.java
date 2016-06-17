package Service;

import java.sql.*;

/**
 * Created by Keepsmile on 2016-06-16.
 */
public class Log {

    private enum level {
        LOG_NOTICE,
        LOG_WARNING,
        LOG_ERROR
    }


    static public void notice(String message)
    {
        Log.log(message, level.LOG_NOTICE);
    }


    static public void warning(String message)
    {
        Log.log(message, level.LOG_WARNING);
    }

    static public void error(String message)
    {
        Log.log(message, level.LOG_ERROR);
    }

    static private void log(String message, level level)
    {
        Connection conn = DbConnection.getConnection();
        try {
            PreparedStatement stat = conn.prepareStatement("INSERT INTO Log (message, level) VALUES (?, ?)");
            stat.setString(1, message);
            stat.setInt(2, level.ordinal());
            stat.execute();
        } catch (SQLException e) {
            System.out.print(e);
        }
    }
}
