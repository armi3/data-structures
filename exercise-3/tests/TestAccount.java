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
		Account acct = new Account();
		assertEquals(0, acct.getDebitHistory().length);
		assertEquals(0, acct.getDebitBalance());
		assertEquals(0, acct.getGeneralBalance());
		acct.makeDebit(5.33);
		assertEquals(1, acct.getDebitHistory().length);
		assertEquals(5.33, acct.getDebitBalance());
		assertEquals(-5.33, acct.getGeneralBalance());
	}

	@Test
	@Tag("development")
	void testMakeCredit() {
		Account acct = new Account();
		assertEquals(0, acct.getCreditHistory().length);
		assertEquals(0, acct.getCreditBalance());
		assertEquals(0, acct.getGeneralBalance());
		acct.makeCredit(5.33);
		assertEquals(1, acct.getCreditHistory().length);
		assertEquals(5.33, acct.getCreditBalance());
		assertEquals(5.33, acct.getGeneralBalance());
	}

	@Test
	@Tag("development")
	void testRevertDebit() {
		Account acct = new Account();
		acct.makeDebit(5.33);
		acct.revertDebit(0);
		assertEquals(0, acct.getDebitHistory().length);
		assertEquals(0, acct.getDebitBalance());
		assertEquals(0, acct.getGeneralBalance());
	}

	@Test
	@Tag("development")
	void testRevertCredit() {
		Account acct = new Account();
		acct.makeCredit(5.33);
		acct.revertCredit(0);
		assertEquals(0, acct.getCreditHistory().length);
		assertEquals(0, acct.getCreditBalance());
		assertEquals(0, acct.getGeneralBalance());
	}

	@Test
	@Tag("development")
	void testCalcAverageDebit() {
		double[] debitHistory = {10.25, 200, 3000, 40000, 500000, 10.25, 200, 3000, 40000, 500000};
		Account acct = new Account();
		acct.setDebitHistory(debitHistory);
		assertEquals(1086420.5/10, acct.calcAverageDebit());
	}

	@Test
	@Tag("development")
	void testCalcHighestDebit() {
		// case 1
		double[] debitHistory = {10.25, 200, 3000, 40000, 500000, 10.25, 200, 3000, 40000, 500000};
		Account acct = new Account();
		acct.setDebitHistory(debitHistory);
		assertEquals(500000, acct.calcHighestDebit());

		// case 2
		double[] debitHistory2 = {999, 99, 9};
		acct.setDebitHistory(debitHistory2);
		assertEquals(999, acct.calcHighestDebit());

		// case 3
		double[] debitHistory3 = {999, 99, 9, 0, 0, 999.001, -0.01, -999.3};
		acct.setDebitHistory(debitHistory3);
		assertEquals(999.001, acct.calcHighestDebit());
	}

}
