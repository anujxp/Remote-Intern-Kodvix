import java.sql.*;

public class AdvancedJDBC {
    public static void main(String[] args) throws Exception {
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db", "root", "pass");

        // Create a scrollable and updatable statement
        Statement stmt = con.createStatement(
                ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_UPDATABLE
        );

        ResultSet rs = stmt.executeQuery("SELECT * FROM students");

        // 1. Jump to the last row
        rs.last();
        System.out.println("Last Student: " + rs.getString("name"));

        // 2. Move to a specific row (e.g., 2nd row)
        rs.absolute(2);
        System.out.println("Second Student: " + rs.getString("name"));

        // 3. Move backward 1 row relative to current position
        rs.relative(-1);
        System.out.println("Previous (1st) Student: " + rs.getString("name"));

        // 4. Update data directly in the ResultSet
        rs.absolute(1);
        rs.updateString("name", "New Name"); // Update locally
        rs.updateRow(); // Push update to the database

        con.close();
    }
}