import java.sql.*;
import java.util.Scanner;

public class BankingApplication {
    private final String url = "jdbc:sqlite:bank.db"; // Replace with your database path
    private final Scanner scanner;

    public BankingApplication() {
        scanner = new Scanner(System.in);
        initializeDatabase();
    }

    private void initializeDatabase() {
        String sqlAccountsTable = "CREATE TABLE IF NOT EXISTS accounts (\n"
                + " id integer PRIMARY KEY AUTOINCREMENT,\n"
                + " name text NOT NULL,\n"
                + " balance real DEFAULT 0\n"
                + ");";
        
        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement()) {
            stmt.execute(sqlAccountsTable);
            System.out.println("Database initialization completed.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
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

    private void createAccount() {
        System.out.print("Enter account holder's name: ");
        String name = scanner.nextLine();
        System.out.print("Enter initial deposit amount: ");
        double balance = Double.parseDouble(scanner.nextLine());

        String sql = "INSERT INTO accounts(name, balance) VALUES(?,?)";

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.setDouble(2, balance);
            pstmt.executeUpdate();
            System.out.println("Account created successfully.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private void deposit() {
        System.out.print("Enter account ID: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter deposit amount: ");
        double amount = Double.parseDouble(scanner.nextLine());

        String sql = "UPDATE accounts SET balance = balance + ? WHERE id = ?";

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setDouble(1, amount);
            pstmt.setInt(2, id);
            int affectedRows = pstmt.executeUpdate();
            if (affectedRows > 0) {
                System.out.println("Deposit successful.");
            } else {
                System.out.println("Account not found.");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private void withdraw() {
        System.out.print("Enter account ID: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter withdrawal amount: ");
        double amount = Double.parseDouble(scanner.nextLine());

        String sql = "UPDATE accounts SET balance = balance - ? WHERE id = ? AND balance >= ?";

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setDouble(1, amount);
            pstmt.setInt(2, id);
            pstmt.setDouble(3, amount);
            int affectedRows = pstmt.executeUpdate();
            if (affectedRows > 0) {
                System.out.println("Withdrawal successful.");
            } else {
                System.out.println("Insufficient funds or account not found.");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private void viewAccounts() {
        String sql = "SELECT id, name, balance FROM accounts";

        try (Connection conn = this.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            System.out.println("ID\tName\tBalance");
            while (rs.next()) {
                System.out.println(rs.getInt("id") + "\t" +
                                   rs.getString("name") + "\t" +
                                   rs.getDouble("balance"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private void searchAccount() {
        System.out.print("Enter account ID to search: ");
        int id = Integer.parseInt(scanner.nextLine());

        String sql = "SELECT id, name, balance FROM accounts WHERE id = ?";

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                System.out.println("ID: " + rs.getInt("id"));
                System.out.println("Name: " + rs.getString("name"));
                System.out.println("Balance: " + rs.getDouble("balance"));
            } else {
                System.out.println("Account not found.");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private void showMenu() {
        while (true) {
            System.out.println("\n*** Simple Banking Application ***");
            System.out.println("1. Create a new account");
            System.out.println("2. Deposit money");
            System.out.println("3. Withdraw money");
            System.out.println("4. View all accounts");
            System.out.println("5. Search for an account");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");

            String option = scanner.nextLine();

            switch (option) {
                case "1":
                    createAccount();
                    break;
                case "2":
                    deposit();
                    break;
                case "3":
                    withdraw();
                    break;
                case "4":
                    viewAccounts();
                    break;
                case "5":
                    searchAccount();
                    break;
                case "6":
                    System.out.println("Exiting the program.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option! Please try again.");
            }
        }
    }

    public static void main(String[] args) {
        BankingApplication app = new BankingApplication();
        app.showMenu();
    }
}
