import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;


class TestTaskFive {

	TaskFive elementInOddIndex = new TaskFive();

	@Test
	void testToCheckElementsInEvenIndex (){
	int[] scores = new int[10];
	int[] actual = elementInOddIndex.elementsInTheOddIndex(scores);
	int[] expected = {2, 4, 6, 8, 10};
	assertArrayEquals(actual, expected);
	
   }

}