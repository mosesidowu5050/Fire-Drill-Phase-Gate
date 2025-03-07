import java.util.Arrays;
import java.util.Scanner;

public class TaskFive {
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

int[] result = elementsInTheOddIndex(scores);
System.out.println("Elements at even indices: " + Arrays.toString(result));

    }

public static int[] elementsInTheOddIndex(int[] scores) {
int check = (scores.length + 1) / 2; 
int[] newArray = new int[check];

for (int count = 1, counter = 0; count < scores.length; count += 2, counter++) {
   newArray[counter] = scores[count];
  }

        return newArray;
    }
}

