package Service;

import java.sql.*;
import java.sql.DriverManager;

/**
 * Created by Keepsmile on 2016-06-15.
 */
public class DbConnection {
    private static Connection connection;

    static public Connection getConnection()
    {
        if (DbConnection.connection == null) {
            String url = "jdbc:mysql://127.0.0.1:8083/javacms";
            String username = "root";
            String password = "root";
            try {
                DbConnection.connection = DriverManager.getConnection(url, username, password);
            } catch (SQLException e) {
                System.out.print(e);
            }
        }

        return DbConnection.connection;
    }
}
