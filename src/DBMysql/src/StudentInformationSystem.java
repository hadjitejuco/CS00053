import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class StudentInformationSystem {
    private static DatabaseHelper dbHelper;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        try {
            dbHelper = new DatabaseHelper();
            int choice;

            do {
                System.out.println("\n===== Student Information System Menu =====");
                System.out.println("1. Add Student");
                System.out.println("2. Edit Student");
                System.out.println("3. View All Students");
                System.out.println("4. View Specific Student");
                System.out.println("5. Delete Student");
                System.out.println("0. Exit");
                System.out.print("Enter choice: ");
                choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        addStudent();
                        break;
                    case 2:
                        editStudent();
                        break;
                    case 3:
                        viewAllStudents();
                        break;
                    case 4:
                        viewSpecificStudent();
                        break;
                    case 5:
                        deleteStudent();
                        break;
                    case 0:
                        System.out.println("Exiting...");
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } while (choice != 0);

        } catch (SQLException e) {
            System.out.println("A database error occurred.");
            e.printStackTrace();
        } finally {
            if (dbHelper != null) {
                dbHelper.close();
            }
        }
    }

    private static void addStudent() throws SQLException {
        System.out.print("Enter first name: ");
        String firstName = scanner.next();
        System.out.print("Enter last name: ");
        String lastName = scanner.next();
        System.out.print("Enter age: ");
        int age = scanner.nextInt();
        System.out.print("Enter email: ");
        String email = scanner.next();

        Student student = new Student(firstName, lastName, age, email);
        dbHelper.addStudent(student);
        System.out.println("Student added successfully!");
    }

    private static void editStudent() throws SQLException {
        System.out.print("Enter student ID: ");
        int id = scanner.nextInt();
        System.out.print("Enter first name: ");
        String firstName = scanner.next();
        System.out.print("Enter last name: ");
        String lastName = scanner.next();
        System.out.print("Enter age: ");
        int age = scanner.nextInt();
        System.out.print("Enter email: ");
        String email = scanner.next();

        Student student = new Student(id, firstName, lastName, age, email);
        dbHelper.editStudent(student);
        System.out.println("Student updated successfully!");
    }

    private static void viewAllStudents() throws SQLException {
        List<Student> students = dbHelper.getAllStudents();
        for (Student student : students) {
            System.out.println(student);
        }
    }

    private static void viewSpecificStudent() throws SQLException {
        System.out.print("Enter student ID: ");
        int id = scanner.nextInt();
        Student student = dbHelper.getStudent(id);
        if (student != null) {
            System.out.println(student);
        } else {
            System.out.println("Student not found!");
        }
    }

    private static void deleteStudent() throws SQLException {
        System.out.print("Enter student ID to delete: ");
        int id = scanner.nextInt();
        dbHelper.deleteStudent(id);
        System.out.println("Student deleted successfully!");
    }
}
