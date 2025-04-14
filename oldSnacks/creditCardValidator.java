public class creditCardValidator {


    public static String isValidCreditCard(String visaCardNumber) {
        if (visaCardNumber.length() < 13 || visaCardNumber.length() > 16);
        return "Invalid card number";
    }

    public static String getCreditCardNumber(String visaCardNumber) {
        return "**Credit Card Number: " + visaCardNumber + "";
    }

    public static String checkLengthOfCard(String cardNumber) {
        if (cardNumber == null || cardNumber.trim().isEmpty()) {
            return "Invalid card number";
        }
        return "**Credit Card Digit Length: " + cardNumber.length() + " ";
    }

    public static int sumDoubleDigits(String visaCardNumber) {
        int doubleNumber = 0;
        int sumOfDoubleDigits = 0;

        if (visaCardNumber == null || visaCardNumber.trim().isEmpty()) {
            return 0;
        }
        for (int looping = visaCardNumber.length() - 2; looping >= 0; looping -= 2) {
            int digit = Integer.parseInt(String.valueOf(visaCardNumber.charAt(looping)));
            doubleNumber = digit * 2;

            if (doubleNumber > 9) {
                doubleNumber -= 9;
            }
            sumOfDoubleDigits += doubleNumber;
        }
        return sumOfDoubleDigits;
    }


    public static int sumDigitsAtOddPosition(String visaCardNumber) {
        int addDigitsAtOddPosition = 0;

        for (int looping = visaCardNumber.length() - 1; looping >= 0; looping--) {
            if (looping % 2 != 0) {
                int digit = Integer.parseInt(String.valueOf(visaCardNumber.charAt(looping)));
                addDigitsAtOddPosition += digit;
            }
        }
        return addDigitsAtOddPosition;
    }


    public static int sumOfBothDigit(String visaCardNumber) {
        int sumTotalDigits = 0;
        sumTotalDigits = sumDigitsAtOddPosition(visaCardNumber) + (sumDoubleDigits(visaCardNumber));

        return sumTotalDigits;
    }


    public static String validateCreditCard(String visaCardNumber) {

        if (sumOfBothDigit(visaCardNumber) % 10 == 0) {
            return "**Credit Card Validity Status: Valid";
        } else {
            return "**Credit Card Validity Status: Invalid";
        }
    }

    public static String validateCreditCardType(String visaCardNumber) {
        for (int looping = 0; looping <= visaCardNumber.length(); looping++) {
            if (visaCardNumber.charAt(0) == '4') {
                return "**Credit Card Type: VisaCard";
            }
            else if (visaCardNumber.charAt(0) == '5') {
                return "**Credit Card Type: MasterCard";
            }
            else if (visaCardNumber.charAt(0) == '3' && visaCardNumber.charAt(1) == '7') {
                return "**Credit Card Type: American Express Card";
            }
            else if (visaCardNumber.charAt(0) == '6') {
                return "**Credit Card Type: Discover Card";
            }
        }
        return "**Credit Card Type: Invalid";
    }
}

