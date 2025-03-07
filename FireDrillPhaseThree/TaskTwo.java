import java.util.Arrays;
import java.util.Scanner;

public class TaskTwo {
  public static void main(String[] args){

Scanner input = new Scanner(System.in);
double[] scores = new double[10];
double[] result = printArrayVertically(scores);
System.out.print(Arrays.toString(result));

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