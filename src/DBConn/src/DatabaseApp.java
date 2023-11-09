import java.sql.*;
import java.util.Scanner;

public class DatabaseApp {

    private static final String DB_URL = "jdbc:sqlite:ex1db.db";
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        try {
            Connection conn = connect();
            createTable(conn);

            while (true) {
                System.out.println("Choose an action: \n(1) Insert, \n(2) View, \n(3) Update, \n(4) Delete, \n(5) Quit\n");
                int choice = scanner.nextInt();
                scanner.nextLine();  // consume the newline

                switch (choice) {
                    case 1:
                        System.out.print("Enter first name: ");
                        String firstName = scanner.nextLine();
                        System.out.print("Enter last name: ");
                        String lastName = scanner.nextLine();
                        insertData(conn, firstName, lastName);
                        break;
                    case 2:
                        readData(conn);
                        break;
                    case 3:
                        System.out.print("Enter first name to update: ");
                        String oldFirstName = scanner.nextLine();
                        System.out.print("Enter new last name: ");
                        String newLastName = scanner.nextLine();
                        updateData(conn, oldFirstName, newLastName);
                        break;
                    case 4:
                        System.out.print("Enter first name to delete: ");
                        String deleteFirstName = scanner.nextLine();
                        System.out.print("Enter last name to delete: ");
                        String deleteLastName = scanner.nextLine();
                        deleteData(conn, deleteFirstName, deleteLastName);
                        break;
                    case 5:
                        System.out.println("Exiting...");
                        conn.close();
                        return;
                    default:
                        System.out.println("Invalid choice. Try again.");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static Connection connect() throws Exception {
        return DriverManager.getConnection(DB_URL);
    }

    private static void createTable(Connection conn) throws Exception {
        String sql = "CREATE TABLE IF NOT EXISTS users (id INTEGER PRIMARY KEY, first_name TEXT, last_name TEXT)";
        Statement stmt = conn.createStatement();
        stmt.execute(sql);
    }

    private static void insertData(Connection conn, String firstName, String lastName) throws Exception {
        String sql = "INSERT INTO users (first_name, last_name) VALUES (?, ?)";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, firstName);
        pstmt.setString(2, lastName);
        pstmt.executeUpdate();
    }

    private static void readData(Connection conn) throws Exception {
        String sql = "SELECT * FROM users";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()) {
            System.out.println(rs.getInt("id") + "\t" + rs.getString("first_name") + "\t" + rs.getString("last_name"));
        }
    }

    private static void updateData(Connection conn, String oldFirstName, String newLastName) throws Exception {
        String sql = "UPDATE users SET last_name = ? WHERE first_name = ?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, newLastName);
        pstmt.setString(2, oldFirstName);
        pstmt.executeUpdate();
    }

    private static void deleteData(Connection conn, String firstName, String lastName) throws Exception {
        String sql = "DELETE FROM users WHERE first_name = ? AND last_name = ?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, firstName);
        pstmt.setString(2, lastName);
        pstmt.executeUpdate();
    }
}
