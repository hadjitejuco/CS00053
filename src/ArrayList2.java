//https://github.com/hadjitejuco/CS00053/tree/master/src

import java.util.ArrayList;
import java.util.List;

public class ArrayList2 {
    public static void main(String[] args) {
        //iterate over the arraylist
        List<String> names = new ArrayList<>();
        names.add("Hadji");
        names.add("Jeiven");
        names.add("Johann");
        
        for(String name: names){
            System.out.println(name);
        }
    }
}
