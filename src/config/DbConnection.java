package config;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnection {

    public static Connection openConnection() throws ClassNotFoundException , SQLException{
        Class.forName("org.postgresql.Driver");
        return DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/Olimpiadi_2",
                "postgres",
                "1234"
        );

    }
}
