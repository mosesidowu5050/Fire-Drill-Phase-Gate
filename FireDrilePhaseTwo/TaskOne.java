import java.util.Scanner;

public class TaskOne {
  public static void main(String[] args){

Scanner input = new Scanner(System.in);

int sum = 0;


for (int count = 0; count < 10; count++){
System.out.print("Enter ten scores: " + (count +1) + ": ");
int score = input.nextInt();
sum += score;

 }

System.out.print("Sum Is: " + sum);




   }

}