class CheckTheString {
    public static boolean checkingSubstring(String letterOne, String letterTwo) {

        int firstChar = 0;
        int lastCharIndex = 0;

        for (int count = 0; count < letterOne.length() - 1; count++) {
            for (int counter = 0; counter < letterTwo.length() - 1; counter++) {
                if (counter > lastCharIndex) {

                    if ((letterTwo.charAt(count) == letterOne.charAt(count))) {
                        firstChar++;
                        lastCharIndex = counter;

                        if (firstChar >= letterTwo.length()) {


                        }
                    }
                }
            }
        }
        return true;

    }


    public static void main(String[] args) {

        String letterOne = "ABCD";
        String letterTwo = "BDC";

        Boolean results = checkingSubstring(letterOne, letterTwo);

        System.out.print(results);

    }

    public static class BankeBankATMMachine {
        private String firstName;
        private String lastName;
        private String pin;
        private double balance;


        public BankeBankATMMachine() {
            this.balance = 0.0;
        }

        public void setName(String name, String surname) {
            if (name == null || name.trim().isEmpty() || surname == null || surname.trim().isEmpty()) {
                throw new IllegalArgumentException("Name cannot be empty");
            } else {
                this.firstName = name;
                this.lastName = surname;
            }
        }

        public String getName() {
            if (firstName.trim().isEmpty() || lastName.trim().isEmpty()) {
                throw new IllegalArgumentException("Name is empty");
            }
            return firstName + " " + lastName;

        }

        public void setPin(String pinCode) {
            if (pinCode == null || pinCode.trim().isEmpty()) {
                throw new IllegalArgumentException("PinCode cannot be empty");
            }
            if (!pinCode.matches("[0-9]+")) {
                throw new IllegalArgumentException("PinCode must be a number");
            }
            if (pinCode.length() != 4) {
                throw new IllegalArgumentException("PinCode must be 4 digits");
            }
            this.pin = pinCode;
        }


        public void deposit(String pin, double depositAmount) {
            if (!pin.equals(this.pin) || pin.trim().isEmpty()) {
                throw new IllegalArgumentException("Pin does not match");
            }
            if (!pin.matches("[0-9]+")) {
                throw new IllegalArgumentException("Pin must be a number");
            } else if (depositAmount < 0.0) {
                throw new IllegalArgumentException("Deposit amount cannot be negative");
            } else if (pin.equals(this.pin) && depositAmount > 0.0) {
                this.balance += depositAmount;
            }
        }

        public double getBalance() {
            if (balance == 0) {
                return 0;
            }
            return balance;
        }

        public void withdraw(String pin, double withdrawalAmount) {
            if (!pin.equals(this.pin) || pin.trim().isEmpty()) {
                throw new IllegalArgumentException("Pin does not match");
            } else if (!pin.matches("[0-9]+")) {
                throw new IllegalArgumentException("Pin must be a number");
            } else if (withdrawalAmount <= 0.0) {
                throw new IllegalArgumentException("Withdrawal amount cannot be negative");
            } else if (withdrawalAmount > balance) {
                throw new IllegalArgumentException("Invalid amount");
            } else if (pin.equals(this.pin) && withdrawalAmount <= balance) {
                this.balance -= withdrawalAmount;
            }
        }

        public void createAccount(String name, String surname, String pin) {
            if (name == null || name.trim().isEmpty() || surname == null || surname.trim().isEmpty()) {
                throw new IllegalArgumentException("First name and last name cannot be empty");
            } else if (pin == null || pin.trim().isEmpty()) {
                throw new IllegalArgumentException("Pin cannot be empty");
            } else if (!pin.matches("[0-9]+")) {
                throw new IllegalArgumentException("Pin must be a number");
            } else if (pin.length() != 4) {
                throw new IllegalArgumentException("Pin must be 4 digits");
            }
            this.firstName = name;
            this.lastName = surname;
            this.pin = pin;
        }

        public String getAccount() {
            if (firstName == null || firstName.trim().isEmpty() || lastName == null || lastName.trim().isEmpty()) {
                throw new IllegalArgumentException("Account details are incomplete");
            }
            return "Account created successfully for " + firstName + " " + lastName;
        }

        public void transfer(String pin, String accountNumber, double amount) {
            if (!pin.equals(this.pin) || accountNumber.trim().isEmpty()) {
                throw new IllegalArgumentException("Pin does not match");
            } else if (amount < 0.0 || amount > balance) {
                throw new IllegalArgumentException("Invalid amount");
            } else if (pin.equals(this.pin) && amount <= balance) {
                this.balance -= amount;
            }
        }
    }
}