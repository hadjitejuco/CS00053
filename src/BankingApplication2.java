

import java.util.Scanner;
//linkedlist implementation
public class BankingApplication2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Bank2 bank2 = new Bank2();

        while(true) {
            System.out.println("----- Banking Application -----");
            System.out.println("1. Add Customer");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Check Balance");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch(choice) {
                case 1:
                    System.out.print("Enter name: ");
                    String name = scanner.next();
                    System.out.print("Enter account number: ");
                    String accountNumber = scanner.next();
                    bank2.addCustomer2(new Customer2(name, accountNumber, 0));
                    break;

                case 2:
                    System.out.print("Enter account number: ");
                    accountNumber = scanner.next();
                    System.out.print("Enter deposit amount: ");
                    double amount = scanner.nextDouble();

                    Customer customer2 = bank2.findCustomer2(accountNumber);
                    if(customer2 != null) {
                        customer2.deposit(amount);
                        System.out.println("Amount deposited successfully!");
                    } else {
                        System.out.println("Account not found!");
                    }
                    break;


                case 3:
                    System.out.print("Enter account number: ");
                    accountNumber = scanner.next();
                    System.out.print("Enter withdrawal amount: ");
                    amount = scanner.nextDouble();

                    customer2 = bank2.findCustomer2(accountNumber);
                    if(customer2 != null) {
                        if(customer2.withdraw(amount)) {
                            System.out.println("Amount withdrawn successfully!");
                        } else {
                            System.out.println("Insufficient funds!");
                        }
                    } else {
                        System.out.println("Account not found!");
                    }
                    break;

                case 4:
                    System.out.print("Enter account number: ");
                    accountNumber = scanner.next();

                    customer2 = bank2.findCustomer2(accountNumber);
                    if(customer2 != null) {
                        System.out.println(customer2);
                    } else {
                        System.out.println("Account not found!");
                    }
                    break;

                case 5:
                    System.out.println("Thank you for using the Banking Application!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice!");
                    break;
            }
        }
    }
}
