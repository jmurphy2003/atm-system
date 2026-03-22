import java.util.Scanner;

public class CheckingAccount implements HasMenu {
    private double balance;
    private Scanner scanner = new Scanner(System.in);

    public CheckingAccount() {
        this.balance = 0;
    }

    public CheckingAccount(double balance) {
        this.balance = balance;
    }

    public static void main(String[] args) {
        CheckingAccount acc = new CheckingAccount();
        acc.start();
    }

    public String menu() {
        return "\nAccount menu\n" +
               "0) quit\n" +
               "1) check balance\n" +
               "2) make a deposit\n" +
               "3) make a withdrawal\n";
    }

    public void start() {
        int choice;
        do {
            System.out.println(menu());
            System.out.print("Please enter 0-3: ");
            choice = (int)getDouble();

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
        System.out.println("Current balance: " + getBalanceString());
    }

    private double getDouble() {
        try {
            return Double.parseDouble(scanner.nextLine());
        } catch (Exception e) {
            return 0;
        }
    }

    public void makeDeposit() {
        System.out.print("How much to deposit? ");
        double amt = getDouble();
        balance += amt;
        System.out.println("New balance: " + getBalanceString());
    }

    public void makeWithdrawal() {
        System.out.print("How much to withdraw? ");
        double amt = getDouble();
        balance -= amt;
        System.out.println("New balance: " + getBalanceString());
    }
}