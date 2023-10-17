

//https://github.com/hadjitejuco/CS00053/tree/master/src

import java.util.ArrayList;
import java.util.List;

public class Customer {
    //set private variables
    private String name;
    private String accountNumber;
    private double balance;
    
    public Customer(String name, String accountNumber, double balance){
        this.name = name;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }
    
    public String getName(){
        return name;
    }
    
    public String getAccountNumber(){
        return accountNumber;
    }
    
    public double getBalance(){
        return balance;
    }
    
    public void deposit(double amount){
        if (amount > 0){
            balance += amount;
        }
    }
    
    
    public boolean withraw(double amount){
        if (amount > 0 && balance >= amount){
            balance -= amount;
            return true;
        }
        return false;
    }
    
    @Override
    public String toString(){
        return "Name "+ name + ", Account Number " + accountNumber + " , Balance "+balance;
    }

    boolean withdraw(double amount) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
