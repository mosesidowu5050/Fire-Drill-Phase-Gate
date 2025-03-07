import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;


class TestTaskTwo {

	TaskTwo collectScore = new TaskTwo();

	@Test
	void testToCheckIfArrayCollectedIsPrintedVertically(){
	double[] scores = new double[10];
	double[] actual = collectScore.printArrayVertically(scores);
	double[] expected = {1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0};
	assertArrayEquals(actual, expected);
	
   }

}