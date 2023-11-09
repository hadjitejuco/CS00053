import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MySQLAccess {
    private Connection connect = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;

    public void connectToDB() throws ClassNotFoundException, SQLException {
        // This will load the MySQL driver, each DB has its own driver
        Class.forName("com.mysql.cj.jdbc.Driver");
        
        // Setup the connection with the DB
        connect = DriverManager.getConnection("jdbc:mysql://localhost/Sample?" +
                                              "user=root&password=");

        // Statements allow to issue SQL queries to the database
        preparedStatement = connect.prepareStatement("SELECT * FROM users");
        
        // Result set get the result of the SQL query
        resultSet = preparedStatement.executeQuery();
        
        // Print out the result set in the console
        while (resultSet.next()) {
            System.out.println("ID: " + resultSet.getString("id"));
            System.out.println("Username: " + resultSet.getString("username"));
        }
    }

    // You need to close the resultSet, preparedStatement, and connection after you're done
    private void close() {
        try {
            if (resultSet != null) {
                resultSet.close();
            }

            if (preparedStatement != null) {
                preparedStatement.close();
            }

            if (connect != null) {
                connect.close();
            }
        } catch (Exception e) {
            // handle the exception
        }
    }

    public static void main(String[] args) {
        MySQLAccess dao = new MySQLAccess();
        try {
            dao.connectToDB();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            dao.close();
        }
    }
}
