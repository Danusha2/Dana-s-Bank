public class StandardAccount implements IAccount{

    private int accountNumber;
    private double creditLimit;
    private double balance;

    public StandardAccount(int accountNumber, double creditLimit) {
        this.accountNumber = accountNumber;
        this.balance = 0;
        if (creditLimit > 0)
            this.creditLimit = 0;
        else
            this.creditLimit = creditLimit;
    }

    @Override
    public void Deposit(double amount) {
        this.balance += amount;
    }

    @Override
    public double Withdraw(double amount) {
        // in case there is no more money we can withdraw
        if (balance == creditLimit)
            return 0;
        // in case we have enough money
        if ( (balance + (-1 * creditLimit)) > amount) {
            balance -= amount;
            return amount;
        }
        else {
            double CurrentBalance = balance;
            balance = creditLimit;
            return CurrentBalance + (-1 * creditLimit);
        }
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
