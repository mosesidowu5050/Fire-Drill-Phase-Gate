import java.util.Locale;
import java.util.Scanner;

public class BankeBankWorkingPrototype {

    public static void main(String[] args) {
        BankATM atm = new BankATM();
        Scanner userInput = new Scanner(System.in);

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

            if (userChoice.equals("1")) {
                createAccount(atm, userInput);
            } else if (userChoice.equals("2")) {
                depositMoney(atm, userInput);
            } else if (userChoice.equals("3")) {
                withdrawMoney(atm, userInput);
            } else if (userChoice.equals("4")) {
                checkBalance(atm, userInput);
            } else if (userChoice.equals("5")) {
                transferMoney(atm, userInput);
            } else if (userChoice.equals("6")) {
                closeAccount(atm, userInput);
            } else if (userChoice.equals("7")) {
                changePin(atm, userInput);
            } else {
                System.out.println("Invalid option. Please try again.");
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

    public static void createAccount(BankATM atm, Scanner input) {
        System.out.print("Enter your first name: ");
        String firstName = input.nextLine();
        while (firstName == null || firstName.trim().isEmpty() || !firstName.matches("[a-zA-Z\\s\\-']+")) {
            System.out.print("Invalid first name. Enter again: ");
            firstName = input.nextLine();
        }

        System.out.print("Enter your last name: ");
        String lastName = input.nextLine();
        while (lastName == null || lastName.trim().isEmpty() || !lastName.matches("[a-zA-Z\\s\\-']+")) {
            System.out.print("Invalid last name. Enter again: ");
            lastName = input.nextLine();
        }

        System.out.print("Enter your PIN: ");
        String pin = input.nextLine();
        while (pin == null || !pin.matches("\\d{4}")) {
            System.out.print("Invalid PIN. Enter again (must be 4 digits): ");
            pin = input.nextLine();
        }

        atm.createAccount(firstName, lastName, pin);
        System.out.println("Account created successfully: " + firstName.toUpperCase() + " " + lastName.toUpperCase());
    }

    public static void depositMoney(BankATM atm, Scanner input) {
        System.out.print("Enter your pin: ");
        String pin = input.nextLine();
        while (pin == null || !pin.matches("\\d{4}")) {
            System.out.print("Invalid pin. Enter again: ");
            pin = input.nextLine();
        }

        System.out.print("Enter deposit amount: ");
        while (!input.hasNextDouble()) {
            System.out.print("Invalid amount. Enter a positive number: ");
            input.nextLine();
        }
        double depositAmount = input.nextDouble();
        input.nextLine();
        while (depositAmount <= 0.0) {
            System.out.print("Invalid amount. Enter a positive number: ");
            depositAmount = input.nextDouble();
            input.nextLine();
        }

        BankAccount userAccount = atm.findAccountByPin(pin);

        if (userAccount == null) {
            System.out.println("Account not found.");
        } else {
            userAccount.deposit(pin, depositAmount);
            System.out.println("Deposit successful.");
        }
    }

    public static void withdrawMoney(BankATM atm, Scanner input) {
        System.out.print("Enter your pin: ");
        String pin = input.nextLine();
        while (pin == null || !pin.matches("\\d{4}")) {
            System.out.print("Invalid pin. Enter again: ");
            pin = input.nextLine();
        }

        System.out.print("Enter withdrawal amount: ");
        while (!input.hasNextDouble()) {
            System.out.print("Invalid amount. Enter a positive number: ");
            input.nextLine();
        }
        double withdrawalAmount = input.nextDouble();
        input.nextLine();
        while (withdrawalAmount <= 0.0) {
            System.out.print("Invalid amount. Enter a positive number: ");
            withdrawalAmount = input.nextDouble();
            input.nextLine();
        }

        BankAccount userAccount = atm.findAccountByPin(pin);

        if (userAccount == null) {
            System.out.println("Account not found.");
        } else {
            userAccount.withdraw(pin, withdrawalAmount);
            System.out.println("Withdrawal successful.");
        }
    }

    public static void checkBalance(BankATM atm, Scanner input) {
        System.out.print("Enter your pin: ");
        String pin = input.nextLine();
        while (pin == null || !pin.matches("\\d{4}")) {
            System.out.print("Invalid pin. Enter again: ");
            pin = input.nextLine();
        }

        BankAccount userAccount = atm.findAccountByPin(pin);

        if (userAccount == null) {
            System.out.println("Account not found.");
        } else {
            System.out.println("Your balance is: " + userAccount.getBalance());
        }
    }

    public static void transferMoney(BankATM atm, Scanner input) {
        System.out.print("Enter your pin: ");
        String pin = input.nextLine();
        while (pin == null || !pin.matches("\\d{4}")) {
            System.out.print("Invalid pin. Enter again: ");
            pin = input.nextLine();
        }

        System.out.print("Enter transfer amount: ");
        while (!input.hasNextDouble()) {
            System.out.print("Invalid amount. Enter a positive number: ");
            input.nextLine();
        }
        double transferAmount = input.nextDouble();
        input.nextLine();
        while (transferAmount <= 0.0 || transferAmount > atm.getAccount().getFirst().getBalance()) {
            System.out.print("Invalid amount. Enter a positive number: ");
            transferAmount = input.nextDouble();
            input.nextLine();
        }

        System.out.print("Enter receiver's account name: ");
        String receiver = input.nextLine();
        while (receiver == null || receiver.trim().isEmpty()) {
            System.out.print("Invalid receiver name. Enter again: ");
            receiver = input.nextLine();
        }

        BankAccount receiverAccount = atm.findAccountByName(receiver);
        BankAccount senderAccount = atm.findAccountByPin(pin);

        if (receiverAccount == null || senderAccount == null) {
            System.out.println("Account not found.");
        } else {
            atm.transfer(pin, senderAccount, receiverAccount, transferAmount);
            System.out.println("Transfer successful. Your balance is: " + senderAccount.getBalance());
        }
    }

    public static void closeAccount(BankATM atm, Scanner input) {
        System.out.print("Enter your PIN: ");
        String pin = input.nextLine();
        while (pin == null || !pin.matches("\\d{4}")) {
            System.out.print("Invalid PIN. Enter again (must be 4 digits): ");
            pin = input.nextLine();
        }

        System.out.print("Enter your full name: ");
        String fullName = input.nextLine();
        while (fullName == null || fullName.trim().isEmpty() || !fullName.matches("[a-zA-Z\\s\\-']+")) {
            System.out.print("Invalid full name. Enter again: ");
            fullName = input.nextLine();
        }

        BankAccount userAccount = atm.findAccountByName(fullName);

        if (userAccount == null) {
            System.out.println("Account not found.");
        } else {
            if (!userAccount.getPin().equals(pin)) {
                System.out.println("PIN does not match the account. Unable to close.");
            } else {
                userAccount.withdraw(pin, userAccount.getBalance());
                atm.closeAccount(pin, userAccount);
                System.out.println("Account closed successfully.");
            }
        }
    }

    public static void changePin(BankATM atm, Scanner input) {
        System.out.print("Enter your old PIN: ");
        String oldPin = input.nextLine();
        while (oldPin == null || !oldPin.matches("\\d{4}")) {
            System.out.print("Invalid old PIN. Enter again (must be 4 digits): ");
            oldPin = input.nextLine();
        }

        System.out.print("Enter your new PIN: ");
        String newPin = input.nextLine();
        while (newPin == null || !newPin.matches("\\d{4}") || newPin.equals(oldPin)) {
            if (newPin != null && newPin.equals(oldPin)) {
                System.out.print("New PIN must be different from the old PIN. Enter again: ");
            } else {
                System.out.print("Invalid new PIN. Enter again (must be 4 digits): ");
            }
            newPin = input.nextLine();
        }

        System.out.print("Enter your account name: ");
        String accountName = input.nextLine();
        while (accountName == null || accountName.trim().isEmpty()) {
            System.out.print("Invalid account name. Enter again: ");
            accountName = input.nextLine();
        }

        BankAccount userAccount = atm.findAccountByName(accountName);

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

