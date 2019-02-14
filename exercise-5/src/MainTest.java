import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

class MainTest {

	@Test
	void testSortbyColumn() {
		Main main = new Main();
		int[][] originalMat = {
				{1, 66}, 
				{2, 55},
				{3, 77}, 
				{4, 0}, 
				{5, 500000}, 
				{6, 10}, 
				{7, 200}};
		int[][] expectedMat = {
				{5, 500000},
				{7, 200},
				{3, 77},
				{1, 66}, 
				{2, 55},
				{6, 10},
				{4, 0}};
		int [][] sortedMat = main.sortbyColumn(originalMat, 1);
		assertEquals(Arrays.deepToString(expectedMat), Arrays.deepToString(sortedMat));
	}

}
