import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Properties;
import java.io.InputStream;

public final class DatabaseInitializer {
    public static void main(String[] args) {
        try (InputStream input = DatabaseInitializer.class.getClassLoader().getResourceAsStream("database.properties")) {
            if (input == null) {
                System.out.println("Error: database.properties file not found!");
                return;
            }
            Properties props = new Properties();
            props.load(input);

            String url = props.getProperty("db.url");
            String user = props.getProperty("db.user");
            String password = props.getProperty("db.password");

            try (Connection conn = DriverManager.getConnection(url, user, password);
                 Statement stmt = conn.createStatement()) {

                String createTableSQL = "CREATE TABLE IF NOT EXISTS \"user\" (" +
                        "id SERIAL PRIMARY KEY, " +
                        "username VARCHAR(50) NOT NULL, " +
                        "email VARCHAR(100) UNIQUE NOT NULL, " +
                        "password VARCHAR(100) NOT NULL, " +
                        "created_at TIMESTAMP DEFAULT NOW()" +
                        ");";

                stmt.executeUpdate(createTableSQL);
                System.out.println("Table 'user' created successfully.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
