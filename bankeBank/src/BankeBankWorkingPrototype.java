import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

public class BankeBankWorkingPrototype {

    private static BankATM atm = new BankATM();
    private static Scanner userInput = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            printMenu();
            System.out.print("Choose option between (1 - 7) and (0 to exit): ");
            String userChoice = userInput.nextLine();

            while (userChoice == null || !userChoice.matches("[0-7]")) {
                System.out.print("Invalid option. Choose between (1 - 7) or (0 to exit): ");
                userChoice = userInput.nextLine();
            }

            if (userChoice.equals("0")) {
                System.out.println("Thank you for using our Bank.");
                break;
            }

            if (userChoice.equals("1")) createAccount(); {
                if (userChoice.equals("2")) depositMoney();
                else if (userChoice.equals("3")) withdrawMoney();
                else if (userChoice.equals("4")) checkBalance();
                else if (userChoice.equals("5")) transferMoney();
                else if (userChoice.equals("6")) closeAccount();
                else if (userChoice.equals("7")) changePin();
            }
        }
    }


    public static void printMenu() {
        System.out.println("""
                Welcome to Banke Bank!
                    1. Create an account
                    2. Deposit money
                    3. Withdraw money
                    4. Check Account Balance
                    5. Transfer money
                    6. Close an account
                    7. Change Pin
                    0. Exit
                """);
    }

    public static void createAccount() {
        System.out.print("Enter your first name: ");
        String firstName = userInput.nextLine();
        while (firstName == null || firstName.trim().isEmpty() || !firstName.matches("[a-zA-Z\\s\\-']+")) {
            System.out.print("Invalid first name. Enter again: ");
            firstName = userInput.nextLine();
        }

        System.out.print("Enter your last name: ");
        String lastName = userInput.nextLine();
        while (lastName == null || lastName.trim().isEmpty() || !lastName.matches("[a-zA-Z\\s\\-']+")) {
            System.out.print("Invalid last name. Enter again: ");
            lastName = userInput.nextLine();
        }

        System.out.print("Enter your PIN: ");
        String pin = userInput.nextLine();
        while (pin == null || !pin.matches("\\d{4}")) {
            System.out.print("Invalid PIN. Enter again (must be 4 digits): ");
            pin = userInput.nextLine();
        }

        atm.createAccount(firstName, lastName, pin);
        System.out.println("Your Account Number Is: "+ atm.getAccountNumber());
        System.out.println("Account created successfully: " + firstName.toUpperCase() + " " + lastName.toUpperCase());
    }

    public static void depositMoney() {
        System.out.print("Enter your account number: ");
        String accountNumber = userInput.nextLine();
        while (accountNumber == null || !accountNumber.matches("\\d{10}") || atm.findAccountByAccountNumber(accountNumber) == null)
        {
            System.out.print("Invalid account number. Enter again: ");
            accountNumber = userInput.nextLine();
        }

        System.out.print("Enter deposit amount: ");
        while (!userInput.hasNextDouble()) {
            System.out.print("Invalid amount. Enter a positive number: ");
            userInput.nextLine();
        }
        double depositAmount = userInput.nextDouble();
        userInput.nextLine();

        while (depositAmount <= 0.0) {
            System.out.print("Invalid amount. Enter a positive number: ");
            depositAmount = userInput.nextDouble();
            userInput.nextLine();
        }

        System.out.print("Enter your pin: ");
        String pin = userInput.nextLine();
        while (pin == null || !pin.matches("\\d{4}")) {
            System.out.print("Invalid pin. Enter again: ");
            pin = userInput.nextLine();
        }

        BankAccount userAccount = atm.findAccountByAccountNumber(accountNumber);

        if (userAccount == null) {
            System.out.println("Account not found.");
        } else {
            try {
                userAccount.deposit(pin, depositAmount);
                System.out.println("Deposit successful.");
            }
            catch (Exception e) {
                System.out.println("Deposit failed." + e.getMessage());
            }
        }
    }

    public static void withdrawMoney() {
        System.out.print("Enter your account number: ");
        String accountNumber = userInput.nextLine();
        while (accountNumber == null || !accountNumber.matches("\\d{10}") || atm.findAccountByAccountNumber(accountNumber) == null)
        {
            System.out.print("Invalid account number. Enter again: ");
            accountNumber = userInput.nextLine();
        }

        System.out.print("Enter your pin: ");
        String pin = userInput.nextLine();
        while (pin == null || !pin.matches("\\d{4}")) {
            System.out.print("Invalid pin. Enter again: ");
            pin = userInput.nextLine();
        }

        System.out.print("Enter withdrawal amount: ");
        while (!userInput.hasNextDouble()) {
            System.out.print("Invalid amount. Enter a positive number: ");
            userInput.nextLine();
        }
        double withdrawalAmount = userInput.nextDouble();
        userInput.nextLine();
        while (withdrawalAmount <= 0.0) {
            System.out.print("Invalid amount. Enter a positive number: ");
            withdrawalAmount = userInput.nextDouble();
            userInput.nextLine();
        }

        BankAccount userAccount = atm.findAccountByAccountNumber(accountNumber);

        if (userAccount == null) {
            System.out.println("Account not found.");
        } else {
            try {
            userAccount.withdraw(pin, withdrawalAmount);
            System.out.println("Withdrawal successful.");
        } catch (IllegalArgumentException e) {
            System.out.println("Withdrawal failed." + e.getMessage());
            }
        }
    }

    public static void checkBalance() {
        System.out.print("Enter your account number: ");
        String accountNumber = userInput.nextLine();
        while (accountNumber == null || !accountNumber.matches("\\d{10}") || atm.findAccountByAccountNumber(accountNumber) == null)
        {
            System.out.print("Invalid account number. Enter again: ");
            accountNumber = userInput.nextLine();
        }

        System.out.print("Enter your pin: ");
        String pin = userInput.nextLine();
        while (pin == null || !pin.matches("\\d{4}")) {
            System.out.print("Invalid pin. Enter again: ");
            pin = userInput.nextLine();
        }

        BankAccount userAccount = atm.findAccountByAccountNumber(accountNumber);

        if (userAccount == null) {
            System.out.println("Account not found.");
        } else {
            try {
                userAccount.validatePin(pin);
                System.out.println("Your balance is: " + userAccount.getBalance());
            } catch (IllegalArgumentException e) {
                System.out.println("Getting balance failed. " + e.getMessage());
            }
        }
    }

    public static void transferMoney() {
        System.out.print("Enter your account number: ");
        String accountNumber = userInput.nextLine();
        while (accountNumber == null || !accountNumber.matches("\\d{10}") || atm.findAccountByAccountNumber(accountNumber) == null)
        {
            System.out.print("Invalid account number. Enter again: ");
            accountNumber = userInput.nextLine();
        }

        System.out.print("Enter your pin: ");
        String pin = userInput.nextLine();
        if (pin == null || !pin.matches("\\d{4}")) {
            System.out.print("Invalid pin. Enter again: ");
            pin = userInput.nextLine();
        }

        System.out.print("Enter transfer amount: ");
        if (!userInput.hasNextDouble()) {
            System.out.print("Invalid amount. Enter a positive number: ");
            userInput.nextLine();
        }
        double transferAmount = userInput.nextDouble();
        userInput.nextLine();
        if (transferAmount <= 0.0 || transferAmount > atm.getAccount().getFirst().getBalance()) {
            System.out.print("Invalid amount. Enter a positive number: ");
            transferAmount = userInput.nextDouble();
            userInput.nextLine();
        }

        System.out.print("Enter receiver's account number: ");
        String receiverAccountNumber = userInput.nextLine();
        while (receiverAccountNumber == null || receiverAccountNumber.trim().isEmpty()) {
            System.out.print("Invalid receiver name. Enter again: ");
            receiverAccountNumber = userInput.nextLine();
        }

        BankAccount receiverAccount = atm.findAccountByAccountNumber(receiverAccountNumber);
        BankAccount senderAccount = atm.findAccountByAccountNumber(accountNumber);

        if (receiverAccount == null || senderAccount == null) {
            System.out.println("Account not found.");
        } else {
            try {
                senderAccount.transfer(pin, receiverAccount, transferAmount);
                System.out.println("Transfer successful. Your balance is: " + senderAccount.getBalance());
            }
            catch (IllegalArgumentException e) {
                System.out.println("Transfer failed." + e.getMessage());
            }
        }
    }

    public static void closeAccount() {
        System.out.print("Enter your account number: ");
        String accountNumber = userInput.nextLine();
        while (accountNumber == null || !accountNumber.matches("\\d{10}") || atm.findAccountByAccountNumber(accountNumber) == null)
        {
            System.out.print("Invalid account number. Enter again: ");
            accountNumber = userInput.nextLine();
        }

        System.out.print("Enter your PIN: ");
        String pin = userInput.nextLine();
        while (pin == null || !pin.matches("\\d{4}")) {
            System.out.print("Invalid PIN. Enter again (must be 4 digits): ");
            pin = userInput.nextLine();
        }

        BankAccount userAccount = atm.findAccountByAccountNumber(accountNumber);

        if (userAccount == null) {
            System.out.println("Account not found.");
        } else {
            try {
                userAccount.withdraw(pin, userAccount.getBalance());
                atm.closeAccount(pin, userAccount);
                System.out.println("Account closed successfully.");
            }
            catch (IllegalArgumentException e) {
                System.out.println("Account closed failed." + e.getMessage());
            }
            }
        }

    public static void changePin() {
        System.out.print("Enter your account number: ");
        String accountNumber = userInput.nextLine();
        while (accountNumber == null || !accountNumber.matches("\\d{10}") || atm.findAccountByAccountNumber(accountNumber) == null)
        {
            System.out.print("Invalid account number. Enter again: ");
            accountNumber = userInput.nextLine();
        }

        System.out.print("Enter your old PIN: ");
        String oldPin = userInput.nextLine();
        while (oldPin == null || !oldPin.matches("\\d{4}")) {
            System.out.print("Invalid old PIN. Enter again (must be 4 digits): ");
            oldPin = userInput.nextLine();
        }

        System.out.print("Enter your new PIN: ");
        String newPin = userInput.nextLine();
        while (newPin == null || !newPin.matches("\\d{4}") || newPin.equals(oldPin)) {
                System.out.print("New PIN must be different from the old PIN. Enter again: ");
                newPin = userInput.nextLine();
            }

        BankAccount userAccount = atm.findAccountByAccountNumber(accountNumber);

        if (userAccount == null) {
            System.out.println("Account not found.");
        } else {
            try {
                userAccount.changePin(oldPin, newPin);
                System.out.println("PIN changed successfully.");
            } catch (IllegalArgumentException e) {
                System.out.println("Failed to change PIN: " + e.getMessage());
            }
        }
    }
}



