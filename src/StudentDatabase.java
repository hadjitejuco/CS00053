
public class StudentDatabase {
    private static final int MAX_STUDENT = 10;
    private Student[] students;
    private int currentCount;


    public StudentDatabase() {
        students = new Student[MAX_STUDENT];
        currentCount = 0;
    }
    
    //addStudent()
    public void addStudent(Student student){
        if (currentCount >= MAX_STUDENT){
            throw new RuntimeException("Database is Full.  Cannot add more students.");
        }
        students[currentCount++] = student;
    }
    
    //findStudentByName()
    
    public Student findStudenByName(String name){
        for (int i = 0; i < currentCount; i++) {
            if (students[i].getName().equalsIgnoreCase(name)){
                return students[i];
            }
        }
        throw new RuntimeException("Student Not Found");
    }
    //displayAllStudents()
    public void displayAllStudents(){
        for (int i = 0; i < currentCount; i++) {
            System.out.println(students[i]);
        }
        
    }
}
