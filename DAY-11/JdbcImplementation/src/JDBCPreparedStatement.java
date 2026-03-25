import java.sql.*;

public class JDBCPreparedStatement {
    public static void main(String[] args) throws Exception {
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/my_database", "root", "root");
        PreparedStatement pstInsert = con.prepareStatement("INSERT INTO students (name, marks) VALUES (?, ?)");
        pstInsert.setString(1, "Rahul");
        pstInsert.setDouble(2, 90.5);
        int rows = pstInsert.executeUpdate();

        PreparedStatement pstSelect = con.prepareStatement("SELECT * FROM students WHERE id = ?");
        pstSelect.setInt(1, 1);
        ResultSet rs = pstSelect.executeQuery();

        PreparedStatement pstAny = con.prepareStatement("DELETE FROM students WHERE id = ?");
        pstAny.setInt(1, 2);
        boolean isResultSet = pstAny.execute();

        con.close();
    }
}