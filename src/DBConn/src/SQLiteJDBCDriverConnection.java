import java.sql.*;
import java.util.Scanner;

public class SQLiteJDBCDriverConnection {
    // SQLite connection string
    private final String url = "jdbc:sqlite:dbxx.db";
    private final Scanner scanner;

    public SQLiteJDBCDriverConnection() {
        scanner = new Scanner(System.in);
    }

    private Connection connect() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    public void createNewTable() {
        String sql = "CREATE TABLE IF NOT EXISTS warehouses (\n"
                + " id integer PRIMARY KEY,\n"
                + " name text NOT NULL,\n"
                + " capacity real\n"
                + ");";

        try (Connection conn = this.connect();
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println("Table created.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void insert(int id, String name, double capacity) {
        String sql = "INSERT INTO warehouses(id, name, capacity) VALUES(?,?,?)";

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.setString(2, name);
            pstmt.setDouble(3, capacity);
            pstmt.executeUpdate();
            System.out.println("Record inserted.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void selectAll() {
        String sql = "SELECT id, name, capacity FROM warehouses";

        try (Connection conn = this.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                System.out.println(rs.getInt("id") + "\t" +
                        rs.getString("name") + "\t" +
                        rs.getDouble("capacity"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private int getNextId() {
        String sql = "SELECT COALESCE(MAX(id), 0) + 1 as nextId FROM warehouses";
        try (Connection conn = this.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            if (rs.next()) {
                return rs.getInt("nextId");
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return 1; // Default ID if table is empty or on error
    }

    public void addNewWarehouse() {
        System.out.print("Enter warehouse name: ");
        String name = scanner.nextLine();

        System.out.print("Enter warehouse capacity: ");
        double capacity = Double.parseDouble(scanner.nextLine());

        insert(getNextId(), name, capacity);
    }

    public void showMenu() {
        while (true) {
            System.out.println("\n*** Warehouse Management System ***");
            System.out.println("1. Add New Warehouse");
            System.out.println("2. Show All Warehouses");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");

            String option = scanner.nextLine();

            switch (option) {
                case "1":
                    addNewWarehouse();
                    break;
                case "2":
                    selectAll();
                    break;
                case "3":
                    System.out.println("Exiting the program.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option! Please try again.");
            }
        }
    }

    public static void main(String[] args) {
        SQLiteJDBCDriverConnection app = new SQLiteJDBCDriverConnection();
        app.createNewTable(); // Create a new table if not present
        app.showMenu();       // Show the menu
    }
}
