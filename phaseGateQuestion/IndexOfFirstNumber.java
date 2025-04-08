import java.util.Arrays;

class IndexOfFirstNumber{
	public static int[] getIndexNumber(int[] arrays, int target) {

int uniqueIndex = arrays[0];
int count = 0;

	for (int row = 0; row < arrays.length; row++){
	//for (int check = 0; check < arrays.length; check++){
		if (arrays[row] < arrays[check+1]){
}
		uniqueIndex = row;

}
	return new int[] {uniqueIndex};

}

public static void main(String[] args){

int[] arrays = {1, 0, 0, 2, 3};

int[] result = getIndexNumber(arrays);

System.out.println(Arrays.toString(result));


  }
}