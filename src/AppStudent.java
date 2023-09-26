import java.util.Scanner;
public class AppStudent {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentDatabase database = new StudentDatabase();
      
        while(true){
            System.out.println("\nMenu");
            System.out.println("1. Add Student");
            System.out.println("2. Find Student");
            System.out.println("3. Display All Student");
            System.out.println("4. Exit");
            System.out.println("Please enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            
            try {
                switch (choice){
                    case 1:
                        System.out.println("Enter student name: ");
                        String name = scanner.nextLine();
                        System.out.println("Enter student age: ");
                        int age = scanner.nextInt();
                        System.out.println("Enter student course: ");
                        scanner.nextLine();
                        String course = scanner.nextLine();
                        Student student = new Student(name, age, course);
                        database.addStudent(student);
                        break;
                    case 2:
                        System.out.println("Enter student number: ");
                        name = scanner.nextLine();
                        System.out.println(database.findStudenByName(name));
                        break;
                    case 3:
                        database.displayAllStudents();
                        break;
                    case 4:
                        return;
                    default:
                        System.out.println("Invalid choice: Try again");
                
                }
            }catch (Exception e){
                System.out.println("Error "+e.getMessage());
            }
        }
    }
}
