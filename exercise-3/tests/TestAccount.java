import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import Model.Account;
import java.util.Arrays;

class TestAccount {

	@Test
	@Tag("development")
	void testSetAndGetCreditHistory() {
		double[] creditHistory = {10.25, 200, 3000, 40000, 500000, 10.25, 200, 3000, 40000, 500000};
		Account acct = new Account();
		acct.setCreditHistory(creditHistory);
		assertEquals(Arrays.toString(creditHistory), Arrays.toString(acct.getCreditHistory()));
	}
	
	@Test
	@Tag("development")
	void testSetAndGetDebitHistory() {
		double[] debitHistory = {10.25, 200, 3000, 40000, 500000, 10.25, 200, 3000, 40000, 500000};
		Account acct = new Account();
		acct.setDebitHistory(debitHistory);
		assertEquals(Arrays.toString(debitHistory), Arrays.toString(acct.getDebitHistory()));
	}

	@Test
	@Tag("development")
	void testCalcNegativeBalance() {
		double[] debitHistory = {10.25, 200, 3000, 40000, 500000, 10.25, 200, 3000, 40000, 500000};
		Account acct = new Account();
		acct.setDebitHistory(debitHistory);
		assertEquals(1086420.5, acct.calcNegativeBalance());
	}

	@Test
	@Tag("development")
	void testCalcPositiveBalance() {
		double[] creditHistory = {10.25, 200, 3000, 40000, 500000, 10.25, 200, 3000, 40000, 500000};
		Account acct = new Account();
		acct.setCreditHistory(creditHistory);
		assertEquals(1086420.5, acct.calcPositiveBalance());
	}

	@Test
	@Tag("development")
	void testCalcTotalBalance() {
		double[] creditHistory = {10.25, 200, 3000, 40000, 500000, 10.25, 200, 3000, 40000, 500000};
		double[] debitHistory = {10.25, 200, 3000, 40000, 500000, 10.25, 200, 3000, 40000, 500000};
		Account acct = new Account();
		acct.setCreditHistory(creditHistory);
		acct.setDebitHistory(debitHistory);
		assertEquals(0, acct.calcTotalBalance());
	}

	@Test
	@Tag("development")
	void testMakeDebit() {
		fail("Not yet implemented");
	}

	@Test
	@Tag("development")
	void testMakeCredit() {
		fail("Not yet implemented");
	}

	@Test
	@Tag("development")
	void testRevertDebit() {
		fail("Not yet implemented");
	}

	@Test
	@Tag("development")
	void testRevertCredit() {
		fail("Not yet implemented");
	}

	@Test
	@Tag("development")
	void testCalcAverageDebit() {
		fail("Not yet implemented");
	}

	@Test
	@Tag("development")
	void testCalcHighestDebit() {
		fail("Not yet implemented");
	}

}
