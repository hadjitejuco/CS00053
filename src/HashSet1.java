
import java.util.HashSet;
import java.util.Set;

public class HashSet1 {
    public static void main(String[] args) {
        
        Set<String> fruits = new HashSet<>();
        
        //add elements
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Cherry");
        fruits.add("Apple");
        
        System.out.println(fruits);
//        
//        boolean containsApple = fruits.contains("Apple");
//        System.out.println(containsApple);
//        
//        //remove
//        
//        fruits.remove("Banana");
//        System.out.println(fruits);
//        
//        for (String fruit: fruits){
//            System.out.println(fruit);
//        }
        
    }
}
