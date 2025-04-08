import java.util.Arrays;

class UniqueElement {
	public static int[] getUniqueElement(int[] arrays, int target) {

int uniqueIndex = 0;
int index = 0;
int count = 0;


	for (int row = 0; row < arrays.length; row++){
		if (arrays[row] == target){
			count++;
		}
		}

int[] uniqueArrays = new int[arrays.length-2];
	for (int check = 0; check < arrays.length; check++){
		if (arrays[row] == target) continue;
			uniqueArrays[row] = arrays[row];	

}
	return uniqueArrays;

}

public static void main(String[] args){

int[] arrays = {1, 2, 3, 4, 3};
int target = 0;

int[] result = getUniqueElement(arrays, target);

System.out.println(Arrays.toString(result));


  }
}