import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;


class TestTaskSix {

	TaskSix sumOfEvenIndex = new TaskSix ();

	@Test
	void testToCheckElementsInEvenIndex (){
	int[] scores = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
	int actual = sumOfEvenIndex.sumOfTheEvenIndex(scores);
	int expected = 25;
	assertEquals(actual, expected);
	
   }

}