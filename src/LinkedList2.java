import java.util.LinkedList;
import java.util.List;
import java.util.Iterator;


public class LinkedList2 {
    public static void main(String[] args) {
        
        //iteration
        List<String> animals = new LinkedList<>();
        
        //populate 
        animals.add("Dog");
        animals.add("Cat");
        
        Iterator<String> iterator = animals.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
        
    }
    
    
}
