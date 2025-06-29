import java.util.*;

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public boolean deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            return true;
        }
        return false;
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            return true;
        }
        return false;
    }

    public double getBalance() {
        return balance;
    }
}

public class ATM {
    private static BankAccount account = new BankAccount(5000);
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        displayWelcome();
        while (true) {
            displayMenu();
            int choice = getUserChoice();
            switch (choice) {
                case 1:
                    handleDeposit();
                    break;
                case 2:
                    handleWithdrawal();
                    break;
                case 3:
                    displayBalance();
                    break;
                case 4:
                    exitMessage();
                    return;
                default:
                    System.out.println("\n[!] Invalid option. Please try again.\n");
            }
        }
    }

    private static void displayWelcome() {
        System.out.println("=====================================================================");
        System.out.println("         Welcome to CodSoft Bank ATM");
        System.out.println("=====================================================================");
    }

    private static void displayMenu() {
        System.out.println("\n-------------------------------------------------------------------");
        System.out.println("Please select an option:");
        System.out.println("1. Deposit");
        System.out.println("2. Withdraw");
        System.out.println("3. Check Balance");
        System.out.println("4. Exit");
        System.out.print("Your choice: ");
    }

    private static int getUserChoice() {
        while (!scanner.hasNextInt()) {
            System.out.print("Invalid input. Please enter a number: ");
            scanner.next(); 
        }
        return scanner.nextInt();
    }

    private static void handleDeposit() {
        System.out.print("\nEnter amount to deposit: Rs. ");
        double amount = getValidAmount();
        if (account.deposit(amount)) {
            System.out.printf(" Deposit of Rs. %.2f successful.%n", amount);
        } else {
            System.out.println("[!] Invalid deposit amount. Please enter a positive value.");
        }
    }

    private static void handleWithdrawal() {
        System.out.print("\nEnter amount to withdraw: Rs. ");
        double amount = getValidAmount();
        if (account.withdraw(amount)) {
            System.out.printf("Withdrawal of Rs. %.2f successful. Please collect your cash.%n", amount);
        } else {
            System.out.println("[!] Insufficient balance or invalid amount.");
        }
    }

    private static void displayBalance() {
        System.out.printf("%nYour current account balance is: Rs. %.2f%n", account.getBalance());
    }

    private static void exitMessage() {
        System.out.println("\n===================================================================");
        System.out.println("    Thank you for using CodSoft Bank ATM");
        System.out.println("        Have a wonderful day!");
        System.out.println("====================================================================u");
    }

    private static double getValidAmount() {
        while (!scanner.hasNextDouble()) {
            System.out.print("Invalid amount. Please enter a number: ");
            scanner.next(); 
        }
        return scanner.nextDouble();
    }
}
