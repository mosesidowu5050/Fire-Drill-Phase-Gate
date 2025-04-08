import java.util.Arrays;

public class ArraySorting{


public static int[] reverse(int[] arrays){

int[] num = new int[arrays.length];

for(int count = 0; count < num.length; count++){

num[count] = arrays[arrays.length -1 -count];
}

return num;
}



public static void main(String[] args){

int[] list = {3,2,1,5,8,6};

int[] num = reverse(list);

System.out.print(Arrays.toString(num));
 }

}