import java.util.ArrayList;

public class UniqueNumbersCheck{
  public static int[] uniqueNumbersSearch(int[] array) {

        int nums = array.length;
        int[] newArrays = new int[nums];
        int index = 0;

     for (int row = 0; row < nums; row++) {
      for (int count = 0; count < nums; count++) {
                if (row != count && array[row] == array[count]) {
                    break;
                }
            }
            newArrays[index++] = array[row];
            
        }

      int[] result = new int[index];
      return result; 
}


public static void main(String[] args) {
        int[] array = {2, 2, 1};
        int[] uniqueIndex = uniqueNumbersSearch(array);

        for (int num: uniqueIndex) {
            System.out.print(num + " ");
        }
    }
    
     }