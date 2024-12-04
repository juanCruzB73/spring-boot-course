package MavenDemo04.src.main.java.com.MavenDemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class App {
    public static void main(String[] args) {
        // Database connection details
        String url = "jdbc:postgresql://localhost:5432/mydb";  // Replace with your database name
        String user = "jcadmin";  // Replace with your PostgreSQL username
        String password = "admin";  // Replace with your PostgreSQL password
        String query="SELECT first_name from students  where id=1";
        String query1="DELETE FROM students WHERE id=5";
        String query2="Select * from students;";

        try {
            // Load the PostgreSQL JDBC driver
            Class.forName("org.postgresql.Driver");

            // Establish connection
            Connection conn = DriverManager.getConnection(url, user, password);
            
            //statement
            Statement st = conn.createStatement();
           
            //Instertin
            boolean status =st.execute(query1); 
            /*ResultSet result = st.executeQuery(query2);
            
            while(result.next()){
                System.out.println("id: "+result.getInt("id"));
                System.out.println("first_name: "+result.getString("first_name"));
                System.out.println("last_name: "+result.getString("last_name"));
                System.out.println("age: "+ result.getInt("age"));
                System.out.println("email: "+result.getString("email"));
                System.out.println("---------------------");
            }*/
            
            /*result.next();

            String name = result.getString("first_name");
            System.out.println(name);
            
            */
            
            //message all good
            System.out.println("Connection successful!");
        
            // Close connection
            conn.close();
        } catch (Exception e) {
            System.out.println("Connection failed.");
            e.printStackTrace();
        }
    }
}

