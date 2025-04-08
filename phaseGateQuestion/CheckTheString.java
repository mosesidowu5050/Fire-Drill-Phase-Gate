class CheckTheString {
	public static boolean checkingSubstring(String letterOne, String letterTwo){

int firstChar = 0;
int lastCharIndex = 0;

for(int count = 0; count < letterOne.length()-1; count++){
	for(int counter = 0; counter < letterTwo.length()-1; counter++){
	if (counter > lastCharIndex){

	if ((letterTwo.charAt(count) == letterOne.charAt(count))){
	firstChar++;
	lastCharIndex = counter;

	if (firstChar >= letterTwo.length()){


	}
         }
      }
   }
  }
return true;

}


	public static void main(String[] args){

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
            if(name==null || name.trim().isEmpty() || surname==null || surname.trim().isEmpty()) {
                throw new IllegalArgumentException("Name cannot be empty");
            }
            else {
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
            if(!pin.equals(this.pin) || pin.trim().isEmpty()) {
                throw new IllegalArgumentException("Pin does not match");
            }
            if (!pin.matches("[0-9]+")) {
                throw new IllegalArgumentException("Pin must be a number");
            }
            else if (depositAmount < 0.0) {
                throw new IllegalArgumentException("Deposit amount cannot be negative");
            }
            else if (pin.equals(this.pin) && depositAmount > 0.0) {
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
            if(!pin.equals(this.pin) || pin.trim().isEmpty()) {
                throw new IllegalArgumentException("Pin does not match");
            }
            else if (!pin.matches("[0-9]+")) {
                throw new IllegalArgumentException("Pin must be a number");
            }
            else if (withdrawalAmount <= 0.0) {
                throw new IllegalArgumentException("Withdrawal amount cannot be negative");
            }
            else if (withdrawalAmount > balance) {
                throw new IllegalArgumentException("Invalid amount");
            }
            else if (pin.equals(this.pin) && withdrawalAmount <= balance) {
                this.balance -= withdrawalAmount;
            }
        }

        public void createAccount(String name, String surname, String pin) {
            if(name==null || name.trim().isEmpty() || surname==null || surname.trim().isEmpty()) {
                throw new IllegalArgumentException("First name and last name cannot be empty");
            }
            else if(pin==null || pin.trim().isEmpty()) {
                throw new IllegalArgumentException("Pin cannot be empty");
            }
            else if (!pin.matches("[0-9]+")) {
                throw new IllegalArgumentException("Pin must be a number");
            }
            else if (pin.length() != 4) {
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
            }
            else if (amount < 0.0 || amount > balance) {
                throw new IllegalArgumentException("Invalid amount");
            }
            else if(pin.equals(this.pin) && amount <= balance) {
                this.balance -= amount;
            }
        }

        public static class TestBankeBankATMMachine {

            private BankeBankATMMachine bankATM;

            @Before
            public void setUp() {
                bankATM = new BankeBankATMMachine();
            }

            @Test
            public void testThrowExceptionsIfSetNameIsEmpty() {
                assertThrows(IllegalArgumentException.class, () -> {
                    bankATM.setName(null, null);
                });
            }

            @Test
            public void testThrowExceptionsIfGetNameIsEmpty() {
                assertThrows(IllegalArgumentException.class, () -> {
                    bankATM.setName("", "");
                });
            }

            @Test
            public void testIfATMSetFirstNameAndLastNameWorksPerfectly() {
                bankATM.setName("Ayo", "Adenuga");
                assertEquals("Ayo Adenuga", bankATM.getName());
            }

            @Test
            public void testIfGetNameWorksPerfectly() {
                bankATM.setName("Ayo", "Adenuga");
                assertEquals("Ayo Adenuga", bankATM.getName());
            }

            @Test
            public void testThrowExceptionsIfPinIsEmpty() {
                assertThrows(IllegalArgumentException.class, () -> {
                    bankATM.setPin(null);
                });
            }

            @Test
            public void testThrowExceptionsIfPinIsNotNumber() {
                assertThrows(IllegalArgumentException.class, () -> {
                    bankATM.setPin("12FT");
                });
            }

            @Test
            public void testThrowExceptionsIfPinIsMoreThanFourDigits() {
                assertThrows(IllegalArgumentException.class, () -> {
                    bankATM.setPin("1234567");
                });
            }

            @Test
            public void testThrowExceptionsIfSetPinDoesNotMatch() {
                assertThrows(IllegalArgumentException.class, () -> {
                    bankATM.setPin("1234");
                    bankATM.deposit("1321", 2500.00);
                });
            }

            @Test
            public void testThrowExceptionsIfPinContainsStrings() {
                assertThrows(IllegalArgumentException.class, () -> {
                    bankATM.setPin("1234");
                    bankATM.deposit("T3U5", 2500.00);
                });
            }

            @Test
            public void testThrowsExceptionsIfSetPinIsEmpty() {
                assertThrows(IllegalArgumentException.class, () -> {
                    bankATM.setPin("1234");
                    bankATM.deposit("PinCode cannot be empty", 2500.00);
                });
            }

            @Test
            public void testThrowExceptionsIfDepositIsNegative() {
                assertThrows(IllegalArgumentException.class, () -> {
                    bankATM.deposit("1321", -2500.00);
                });
            }

            @Test
            public void testThatCheckIfPinIsValidAndDepositAmountIsPositive() {
                bankATM.setPin("1234");
                bankATM.deposit("1234", 2500.00);
                assertEquals(2500.00, bankATM.getBalance(), 0.01);
            }

            @Test
            public void testThatDepositWorksPerfectly() {
                bankATM.setPin("1234");
                bankATM.deposit("1234", 2500.00);
                assertEquals(2500.00, bankATM.getBalance(), 0.01);
            }

            @Test
            public void testThatThrowExceptionsIfWithdrawPinDoesNotMatch() {
                assertThrows(IllegalArgumentException.class, () -> {
                    bankATM.setPin("1234");
                    bankATM.deposit("1334", 500.00);
                });
            }

            @Test
            public void testThatThrowExceptionsIfWithdrawPinContainsStrings() {
                assertThrows(IllegalArgumentException.class, () -> {
                    bankATM.setPin("1234");
                    bankATM.deposit("T3U5", 500.00);
                });
            }

            @Test
            public void testThatThrowExceptionsIfWithdrawPinIsEmpty() {
                assertThrows(IllegalArgumentException.class, () -> {
                    bankATM.setPin("1234");
                    bankATM.deposit("PinCode cannot be empty", 500.00);
                });
            }

            @Test
            public void testThatThrowExceptionsIfWithdrawAmountIsInvalidAndGreaterThanTheBalance() {
                assertThrows(IllegalArgumentException.class, () -> {
                    bankATM.setPin("1234");
                    bankATM.deposit("1234", 3000.00);
                    bankATM.withdraw("1234", 5000.00);
                });
            }

            @Test
            public void testThatThatThrowExceptionIfWithdrawAmountIsNegative() {
                assertThrows(IllegalArgumentException.class, () -> {
                   bankATM.setPin("1234");
                   bankATM.deposit("1234", 3500.00);
                   bankATM.withdraw("1234", -3500.00);
                });
            }
            @Test
            public void testThatCheckIfWithdrawWorksPerfectly() {
                bankATM.setPin("1234");
                bankATM.deposit("1234", 2500.00);
                bankATM.withdraw("1234", 500.00);
                assertEquals(2000.00, bankATM.getBalance(), 0.01);
            }
            @Test
            public void testThatThrowExceptionsIfCreateAccountFirstNameAndLastNameAreEmpty() {
                assertThrows(IllegalArgumentException.class, () -> {
                    bankATM.setPin("1234");
                    bankATM.createAccount(null, null, "1234");
                });
            }
            @Test
            public void testThatThrowExceptionsIfCreateAccountPinIsEmpty() {
                assertThrows(IllegalArgumentException.class, () -> {
                    bankATM.setPin("1234");
                    bankATM.createAccount(null, null, null);
                });
            }
            @Test
            public void testThatThrowExceptionsIfCreateAccountPinContainsStrings() {
                assertThrows(IllegalArgumentException.class, () -> {
                    bankATM.setPin("1234");
                    bankATM.createAccount(null, null, "12TY");
                });
            }
            @Test
            public void testThatThrowExceptionsIfCreateAccountPinExceedsMaximumLength() {
                assertThrows(IllegalArgumentException.class, () -> {
                    bankATM.setPin("1234");
                    bankATM.createAccount(null, null, "123456");
                });
            }
            @Test
            public void testThatCheckIfATMMachineCreateAccountWorkPerfectly() {
                bankATM.createAccount("Ayo", "Adenuga", "1234");
                assertEquals("Account created successfully for Ayo Adenuga", bankATM.getAccount());
            }
            @Test
            public void testThatThrowExceptionIfAccountIsEmpty() {
                assertThrows(IllegalArgumentException.class, () -> {
                    bankATM.createAccount(null, null, "1234");
                    assertEquals("Account details are incomplete", bankATM.getAccount());
                });
            }
            @Test
            public void testThatThrowExceptionIfPinIsInvalidAndAccountNumberIsEmpty() {
                assertThrows(IllegalArgumentException.class, () -> {
                    bankATM.setPin("1234");
                    bankATM.transfer("", "", 3000.00);
                });
            }
            @Test
            public void testThatThrowExceptionIfTransferAmountIsGreaterThanTheBalance(){
                assertThrows(IllegalArgumentException.class, ()-> {
                   bankATM.setPin("1234");
                   bankATM.deposit("1234", 3500.00);
                   bankATM.transfer("1234", "3077664421", 5000.00);
                });
            }
            @Test
            public void testThatThrowExceptionIfTransferAmountIsNegative(){
                assertThrows(IllegalArgumentException.class, ()-> {
                   bankATM.setPin("1234");
                   bankATM.deposit("1234", 1200.00);
                   bankATM.transfer("1234", "3077664421", -200);
                });
            }
            @Test
            public void testThatTransferWorksPerfectly() {
                bankATM.setPin("1234");
                bankATM.deposit("1234", 5000.00);
                bankATM.transfer("1234", "3077664421", 3500.00);
                assertEquals(1500.00, bankATM.getBalance(), 0.01);
            }
        }
    }
}
