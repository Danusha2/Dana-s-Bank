public class PremiumAccount implements IAccount{

    private int accountNumber;
    private double balance;

    public PremiumAccount(int accountNumber) {
        this.accountNumber = accountNumber;
        this.balance = 0;
    }
    @Override
    public void Deposit(double amount) {
        balance += amount;
    }

    @Override
    public double Withdraw(double amount) {
        balance -= amount;
        return amount;
    }

    @Override
    public double GetCurrentBalance() {
        return balance;
    }

    @Override
    public int GetAccountNumber() {
        return accountNumber;
    }
}
