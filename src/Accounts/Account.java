package Accounts;

public class Account {

    private double accountNumber;
    private double balance;

    public Account(double accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public double getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount){
        balance += amount;
    }
    public void withdrawal(double amount){
        balance -= amount;
    }


}
