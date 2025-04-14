public class creditCardValidatorPrototype {
    public static void main(String[] args) {

        java.util.Scanner inputCardNumber = new java.util.Scanner(System.in);

        System.out.println("Hello, Kindly enter credit card detail to verify: ");
        String cardNumber = inputCardNumber.nextLine();

        while (cardNumber == null || cardNumber.trim().isEmpty() || !cardNumber.matches("[0-9]+")) {
            System.out.print("Invalid card number. Enter again: ");
            cardNumber = inputCardNumber.nextLine();
        }
        System.out.println("**********************************************");
        System.out.println(creditCardValidator.validateCreditCardType(cardNumber));
        System.out.println(creditCardValidator.getCreditCardNumber(cardNumber));
        System.out.println(creditCardValidator.checkLengthOfCard(cardNumber));
        System.out.println(creditCardValidator.validateCreditCard(cardNumber));

        System.out.println("**********************************************");

    }
}