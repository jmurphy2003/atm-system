import java.util.*;
import java.io.*;

public class Bank implements HasMenu {

    private Admin admin = new Admin();
    private CustomerList customers = new CustomerList();

    public static void main(String[] args) {
        new Bank();
    }

    public Bank() {
        loadCustomers();
        start(); 
        saveCustomers();
    }

    public String menu() {
        return "\nBank Menu\n" +
               "0) Exit system\n" +
               "1) Login as admin\n" +
               "2) Login as customer\n";
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println(menu());
            System.out.print("Action: ");
            choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    if (admin.login()) startAdmin();
                    break;
                case 2:
                    loginAsCustomer();
                    break;
            }

        } while (choice != 0);
    }

    public void startAdmin() {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println(admin.menu());
            System.out.print("Action: ");
            choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1: fullCustomerReport(); break;
                case 2: addUser(); break;
                case 3: applyInterest(); break;
            }

        } while (choice != 0);
    }

    public void fullCustomerReport() {
        for (Customer c : customers) {
            System.out.println(c.getReport());
        }
    }

    public void addUser() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Name: ");
        String name = scanner.nextLine();

        System.out.print("PIN: ");
        String pin = scanner.nextLine();

        customers.add(new Customer(name, pin));
    }

    public void applyInterest() {
        for (Customer c : customers) {
            c.getSavings().calcInterest();
            System.out.println("New balance: " +
                c.getSavings().getBalanceString());
        }
    }

    public void loginAsCustomer() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("User name: ");
        String name = scanner.nextLine();

        System.out.print("PIN: ");
        String pin = scanner.nextLine();

        for (Customer c : customers) {
            if (c.login(name, pin)) {
                c.start();
                return;
            }
        }

        System.out.println("Login failed");
    }

    public void saveCustomers() {
        try {
            ObjectOutputStream out =
                new ObjectOutputStream(new FileOutputStream("customers.dat"));
            out.writeObject(customers);
            out.close();
        } catch (Exception e) {
            System.out.println("Save error");
        }
    }

public void loadSampleCustomers() {
        Customer a = new Customer("Alice", "0000");
        a.getChecking().setBalance(1000);
        a.getSavings().setBalance(1000);

        customers.add(a);
        customers.add(new Customer("Bob", "1111"));
        customers.add(new Customer("Cindy", "2222"));
    }

    public void loadCustomers() {
        try {
            ObjectInputStream in =
                new ObjectInputStream(new FileInputStream("customers.dat"));
            customers = (CustomerList) in.readObject();
            in.close();
        } catch (Exception e) {
            System.out.println("No saved data, using sample.");
            loadSampleCustomers();
        }
    }
}