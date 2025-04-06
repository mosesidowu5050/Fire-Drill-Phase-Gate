import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class BankATM {
    private List<BankAccount> bankAccounts;

    public BankATM() {
        this.bankAccounts = new ArrayList<BankAccount>();
    }

    public void createAccount(String firstName, String lastName, String pin) {
        if(!BankAccount.isValidPin(pin)){
            throw new IllegalArgumentException("Invalid PIN");
        }
        BankAccount account = new BankAccount(firstName, lastName, pin);
        bankAccounts.add(account);
    }

    public List<BankAccount> getAccount() {
        return bankAccounts;
    }

    public void transfer(String pin, BankAccount sender, BankAccount receiver, double transferAmount) {
        if(sender == null || receiver == null) {
            throw new IllegalArgumentException("Invalid sender or receiver");
        }
        sender.transfer(pin, receiver, transferAmount);
    }

    public double getBalance(String pin, BankAccount accountBalance) {
        if (accountBalance == null) {
            throw new IllegalArgumentException("Invalid account balance");
        }
        System.out.println(accountBalance.getBalance());
        return accountBalance.getBalance();
    }

    public void closeAccount(String pin, BankAccount bankAccount) {
        if (bankAccount == null) {
            throw new IllegalArgumentException("Invalid account balance");
        }
        bankAccount.withdraw(pin, bankAccount.getBalance());
        bankAccounts.remove(bankAccount);
    }

    public BankAccount findAccountByPin(String pin) {
        for (BankAccount account : bankAccounts) {
            if (account.getPin().equalsIgnoreCase(pin)) {
                return account;
            }
        }
        return null;
    }

    public BankAccount findAccountByName(String receiver) {
        for (BankAccount account : bankAccounts) {
            if (account.getName().equalsIgnoreCase(receiver)) {
                return account;
            }
        }
        return null;
    }
}
