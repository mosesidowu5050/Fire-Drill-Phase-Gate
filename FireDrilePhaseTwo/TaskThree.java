import java.util.Scanner;

public class TaskThree {
  public static void main(String[] args){

Scanner input = new Scanner(System.in);

double sum = 0;
double counter = 0;


for (int count = 0; count < 10; count++){
System.out.print("Enter ten scores: " + (count +1) + ": ");
double score = input.nextDouble();
counter++;

sum += score;
 }

  double average = sum / counter;

System.out.printf("%s%.2f%n%s%.2f", "Sum Is: ", sum, "Average Is: ", average);




   }

}