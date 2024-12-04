import java.sql.*;

public class Main {
    public static void main(String[] args) {
        // Database connection details
        String url = "jdbc:postgresql://localhost:5432/postgres";  // Replace with your database name
        String user = "postgres";  // Replace with your PostgreSQL username
        String password = "postgres";  // Replace with your PostgreSQL password

        try {
            // Load the PostgreSQL JDBC driver
            Class.forName("org.postgresql.Driver");

            // Establish connection
            Connection conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connection successful!");

            // Close connection
            conn.close();
        } catch (Exception e) {
            System.out.println("Connection failed.");
            e.printStackTrace();
        }
    }
}

