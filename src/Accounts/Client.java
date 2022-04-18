package Accounts;

public class Client {

    private String name;
    private String cc;
    Account accounts[];

    public Client(String name, String cc, Account[] accounts) {
        this.name = name;
        this.cc = cc;
        this.accounts = accounts;
    }

    public String getName() {
        return name;
    }

    public String getCc() {
        return cc;
    }

    public double checkBalance(int index ){
        return accounts[index].getBalance();
    }

    public void deposit(int index, double amount){
        accounts[index].deposit(amount);
    }

    public void withdrawal(int index, double amount){
        accounts[index].withdrawal(amount);
    }
}
