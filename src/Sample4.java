/*
1.  Prepare more specific exception over generic 'Exception' class.
2.  Always clean up the resources in the finally block 
3.  Avoid catching Throwable or error, unless you have a good reason.
4.  Use custom exception for clearer and more maintenanble code.
*/



public class Sample4 {
    public static void main(String[] args) {
        try {
            validateAge(15);
        }catch (ArithmeticException e){
            System.out.println("Caught Exception "+e.getMessage());
        }
    }
    
    public static void validateAge(int age) throws ArithmeticException {
        
        if (age<18){
            throw new ArithmeticException ("User is underage.");
        }
    }
}
