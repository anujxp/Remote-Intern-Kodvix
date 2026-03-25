import java.sql.*;

public class JDBCBatch {
    public static void main(String[] args) {
        String sql = "INSERT INTO students (name, age) VALUES (?, ?)";

        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/my_database", "root", "root");
             PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setString(1, "Aman");
            pst.setInt(2, 20);
            pst.addBatch();

            pst.setString(1, "Sneha");
            pst.setInt(2, 22);
            pst.addBatch();

            int[] results = pst.executeBatch();
            System.out.println("Batch executed. Rows affected: " + results.length);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}