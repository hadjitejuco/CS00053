////https://github.com/hadjitejuco/CS00053/tree/master/src

import java.util.Scanner;

public class BankingApplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Bank bank = new Bank();
        
        while(true){
            System.out.println("----------MENU-----------");
            System.out.println("1. Add Customer");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Check Balance");
            System.out.println("5. Exit");
            System.out.println("Enter your choice: ");
            int choice = scanner.nextInt();
            
            switch(choice){
                case 1:
                    System.out.println("Enter Name: ");
                    String name = scanner.next();
                    System.out.println("Enter Account number");
                    String accountNumber = scanner.next();
                    bank.addCustomer(new Customer(name, accountNumber, 0));
                    break;
                case 2:
                    System.out.println("Enter account number: ");
                    accountNumber = scanner.next();
                    System.out.println("Enter amount to deposit ");
                    double amount = scanner.nextDouble();
                    
                    Customer customer = bank.findCustomer(accountNumber);
                    if (customer != null){
                        customer.deposit(amount);
                        System.out.println("Amount deposited Successfully ");
                    }else{
                        System.out.println("Account Not found ");
                    }
                    break;
                case 3:
                    System.out.println("Enter account number: ");
                    accountNumber = scanner.next();
                    System.out.println("Enter amount to deposit ");
                    amount = scanner.nextDouble();
                    
                    customer = bank.findCustomer(accountNumber);
                    if (customer != null){
                        if (customer.withraw(amount)){
                            System.out.println("Amount withdrawn Successfully");
                        }else{
                            System.out.println("Insufficient Balance");
                        }
                        
                    }else{
                        System.out.println("Account not found..");
                    
                    }    
                    break;
                    
                case 4:
                    System.out.println("Enter account number: ");
                    accountNumber = scanner.next();
                    
                    customer = bank.findCustomer(accountNumber);

                    if (customer != null) {
                        System.out.println(customer);
                    
                    }else{
                        System.out.println("Account not found ");
                    }
                    break;
                    
                case 5:
                    System.out.println("Bye Bye....");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid Choice ");
                    break;
            
            }
        
        
        
        
        
        
        }
        
        
        
        
    }
    
}
