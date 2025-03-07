import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;


class TestTaskFour {

	TaskFour elementInEvenIndex = new TaskFour();

	@Test
	void testToCheckElementsInEvenIndex (){
	int[] scores = new int[10];
	int[] actual = elementInEvenIndex.elementsInTheEvenIndex(scores);
	int[] expected = {1, 3, 5, 7, 9};
	assertArrayEquals(actual, expected);
	
   }

}