import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestComposite extends TestCase {
	
	public TestComposite(String method) {
		super(method);
	}

	@Test
	static public Test suite() {
		TestSuite suite = new TestSuite();
		// add every test
		suite.addTestSuite(TestStack.class);
		// uncomment to add only tests in course requirements suite
		// suite.addTest(TestStack.suiteCourserRequirements());
		return suite;
	}

}
