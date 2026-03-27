import java.io.Serializable;
import java.util.Scanner;

public abstract class User implements HasMenu, Serializable {

    private String userName;
    private String PIN;

    public boolean login() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("User name: ");
        String u = scanner.nextLine();

        System.out.print("PIN: ");
        String p = scanner.nextLine();

        return login(u, p);
    }

    public boolean login(String u, String p) {
        if (u.equals(userName) && p.equals(PIN)) {
            System.out.println("Login Successful");
            return true;
        }
        return false;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setPIN(String PIN) {
        this.PIN = PIN;
    }

    public String getPIN() {
        return PIN;
    }

    public abstract String getReport();
}