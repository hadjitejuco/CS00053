import java.util.LinkedList;
import java.util.Queue;
public class Queue2 {
     public static void main(String[] args) {
        Queue<Integer> numbers = new LinkedList<>();
        numbers.offer(1);
        numbers.offer(2);
        numbers.offer(3);

        for (int number : numbers) {
            System.out.println(number);
        }
        
        while(!numbers.isEmpty()){
            System.out.println(numbers.poll()); //dequeue
        }
        
        for (int number : numbers) {
            System.out.println(number);
        }
    }
}
