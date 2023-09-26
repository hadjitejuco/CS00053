//use throw
public class Sample3 {
    public static void main(String[] args) {
        int age = 15;
        
        if (age < 18){
            throw new ArithmeticException("User is underage");
        }
    }
}
