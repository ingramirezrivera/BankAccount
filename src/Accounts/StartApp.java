package Accounts;

import java.util.Scanner;

public class StartApp {

    public static int findAccountNumber(Account[] accounts, double accountNumberToSearch){
        int index = 0;
        int iterator = 0;
        boolean accountNumberFound = false;

        while((iterator < accounts.length) && (accountNumberFound == false)) {
            if (accounts[iterator].getAccountNumber() == accountNumberToSearch) {
                accountNumberFound = true;
                index = iterator;
            }
            iterator++;
        }
        if(accountNumberFound == false){
            index = -1;
        }
        return index;
    }

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
            String name,cc;
            Account accounts[];
            Client client;
            int accountsQuantity, option, accountNumberIndex;
            double accountNumber, balance, amountQuantity;


        System.out.print("Enter the name of the client: ");
        name = keyboard.next();

        System.out.print("Enter cc client: ");
        cc = keyboard.next();

        System.out.print("Enter the accounts quantity of the client: ");
        accountsQuantity = keyboard.nextInt();

        accounts = new Account[accountsQuantity];

        for (int i = 0; i < accounts.length; i++) {
            System.out.println("\nDigite la " + (i+1)+ "° cuenta: ");
            System.out.print("Enter the account Number: ");
            accountNumber = keyboard.nextDouble();

            System.out.print("Enter the account balance: ");
            balance = keyboard.nextDouble();
            System.out.println(" ");

            accounts[i] = new Account(accountNumber, balance);
        }

        client = new Client(name, cc, accounts );


        do {
            System.out.println("\n\tMENU");
            System.out.println("\nPress the option number to select");
            System.out.println("\n1. Check account balance");
            System.out.println("\n2. Make a deposit");
            System.out.println("\n3. Make a withdrawal");
            System.out.println("\n4. Exit");
            System.out.println("\nEnter  the option: ");
            option = keyboard.nextInt();

            switch (option){
                case 1:
                    System.out.println("\nEnter the account number: ");
                    accountNumber = keyboard.nextDouble();
                    accountNumberIndex = findAccountNumber(accounts, accountNumber);
                    if(accountNumberIndex == -1){
                        System.out.println("Account not found, verify your account number.");
                        System.out.println(" ");
                    }
                    System.out.println("\nYour Balance account is: ");
                    System.out.println(client.checkBalance(accountNumberIndex));

                    break;
                case 2:
                    System.out.println("\nEnter the account number: ");
                    accountNumber = keyboard.nextDouble();
                    accountNumberIndex = findAccountNumber(accounts, accountNumber);
                    if(accountNumberIndex == -1){
                        System.out.println("Account not found, verify your account number.");
                        System.out.println(" ");
                    }
                    System.out.println("\nEnter the amount to deposit: ");
                    amountQuantity = keyboard.nextDouble();

                    client.deposit(accountNumberIndex, amountQuantity);
                    System.out.println("\nDeposit successful");
                    System.out.println("\nYour new balance is: " + client.checkBalance(accountNumberIndex));
                    break;
                case 3:
                    System.out.println("\nEnter the account number: ");
                    accountNumber = keyboard.nextDouble();
                    accountNumberIndex = findAccountNumber(accounts, accountNumber);
                    if(accountNumberIndex == -1){
                        System.out.println("Account not found, verify your account number.");
                        System.out.println(" ");
                    }
                    System.out.println("\nEnter the amount to withdrawal: ");
                    amountQuantity = keyboard.nextDouble();

                    client.withdrawal(accountNumberIndex, amountQuantity);
                    System.out.println("\nDeposit successful");
                    System.out.println("\nYour new balance is: " + client.checkBalance(accountNumberIndex));

                    break;
                case 4:
                    System.out.println("\nThanks for visit us");
                    break;
                default:
                    System.out.println("\nNot available option, please enter a valid option");
                    break;
            }

        }while (option != 4);






    }
}
