import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;


class TestTaskOne {

	TaskOne collectScore = new TaskOne();

	@Test
	void testToCheckIfArrayCollectedScore(){
	double[] actual = new double[10];
	double[] expected = collectScore.collectTenScore(actual);
	//double[] expected = {1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0};
	assertArrayEquals(actual, expected);
	
   }

}