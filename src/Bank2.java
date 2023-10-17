
import java.util.LinkedList;
import java.util.Iterator;


//linkedlist implementation
public class Bank2 {
    private LinkedList<Customer2> customers2;

    public Bank2() {
        customers2 = new LinkedList<>();
    }

    public void addCustomer2(Customer2 customer2) {
        customers2.add(customer2);
    }

    public Customer findCustomer2(String accountNumber) {
        Iterator<Customer2> iterator = customers2.iterator();
        while(iterator.hasNext()) {
            Customer2 customer2 = iterator.next();
            if(customer2.getAccountNumber().equals(accountNumber)) {
                return customers2;
            }
        }
        return null;
    }
}
