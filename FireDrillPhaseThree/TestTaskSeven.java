import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;


class TestTaskSeven {

	TaskSeven sumInOddIndex = new TaskSeven();

	@Test
	void testToCheckElementsInEvenIndex (){
	int[] scores = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
	int actual = sumInOddIndex.sumTheOddIndex(scores);
	int expected = 30;
	assertEquals(actual, expected);
	
   }

}