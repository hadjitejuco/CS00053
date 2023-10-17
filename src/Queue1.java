import java.util.LinkedList;
import java.util.Queue;

public class Queue1 {
     public static void main(String[] args) {
        Queue<String> queue = new LinkedList<>();
        queue.offer("Apple");
        queue.offer("Banana");
        queue.offer("Cherry");

        System.out.println("Head of the queue: " + queue.peek()); // Apple
        System.out.println("Removing head: " + queue.poll());      // Apple
        System.out.println("New head: " + queue.peek());           // Banana
    }
}
