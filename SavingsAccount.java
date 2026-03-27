public class SavingsAccount extends CheckingAccount {

    private double interestRate = 0.05; // default 5%

    public void calcInterest() {
        double interest = getBalance() * interestRate;
        setBalance(getBalance() + interest);
    }

    public void setInterestRate(double rate) {
        interestRate = rate;
    }

    public double getInterestRate() {
        return interestRate;
    }
}