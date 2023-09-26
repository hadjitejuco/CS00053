
//https://github.com/hadjitejuco/CS00053
public class Sample1 {
    public static void main(String[] args) {
          // shows the Exception in thread "main" java.lang.ArithmeticException: / by zero
//        int d = 0;
//        int a = 10 /d;
//        System.out.println(a);
        int d, a;
        try
        {   
            d = 0;
            a = 10 /d;
            System.out.println("Answer is "+a); 
        }catch (ArithmeticException e) {
            System.out.println("Division by zero: ArithmeticException");
            System.out.println("You cant divide a number by zero....");
            System.out.println("Try to check your input data...");
        }
        System.out.println("after catch statement....");







            
    }
}
