import java.io.Serializable;
import java.util.Scanner;

public class CheckingAccount implements HasMenu, Serializable {

    private double balance;

    public CheckingAccount() {
        balance = 0;
    }

    public CheckingAccount(double balance) {
        this.balance = balance;
    }

    public String menu() {
        return "\nAccount menu\n" +
               "0) quit\n" +
               "1) check balance\n" +
               "2) make a deposit\n" +
               "3) make a withdrawal\n";
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println(menu());
            System.out.print("Please enter 0-3: ");
            choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1: checkBalance(); break;
                case 2: makeDeposit(); break;
                case 3: makeWithdrawal(); break;
            }

        } while (choice != 0);
    }

    public double getBalance() {
        return balance;
    }

    public String getBalanceString() {
        return String.format("$%.2f", balance);
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void checkBalance() {
        System.out.println("Checking balance...");
        System.out.println("Current balance: " + getBalanceString());
    }

    private double getDouble() {
        Scanner scanner = new Scanner(System.in);
        try {
            return Double.parseDouble(scanner.nextLine());
        } catch (Exception e) {
            return 0;
        }
    }

    public void makeDeposit() {
        System.out.println("Making a deposit...");
        System.out.print("How much to deposit? ");
        double amt = getDouble();
        balance += amt;
        System.out.println("New balance: " + getBalanceString());
    }

    public void makeWithdrawal() {
        System.out.println("Making a withdrawal...");
        System.out.print("How much to withdraw? ");
        double amt = getDouble();
        balance -= amt;
        System.out.println("New balance: " + getBalanceString());
    }
}