import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import junit.framework.TestSuite;

class TestStack extends TestCase{
	
	public TestStack(String method) {
		super(method);
	}

	@Test
	void testGetContainedObjects() {
		fail("Not yet implemented");
	}

	@Test
	void testSetContainedObjects() {
		fail("Not yet implemented");
	}

	@Test
	void testGetDynamicSize() {
		fail("Not yet implemented");
	}

	@Test
	void testSetDynamicSize() {
		fail("Not yet implemented");
	}

	@Test
	void testIn() {
		fail("Not yet implemented");
	}

	@Test
	void testOut() {
		fail("Not yet implemented");
	}

	@Test
	void testClear() {
		fail("Not yet implemented");
	}

	@Test
	void testLook() {
		fail("Not yet implemented");
	}
	
	@Test
	void testStackOverflow() {
		
	}
	
	@Test
	void testElementsExtention() {
		
	}
	
	@Test
	void testFillThenEmpty() {
		
	}
	
	@Test
	void testEmptyStack() {
		
	}
	
	public static Test suite() {
		TestSuite suite = new TestSuite();
		suite.addTest(new TestStack("testStackOverflow"));
		suite.addTest(new TestStack("testElementsExtention"));
		suite.addTest(new TestStack("testFillThenEmpty"));
		suite.addTest(new TestStack("testEmptyStack"));
		return suite;
	}

}
