import java.util.Scanner;

public class TaskNine {
  public static void main(String[] args){

Scanner input = new Scanner(System.in);

double sum = 0;
double counter = 0;


for (int count = 0; count < 10; count++){
System.out.print("Enter ten scores: " + (count +1) + ": ");
double score = input.nextDouble();

if (score < 0 || score > 100){
System.out.println("Invalid score: ");

} else if (score >= 0 || score <= 100){
     sum += score;
  }
  
 }

System.out.printf("%s%.2f", "Sum of all valid scores is: ", sum);



   }

}