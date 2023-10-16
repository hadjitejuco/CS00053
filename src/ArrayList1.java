
import java.util.ArrayList;
import java.util.List;

public class ArrayList1 {
 
    public static void main(String[] args) {
        
        List<String> colors = new ArrayList<>();
        
        //add elements (.add)
        colors.add("Red");
        colors.add("Green");
        colors.add("Blue");
        
        System.out.println(colors);
        
        //remove elements (.remove)
        colors.remove("Red");
        System.out.println(colors);
        
        //check if the list containts an element
        //.contains
        //if found -> true 
        boolean hasGreen = colors.contains("Green");
        System.out.println(hasGreen);
        
    }
}
