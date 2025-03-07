import java.util.Arrays;
import java.util.Scanner;

public class TaskThree {
  public static void main(String[] args){

Scanner input = new Scanner(System.in);
double[] scores = new double[10];
double[] result = printArrayVertically(scores);

for (int count = 0; count < result.length; count++){
   System.out.println(result[count] + " ");
  }


}

public static double[] printArrayVertically (double[] scores){

Scanner input = new Scanner(System.in);

for (int count = 0; count < 10; count++){
System.out.print("Enter ten scores: " + (count +1) + ": ");
double score = input.nextDouble();
scores[count] = score;

   }
return scores;
 }



}