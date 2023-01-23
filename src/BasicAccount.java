public class BasicAccount implements IAccount {
    private int accountNumber;
    private double balance;
    private double withdrawLimit;
    private double creditLimit;

    public BasicAccount(int accountNumber, double withdrawLimit) {
        this.accountNumber = accountNumber;
        this.balance = 0;
        this.withdrawLimit = withdrawLimit;
        this.creditLimit = 0;
    }
    @Override
    public void Deposit(double amount) {
        balance += amount;
    }

    @Override
    public double Withdraw(double amount) {
        if (amount >= withdrawLimit) {
            if (balance >= withdrawLimit) {
                balance -= withdrawLimit;
                return withdrawLimit;
            }
            else {
                double temp = balance;
                balance = 0;
                return temp;
            }
        }
        else {
            if(balance >= amount) {
                balance -= amount;
                return amount;
            }
            else {
                double temp = balance;
                balance = 0;
                return temp;
            }
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
