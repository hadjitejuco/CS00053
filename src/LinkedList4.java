
import java.util.LinkedList;
import java.util.Queue;

public class LinkedList4 {
    public static void main(String[] args) {
        
        Queue <String> queue = new LinkedList<>();
        
        queue.add("A");
        queue.add("B");
        queue.add("C");
        
        System.out.println(queue);
        
        //dequeue 
        //.poll()
        
        System.out.println(queue.poll());
        System.out.println(queue);
        
    }
}
