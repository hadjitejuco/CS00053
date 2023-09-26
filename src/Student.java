public class Student {
    
    private String name;
    private int age;
    private String course;
    
    public Student (String name, int age, String course){
        this.name = name;
        this.age = age;
        this.course = course;
    }
    public String getName(){
        return name;
    }
    public int getAge(){
        return age;
    }
    public String getCourse(){
        return course;
    }
    
    @Override
    public String toString(){
        return "Name is: " +name+ "Age is: "+age+ "Course is: "+course;
    }
    
}

class StudentDatabase{
    private static final int MAX_STUDENT = 10;
    private Student[] students;
    private int currentCount;


    public StudentDatabase() {
        students = new Student[MAX_STUDENT];
        currentCount = 0;
    }
    
    //addStudent()
    public void addStudent(Student students){
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