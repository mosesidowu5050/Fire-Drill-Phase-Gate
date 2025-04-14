import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class creditCardValidatorTest {

    @Test
    public void testThatCheckTheLengthOfCreditCardNumber() {
        String visaCardNumber = "4388576018402626";
        String expectedLength = creditCardValidator.checkLengthOfCard(visaCardNumber);
        assertEquals("**Credit Card Digit Length: 16 ", expectedLength);
    }

    @Test
    public void testThrowExceptionIfTheCardNumberIsNullOrEmpty() {
        String visaCardNumber = "";
        String expectedOne = creditCardValidator.checkLengthOfCard(null);
        String expectedTwo = creditCardValidator.checkLengthOfCard(visaCardNumber);
        assertEquals("Invalid card number", expectedOne);
        assertEquals("Invalid card number", expectedTwo);
    }
    @Test
    public void testThatGetCreditCardNumber() {
        String visaCardNumber = "4388576018402626";
        String expectedCardNumber = creditCardValidator.getCreditCardNumber(visaCardNumber);
        assertEquals("**Credit Card Number: 4388576018402626", expectedCardNumber);
    }
    @Test
    public void testThatThrowExceptionIfTheCardLengthIsLessThanThirteenGreaterThanSixteen() {
        String visaCardNumber = "43885760402";
        String visaCardNumberTwo = "567784388576018402";
        String expectedOne = creditCardValidator.isValidCreditCard(visaCardNumber);
        String expectedTwo = creditCardValidator.isValidCreditCard(visaCardNumberTwo);
        assertEquals("Invalid card number", expectedOne);
        assertEquals("Invalid card number", expectedTwo);
    }

    @Test
    public void testThatDoubleEverySecondDigitsFromRightToLeft() {
        String visaCardNumber = "4388576018402626";
        int sumOfDoubleDigits = creditCardValidator.sumDoubleDigits(visaCardNumber);
        assertEquals(37, sumOfDoubleDigits);
    }

    @Test
    public void testThatCheckTheSumOfDigitsAtOddPositions(){
        String visaCardNumber = "4388576018402626";
        int sumOfDoubleDigits = creditCardValidator.sumDigitsAtOddPosition(visaCardNumber);
        assertEquals(38, sumOfDoubleDigits);
    }
    @Test
    public void testThatSumOfBothDoubleDigitsAndSumOfOddPosition(){
        String visaCardNumber = "4388576018402626";
        String visaCardNumberTwo = "5668792370303604";
        int expectedSumOfDoubleDigits = creditCardValidator.sumOfBothDigit(visaCardNumber);
        int expectedSumOfDoubleDigitsTwo = creditCardValidator.sumOfBothDigit(visaCardNumberTwo);
        assertEquals(75, expectedSumOfDoubleDigits);
        assertEquals(66, expectedSumOfDoubleDigitsTwo);
    }
    @Test
    public void testToValidateCreditTypeVisaCard() {
        String visaCardNumber = "43885760402626";
        String cardType = creditCardValidator.validateCreditCardType(visaCardNumber);
        assertEquals("**Credit Card Type: VisaCard", cardType);
    }
    @Test
    public void testToValidateCreditTypeMasterCard() {
        String visaCardNumber = "53885760402626";
        String cardType = creditCardValidator.validateCreditCardType(visaCardNumber);
        assertEquals("**Credit Card Type: MasterCard", cardType);
    }
    @Test
    public void testToValidateCreditTypeAmericanExpressCard() {
        String visaCardNumber = "3748576040262671";
        String cardType = creditCardValidator.validateCreditCardType(visaCardNumber);
        assertEquals("**Credit Card Type: American Express Card", cardType);
    }
    @Test
    public void testToValidateCreditTypeDiscoverCard() {
        String visaCardNumber = "6408857160402626";
        String cardType = creditCardValidator.validateCreditCardType(visaCardNumber);
        assertEquals("**Credit Card Type: Discover Card", cardType);
    }
    @Test
    public void testToValidateCreditTypeInvalid() {
        String visaCardNumber = "2208857160402626";
        String cardType = creditCardValidator.validateCreditCardType(visaCardNumber);
        assertEquals("**Credit Card Type: Invalid", cardType);
    }

}
