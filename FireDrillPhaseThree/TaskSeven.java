import java.util.Arrays;
import java.util.Scanner;

public class TaskSeven {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

System.out.print("Enter the number of scores: ");
int size = input.nextInt();

int[] scores = new int[size];

System.out.println("Enter " + size + " scores:");
for (int count = 0; count < scores.length; count++) {
System.out.print("Score " + (count + 1) + ": ");
scores[count] = input.nextInt();

}

int result = sumTheOddIndex(scores);
System.out.println("Sum Is: " + result);

    }

public static int sumTheOddIndex(int[] scores) {
int check = (scores.length + 1) / 2; 
int[] newArray = new int[check];
int sum = 0;

for (int count = 1, counter = 0; count < scores.length; count += 2, counter++) {
   newArray[counter] = scores[count];
    sum += newArray[counter];
  }

        return sum;
    }
}

