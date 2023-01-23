import java.util.LinkedList;
import java.util.List;

public class Bank implements IBank {

    private List<IAccount> accountList;

    public Bank() {
        this.accountList = new LinkedList<>();
    }

    @Override
    public void OpenAccount(IAccount account) {
        accountList.add(account);
    }

    @Override
    public void CloseAccount(int accountNumber) {
        for (IAccount account : accountList) {
            if (account.GetAccountNumber() == accountNumber) {
                if (account.GetCurrentBalance() >= 0 ){
                    accountList.remove(account);
                }
                else
                    System.out.println("Account is not closed due to debt.");
                return;
            }
        }
    }

    @Override
    public List<IAccount> GetAllAccounts() {
        return accountList;
    }

    @Override
    public List<IAccount> GetAllAccountsInDebt() {
        List<IAccount> detList = new LinkedList<>();
        for (IAccount account : accountList) {
            if (account.GetCurrentBalance() < 0)
                detList.add(account);
        }
        return detList;
    }

    @Override
    public List<IAccount> GetAllAccountsWithBalance(double balanceAbove) {
        List<IAccount> detList = new LinkedList<>();
        for (IAccount account : accountList) {
            if (account.GetCurrentBalance() > balanceAbove)
                detList.add(account);
        }
        return detList;
    }


}
