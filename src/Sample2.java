//https://github.com/hadjitejuco/CS00053
public class Sample2 {
    public static void main(String[] args) {
        try
        {
            int result = 42/0;
            
            String[] names = {"Hadji", "Joan"};
            String name = names[5];
            
            int num = Integer.parseInt(name);
           
        }
        catch(ArrayIndexOutOfBoundsException e) {
            System.out.println("Caught an array index out of bounds " + e.getMessage());
        }
        catch(NumberFormatException e){
            System.out.println("Caught a number format exception " +e.getMessage());
        }catch(ArithmeticException e){
            System.out.println("Caught arithemic expetion "+e.getMessage());
        }finally{
            System.out.println("This block will always be executed regardless of the exception");
        }
    }
}
