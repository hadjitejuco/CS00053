
import java.util.LinkedList;


public class LinkedList3 {
    public static void main(String[] args) {
        LinkedList<String> stack = new LinkedList<>();
        
        //push 
        
        stack.push("A");
        stack.push("B");
        stack.push("C");
        System.out.println(stack);
        
        System.out.println(stack.pop());
        System.out.println(stack);
        
        
        
    }
}
