import java.sql.*;

public class JDBCResultSetExample {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/my_database";
        String user = "root";
        String pass = "root";
        String query = "SELECT id, name, age, marks, is_active, joining_date FROM students";

        try (Connection con = DriverManager.getConnection(url, user, pass);
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                // 1. Retrieve by Column Name
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int age = rs.getShort("age"); // Short for smaller integers
                double marks = rs.getDouble("marks");
                boolean isActive = rs.getBoolean("is_active");
                Date date = rs.getDate("joining_date");
                long timestamp = rs.getLong("id"); // Can get ID as long if needed

                // 2. Retrieve by Column Index (Starts at 1)
                // String nameByIndex = rs.getString(2); 

                // Printing the results
                System.out.println("ID: " + id);
                System.out.println("Name: " + name);
                System.out.println("Age: " + age);
                System.out.println("Marks: " + marks);
                System.out.println("Active: " + isActive);
                System.out.println("Date: " + date);
                System.out.println("---------------------------");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}