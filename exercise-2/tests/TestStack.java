import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

import Model.Stack;
import java.util.Arrays;

class TestStack {

	@Test
	@Tag("development")
	void testGetContainedObjects() {
		String[] containedObjects = {"a", "b", "c"};
		Stack stack = new Stack(containedObjects, containedObjects.length); 
		assertEquals(Arrays.toString(containedObjects), Arrays.toString(stack.getContainedObjects()));
		//assertTrue(stack.getContainedObjects().equals(containedObjects)); 
	}

	@Test
	@Tag("development")
	void testSetContainedObjects() {
		String[] containedObjects = {"a", "b", "c"};
		Stack stack = new Stack(); // Load empty
		stack.setContainedObjects(containedObjects);
		assertEquals(Arrays.toString(containedObjects), Arrays.toString(stack.getContainedObjects()));
	}

	@Test
	@Tag("development")
	void testGetDynamicSize() {
		String[] containedObjects = {"a", "b", "c"};
		Stack stack = new Stack(containedObjects, containedObjects.length);
		assertEquals(containedObjects.length, stack.getDynamicSize());
	}

	@Test
	@Tag("development")
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
		assertEquals("a", stack.getContainedObjects()[1]);
		assertEquals(1, stack.getDynamicSize());
	}

	@Test
	@Tag("development")
	void testOut() {
		String[] containedObjects = {"a", "b", "c"};
		Stack stack = new Stack(containedObjects, containedObjects.length);
		assertEquals("c", stack.out());
	}

	@Test
	@Tag("development")
	void testClear() {
		String[] containedObjects = {"a", "b", "c"};
		Stack stack = new Stack(containedObjects, containedObjects.length);
		stack.clear();
		assertEquals(0, stack.getDynamicSize());
	}

	@Test
	@Tag("development")
	void testLook() {
		String[] containedObjects = {"a", "b", "c"};
		Stack stack = new Stack(containedObjects, containedObjects.length);
		assertEquals("c", stack.look());
		assertEquals(3, stack.getDynamicSize());
	}
	
	@Test
	@Tag("requirement")
	void testStackDynamicy() {
		String[] containedObjects = {"a", "b", "c"};
		Stack stack = new Stack(containedObjects, containedObjects.length);
		assertEquals(3, stack.getDynamicSize());
		stack.in("d");
		assertEquals(4, stack.getDynamicSize());
	}
	
	@Test
	@Tag("requirement")
	void testFillThenClear() {
		String[] containedObjects = {"a", "b", "c"};
		Stack stack = new Stack(containedObjects, containedObjects.length);
		assertEquals(Arrays.toString(containedObjects), Arrays.toString(stack.getContainedObjects()));
		stack.clear();
		String[] emptyArray = {};
		assertEquals(Arrays.toString(emptyArray), Arrays.toString(stack.getContainedObjects()));
	}

}
