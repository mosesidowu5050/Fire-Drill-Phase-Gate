import java.util.Scanner;

public class TaskFour {
  public static void main(String[] args){

Scanner input = new Scanner(System.in);

double sum = 0;
double counter = 0;


for (int count = 0; count < 10; count++){
System.out.print("Enter ten scores: " + (count +1) + ": ");
double score = input.nextDouble();

if (score % 2 == 0){
sum += score;
   }
 }

System.out.printf("%s%.2f", "Sum Is: ", sum);



   }

}