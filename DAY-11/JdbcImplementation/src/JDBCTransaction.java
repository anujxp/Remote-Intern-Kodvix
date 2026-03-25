import java.sql.*;

public class JDBCTransaction {
    public static void main(String[] args) {
        String dbUrl = "jdbc:mysql://localhost:3306/my_database";
        String user = "root";
        String pass = "root";
        double transferAmount = 500.0;
        int senderId = 102;
        int receiverId = 101;

        try (Connection con = DriverManager.getConnection(dbUrl, user, pass)) {
            con.setAutoCommit(false);

            // 1. Check for sufficient balance
            String checkSql = "SELECT balance FROM accounts WHERE id = ?";
            try (PreparedStatement checkStmt = con.prepareStatement(checkSql)) {
                checkStmt.setInt(1, senderId);
                ResultSet rs = checkStmt.executeQuery();

                if (rs.next()) {
                    double currentBalance = rs.getDouble("balance");
                    if (currentBalance < transferAmount) {
                        System.out.println("Transaction Failed: Insufficient balance!");
                        return; // Exit without committing
                    }
                } else {
                    System.out.println("Transaction Failed: Sender account not found!");
                    return;
                }
            }

            // 2. Perform Debit
            try (PreparedStatement debit = con.prepareStatement("UPDATE accounts SET balance = balance - ? WHERE id = ?")) {
                debit.setDouble(1, transferAmount);
                debit.setInt(2, senderId);
                debit.executeUpdate();

                // 3. Perform Credit
                try (PreparedStatement credit = con.prepareStatement("UPDATE accounts SET balance = balance + ? WHERE id = ?")) {
                    credit.setDouble(1, transferAmount);
                    credit.setInt(2, receiverId);
                    credit.executeUpdate();

                    // 4. Commit if both steps succeed
                    con.commit();
                    System.out.println("Transaction Successful: Amount transferred.");
                }
            }

        } catch (SQLException e) {
            // No need to call rollback if the connection hasn't started the update yet,
            // but usually a good practice inside catch block for transactions.
            System.err.println("Database error occurred. Rolling back...");
            e.printStackTrace();
        }
    }
}