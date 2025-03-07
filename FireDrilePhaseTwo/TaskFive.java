import java.util.Scanner;

public class TaskFive {
    public static void main(String[] args) {
 
Scanner input = new Scanner(System.in);

double sum = 0;

for (int count = 0; count < 10; count++) {
  System.out.print("Enter score " + (count + 1) + ": ");
  double score = input.nextDouble();

  if (count % 2 == 0) {
    sum += score;

    }
  }

    System.out.printf("%s%.2f", "Sum of scores at even indexes: ", sum);


    }
}
