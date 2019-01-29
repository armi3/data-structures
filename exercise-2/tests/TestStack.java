import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Model.Stack;
import junit.framework.TestSuite;

class TestStack extends TestCase{
	
	public TestStack(String method) {
		super(method);
	}

	@Test
	void testGetContainedObjects() {
		String[] containedObjects = {"a", "b", "c"};
		Stack stack = new Stack(containedObjects, containedObjects.length);
		assertEquals(containedObjects, stack.getContainedObjects());
	}

	@Test
	void testSetContainedObjects() {
		String[] containedObjects = {"a", "b", "c"};
		Stack stack = new Stack(); // Load empty
		stack.setContainedObjects(containedObjects);
		assertEquals(containedObjects, stack.getContainedObjects());
	}

	@Test
	void testGetDynamicSize() {
		String[] containedObjects = {"a", "b", "c"};
		Stack stack = new Stack(containedObjects, containedObjects.length);
		assertEquals(containedObjects.length, stack.getDynamicSize());
	}

	@Test
	void testSetDynamicSize() {
		String[] containedObjects = {"a", "b", "c"};
		Stack stack = new Stack(); // Load empty
		stack.setDynamicSize(containedObjects.length);
		assertEquals(containedObjects.length, stack.getDynamicSize());
	}

	@Test
	void testIn() {
		Stack stack = new Stack(); // Load empty
		stack.in("a");
		assertEquals("a", stack[1]);
		assertEquals(1, stack.getDynamicSize());
	}

	@Test
	void testOut() {
		String[] containedObjects = {"a", "b", "c"};
		Stack stack = new Stack(containedObjects, containedObjects.length);
		assertEquals("c", stack.out());
	}

	@Test
	void testClear() {
		String[] containedObjects = {"a", "b", "c"};
		Stack stack = new Stack(containedObjects, containedObjects.length);
		stack.clear();
		assertEquals(0, stack.getDynamicSize());
	}

	@Test
	void testLook() {
		String[] containedObjects = {"a", "b", "c"};
		Stack stack = new Stack(containedObjects, containedObjects.length);
		assertEquals("c", stack.look());
		assertEquals(3, stack.getDynamicSize());
	}
	
	@Test
	void testStackOverflow() {
		fail("Not yet implemented");
	}
	
	@Test
	void testStackDynamicy() {
		fail("Not yet implemented");
	}
	
	@Test
	void testFillThenClear() {
		fail("Not yet implemented");
	}
	
	
	public static Test suiteCourseRequirements() {
		TestSuite suite = new TestSuite();
		suite.addTest(new TestStack("testStackOverflow"));
		suite.addTest(new TestStack("testStackDynamicy"));
		suite.addTest(new TestStack("testFillThenClear"));
		suite.addTest(new TestStack("testClear"));
		return suite;
	}

}
