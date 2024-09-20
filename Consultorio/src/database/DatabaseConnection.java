package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author wallyson
 */
public class DatabaseConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/Consultorio";
    private static final String USER = "devt";
    private static final String PASSWORD = "1234@Local";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
    
    
}
