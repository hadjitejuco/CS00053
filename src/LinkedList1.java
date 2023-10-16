
import java.util.LinkedList;
import java.util.List;

public class LinkedList1 {
    public static void main(String[] args) {
        
        List<String> cities = new LinkedList<>();
        
        //add elements
        
        cities.add("Manila");
        cities.add("Tokyo");
        cities.add("Paris");
            
        System.out.println(cities);
        
        //remove .remove
        cities.remove("Paris");
        System.out.println(cities);
        
        
    }
}
