import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BankATM {
    private List<BankAccount> bankAccounts;
    private String lastCreatedAccountNumber;

    public BankATM() {
        this.bankAccounts = new ArrayList<>();
    }

    public String createAccount(String firstName, String lastName, String pin) {
            if(!BankAccount.isValidPin(pin)){
                throw new IllegalArgumentException("Invalid PIN");
            }
            if (firstName == null || firstName.isEmpty() || lastName == null || lastName.isEmpty() || pin == null || pin.isEmpty()) {
                throw new IllegalArgumentException("Fields cannot be empty");
            }
            Random randomNumber = new Random();
            String accountNumbersGenerator = String.format("%010d", randomNumber.nextInt(1000000000));
            BankAccount account = new BankAccount(firstName, lastName, pin, accountNumbersGenerator);
            bankAccounts.add(account);
            lastCreatedAccountNumber = accountNumbersGenerator;

            return lastCreatedAccountNumber;
    }

    public List<BankAccount> getAccount() {
        return bankAccounts;
    }

    public int getAccountSize(){
        return bankAccounts.size();
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
            return accountBalance.getBalance();
    }

    public void closeAccount(String pin, BankAccount bankAccount) {
            if (bankAccount == null) {
                throw new IllegalArgumentException("Invalid account balance");
            }
            bankAccount.withdraw(pin, bankAccount.getBalance());
            bankAccounts.remove(bankAccount);
    }

    public BankAccount findAccountByAccountNumber(String accountNumber) {
            for (BankAccount account : bankAccounts) {
                if (account.getAccountNumber().equalsIgnoreCase(accountNumber)) {
                    return account;
                }
            }
            return null;
    }

    public String getAccountNumber() {
        return lastCreatedAccountNumber;
    }
}
