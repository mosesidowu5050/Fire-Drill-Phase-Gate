import java.util.Scanner;

public class TaskSix {
  public static void main(String[] args){

Scanner input = new Scanner(System.in);

double sum = 0;
double counter = 0;


for (int count = 0; count < 10; count++){
System.out.print("Enter ten scores: " + (count +1) + ": ");
double score = input.nextDouble();
counter++;

if (score % 2 == 0){
sum += score;
   }
 }

double average = sum / counter;

System.out.printf("%s%.2f", "Average Is: ", average);



   }

}