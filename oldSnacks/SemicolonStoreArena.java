import java.util.Scanner;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.time.LocalDate;


public class SemicolonStoreArena{
    public static void main(String[] args) {
        
    Scanner reader = new Scanner(System.in);

ArrayList<String> items = new ArrayList<>();
ArrayList<Integer> quantity = new ArrayList<>();
ArrayList<Double> price = new ArrayList<>();
ArrayList<Double> total = new ArrayList<>();
LocalDate currentDate = LocalDate.now();

        String userBuy;
        int noOfGoods;
        double usersPrice;
        String userChoice;
        String cashierName = " ";
        double userDiscount = 0;
        double totalAmount = 0;
	double subTotals = 0;
	double subTotal = 0;

        String userBuy1;
        int noOfGoods1;
        double usersPrice1; double userPayment;

        System.out.println("What is the customer's name ? ");
        String customerName = reader.nextLine();

	while(!customerName.matches("[a-zA-Z\\s]+")){
	System.out.println("Enter a valid name");
	customerName = reader.nextLine();
	continue;
	 }

do {

        System.out.println("What did the user buy? ");
        userBuy = reader.next();
	items.add(userBuy);


        
while (true){
     try {
        System.out.println("How many pieces? ");
        noOfGoods = reader.nextInt();
	break;
    } catch (InputMismatchException e){
            System.out.println("Invalid, enter a valid input: ");
	    reader.next();
   }
}

	while(noOfGoods <= 0){
	System.out.println("How many pieces?");
	noOfGoods = reader.nextInt();		
    }
	quantity.add(noOfGoods);

        System.out.println("How much per unit?: ");
        usersPrice = reader.nextDouble();
	price.add(usersPrice);


     totalAmount = usersPrice * noOfGoods;
     total.add(totalAmount);
     subTotal = subTotal + totalAmount;

     System.out.println("Add more items?");
     userChoice = reader.nextLine();
     userChoice = reader.nextLine();


     while (!userChoice.equalsIgnoreCase("Yes") && !userChoice.equalsIgnoreCase("No")){
	System.out.println("Invalid input, choose between (Yes or No)");
	userChoice = reader.nextLine();
	continue;
    }

} while (userChoice.equalsIgnoreCase("Yes"));
            
 if(!userChoice.equalsIgnoreCase("Yes")){
     System.out.println("what is the cashier name");
     cashierName = reader.next();
			
     System.out.println("How much discount will he/she get?: ");
     userDiscount = reader.nextDouble();
     System.out.println(" ");

     subTotals = subTotal;
     double discount = (userDiscount / 100) * subTotal;
     double vat = 0.175 * subTotals;
     double billTotal = subTotals + vat - discount;


        System.out.println("\nSEMICOLON STORES");
        System.out.println("MAIN BRANCH");
        System.out.println("LOCATION: 312, HERBERT MACAULAY WAY, SABO YABA, LAGOS");
        System.out.println("TEL: 03293020343");
        System.out.println("DATE: " + currentDate);
        System.out.println("CASHIER NAME: " + cashierName);
        System.out.println("CUSTOMER NAME: " + customerName);
        
        System.out.println("==========================================================================");
        System.out.printf("\t%s\t\t%s\t\t%s\t\t%s", "ITEM", "QTY", "PRICE", "TOTAL(NGN)");
        System.out.println("\n-------------------------------------------------------------------------- ");


for(int count = 0; count < items.size(); count++){
System.out.printf("%s%14d%22.2f%22.2f%n", items.get(count), quantity.get(count), price.get(count), total.get(count));

}

     System.out.println("\n-------------------------------------------------------------------------- ");
System.out.printf("%50s\t%.2f \n%50s\t%.2f \n%50s\t%.2f", "Sub Total: ", subTotals, "Discount: ", discount, "VAT @17.50%: ", vat);
        System.out.println("\n==========================================================================");
        System.out.printf("%50s\t%.2f ", "Bill Total: ", billTotal);
        System.out.println("\n==========================================================================");
        System.out.println("\tTHIS IS NOT AN RECEIPT KINDLY PAY " + billTotal);
        System.out.println("\n==========================================================================\n");

        
        System.out.println("How much did the customer pay? ");
        userPayment = reader.nextDouble();

	while(userPayment < billTotal){
        System.out.print("Invalid amount, amount is too low: ");
        userPayment = reader.nextDouble();
	}

        double balance = userPayment - billTotal; 
        

        System.out.println("\nSEMICOLON STORES");
        System.out.println("MAIN BRANCH");
        System.out.println("LOCATION: 312, HERBERT MACAULAY WAY, SABO YABA, LAGOS");
        System.out.println("TEL: 03293020343");
        System.out.println("DATE: 4 - JAN - 25 10:45:12 PM ");
        System.out.println("CASHIER NAME: " + cashierName);
        System.out.println("CUSTOMER NAME: " + customerName);
        
        System.out.println("==========================================================================");
        System.out.printf("\t%s\t\t%s\t\t%s\t\t%s", "ITEM", "QTY", "PRICE", "TOTAL(NGN)");
        System.out.println("\n-------------------------------------------------------------------------- ");

for(int count = 0; count < items.size(); count++){
System.out.printf("%s%14d%22.2f%22.2f%n", items.get(count), quantity.get(count), price.get(count), total.get(count));

}


System.out.println("\n-------------------------------------------------------------------------- ");
        System.out.printf("%50s\t%.2f \n%50s\t%.2f \n%50s\t%.2f", "Sub Total: ", subTotal, "Discount: ", discount, "VAT @17.50%: ", vat);
        System.out.println("\n==========================================================================");
        System.out.printf("%50s\t%.2f \n%50s\t%.2f \n%50s\t%.2f", "Bill Total: ", billTotal, "Amount Paid: ", userPayment, "Balance: ", balance);
      
        System.out.println("\n==========================================================================");
        System.out.printf("%25s", "THANKS FOR YOUR PATRONAGE");
        System.out.println("\n==========================================================================");

      }
 }

}
