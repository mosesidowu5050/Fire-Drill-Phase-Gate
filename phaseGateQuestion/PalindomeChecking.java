class PalindomeChecking {
    static boolean getTheConfirmPalindrome(int number) {
        
int reverse = 0;
int exactInput = number;
		
        while (exactInput != 0) {
            reverse = reverse * 10 + exactInput % 10;
            exactInput = exactInput / 10;
        }
     
        return (reverse == number);
    }

  public static void main(String[] args) {

int number = 40754;
if (getTheConfirmPalindrome(number)) {

System.out.println("true");
        }
else {
            System.out.println("false");
        }
    }
}