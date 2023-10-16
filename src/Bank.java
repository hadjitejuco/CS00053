
import java.util.ArrayList;

////https://github.com/hadjitejuco/CS00053/tree/master/src


public class Bank {
    
    private ArrayList<Customer> customers;
    
    public Bank(){
        customers = new ArrayList<>();
    }
    
    public void addCustomer(Customer customer){
        customers.add(customer);
    }
    
    public Customer findCustomer(String accountNumber) {
        for(Customer customer : customers) {
            if (customer.getAccountNumber().equals(accountNumber)){
                return customer;
            }
        }
        return null;
    }
}
