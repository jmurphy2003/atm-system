import java.util.Scanner;

public class Customer extends User {
    private CheckingAccount checking = new CheckingAccount();
    private SavingsAccount savings = new SavingsAccount();
    private Scanner scanner = new Scanner(System.in);

    public Customer() {
        setUserName("Alice");
        setPIN("0000");
    }

    public static void main(String[] args) {
        Customer c = new Customer();

        if (c.login()) {
            c.start();
        }
    }

    public String menu() {
        return "\nCustomer Menu\n" +
               "0) Exit\n" +
               "1) Manage Checking Account\n" +
               "2) Manage Savings Account\n" +
               "3) Change PIN\n";
    }

    public void start() {
        int choice;
        do {
            System.out.println(menu());
            System.out.print("Action (0-3): ");
            choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1: checking.start(); break;
                case 2: savings.start(); break;
                case 3: changePin(); break;
            }
        } while (choice != 0);
    }

    public void changePin() {
        System.out.print("Enter new PIN: ");
        setPIN(scanner.nextLine());
    }

    public String getReport() {
        return "Customer: " + getUserName() +
               "\nChecking: " + checking.getBalanceString() +
               "\nSavings: " + savings.getBalanceString();
    }
}