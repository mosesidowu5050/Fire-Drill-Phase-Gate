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
        try {
            if(!BankAccount.isValidPin(pin)){
                throw new IllegalArgumentException("Invalid PIN");
            }
            Random randomNumber = new Random();
            String accountNumbersGenerator = String.format("%010d", randomNumber.nextInt(1000000000));

            BankAccount account = new BankAccount(firstName, lastName, pin, accountNumbersGenerator);
            bankAccounts.add(account);
            lastCreatedAccountNumber = accountNumbersGenerator;

            return lastCreatedAccountNumber;
        } catch (Exception e) {
            System.out.println("There is an error while creating account: " + e.getMessage());
            return null;
        }
    }

    public List<BankAccount> getAccount() {
        return bankAccounts;
    }

    public void transfer(String pin, BankAccount sender, BankAccount receiver, double transferAmount) {
        try {
            if(sender == null || receiver == null) {
                throw new IllegalArgumentException("Invalid sender or receiver");
            }
            sender.transfer(pin, receiver, transferAmount);
        } catch (Exception e) {
            System.out.println("There is an error while transferring: " + e.getMessage());
        }
    }

    public double getBalance(String pin, BankAccount accountBalance) {
        try {
            if (accountBalance == null) {
                throw new IllegalArgumentException("Invalid account balance");
            }
            return accountBalance.getBalance();
        } catch (Exception e) {
            System.out.println("There is an error getting balance: " + e.getMessage());
            return 0;
        }
    }

    public void closeAccount(String pin, BankAccount bankAccount) {
        try {
            if (bankAccount == null) {
                throw new IllegalArgumentException("Invalid account balance");
            }
            bankAccount.withdraw(pin, bankAccount.getBalance());
            bankAccounts.remove(bankAccount);
        } catch (Exception e) {
            System.out.println("Error while closing account: " + e.getMessage());
        }
    }

    public BankAccount findAccountByAccountNumber(String accountNumber) {
        try {
            for (BankAccount account : bankAccounts) {
                if (account.getAccountNumber().equalsIgnoreCase(accountNumber)) {
                    return account;
                }
            }
            return null;
        } catch (Exception e) {
            System.out.println("Error finding account: " + e.getMessage());
            return null;
        }
    }

    public String getAccountNumber() {
        return lastCreatedAccountNumber;
    }
}
