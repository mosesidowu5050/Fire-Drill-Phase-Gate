import java.util.Scanner;

public class TaskEight {
  public static void main(String[] args){

Scanner input = new Scanner(System.in);

double sum = 0;
double counter = 0;


for (int count = 0; count < 10; count++){
System.out.print("Enter ten scores: " + (count +1) + ": ");
double score = input.nextDouble();

while (score < 0 || score > 100){
System.out.print("Score must be between (0 - 100): ");
score = input.nextDouble();

}

sum += score;

   }

System.out.printf("%s%.2f", "Sum Is: ", sum);



   }

}