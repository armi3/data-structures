import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

class MainTest {

	@Test
	void test() {
		Main main = new Main();
		assertEquals(0, main.getQuadrant(0, 0));
		assertEquals(1, main.getQuadrant(20.01, 1));
		assertEquals(2, main.getQuadrant(-999.999, 1.1));
		assertEquals(3, main.getQuadrant(-20.2, -10.66));
		assertEquals(4, main.getQuadrant(10.1, -454.4));
		assertEquals(0, main.getQuadrant(-342.22, 0));
		assertEquals(0, main.getQuadrant(0, -323.3));
	}

}
