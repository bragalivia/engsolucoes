package dao.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Livia on 12/06/2016.
 */
public class ConnectionMysql {
    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            return DriverManager.getConnection("jdbc:mysql://localhost/engsolucoes","root", "root");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
