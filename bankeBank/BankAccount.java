import java.util.Objects;

public class BankAccount {
    private String firstName;
    private String lastName;
    private String pin;
    private double balance;

    public BankAccount(String firstName, String lastName, String pin) {
        if(firstName == null || firstName.isEmpty() || lastName == null || lastName.isEmpty() || pin == null || pin.isEmpty()){
            throw new IllegalArgumentException("Name cannot be empty");
        }
        if (!isValidPin(pin)){
            throw new IllegalArgumentException("Pin is not valid");
        }
        this.firstName = firstName;
        this.lastName = lastName;
        this.pin = pin;
        this.balance = 0.0;
    }
    public double getBalance() {
        return balance;
    }

    public String getName() {
        return firstName + " " + lastName;
    }

    public void validatePin(String pin) {
        if(!pin.equals(this.pin)){
            throw new IllegalArgumentException("PIN does not match");
        }
    }

    public static boolean isValidPin(String pin) {
        return pin != null && pin.matches("\\d{4}");
    }

    public void deposit(String pin, double depositAmount) {
        validatePin(pin);
        if(depositAmount <= 0.0){
            throw new IllegalArgumentException("Invalid deposit amount");
        }
        this.balance += depositAmount;
    }

    public void withdraw(String pin, double withdrawalAmount) {
        validatePin(pin);
        if(withdrawalAmount <= 0.0 || withdrawalAmount > balance){
            throw new IllegalArgumentException("Amount cannot be negative");
        }
        this.balance -= withdrawalAmount;
    }

    public void transfer(String pin, BankAccount receiver, double transferAmount) {
        withdraw(pin, transferAmount);
        receiver.deposit(receiver.pin, transferAmount);
    }

    public void changePin(String oldPin, String newPin) {
        if (!this.pin.equals(oldPin)) {
           throw new IllegalArgumentException("Old pin is not valid");
        }
        if (newPin == null || newPin.isEmpty()) {
            throw new IllegalArgumentException("New pin cannot be empty");
        }
        if (newPin.equals(oldPin)) {
            throw new IllegalArgumentException("New pin cannot be the same as the old pin");
        } else {
            this.pin = newPin;
        }
    }

    public String getPin() {
        if (this.pin.isEmpty()) {
            throw new IllegalArgumentException("PIN cannot be empty");
        }
        return this.pin;
    }
}
