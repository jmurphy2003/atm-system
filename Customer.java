import java.util.Scanner;

public class Customer extends User {

    private CheckingAccount checking = new CheckingAccount();
    private SavingsAccount savings = new SavingsAccount();

    public Customer() {
    }

    public Customer(String name, String pin) {
        setUserName(name);
        setPIN(pin);
    }

    public String menu() {
        return "\nCustomer Menu\n" +
               "0) Exit\n" +
               "1) Manage Checking Account\n" +
               "2) Manage Savings Account\n" +
               "3) Change PIN\n";
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println(menu());
            System.out.print("Action (0-3): ");
            choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    System.out.println("Checking Account");
                    checking.start();
                    break;
                case 2:
                    System.out.println("Savings Account");
                    savings.start();
                    break;
                case 3:
                    changePin();
                    break;
            }

        } while (choice != 0);
    }

    public void changePin() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter new PIN: ");
        setPIN(scanner.nextLine());
    }

    public String getReport() {
        return "User: " + getUserName() +
               ", Checking: " + checking.getBalanceString() +
               ", Savings: " + savings.getBalanceString();
    }

    public CheckingAccount getChecking() {
        return checking;
    }

    public SavingsAccount getSavings() {
        return savings;
    }
}