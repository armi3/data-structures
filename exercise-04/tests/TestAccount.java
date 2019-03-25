import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Model.Account;

class TestAccount {

	@Test
	void testCalcNegativeBalance() {
		double[][] debitHistory = {
				{235427520, 10.25}, 
				{235427520, 200},
				{235427065, 3000}, 
				{227520065, 40000}, 
				{278436947, 500000}, 
				{278436947, 10.25}, 
				{278436947, 200}};
		Account acct = new Account();
		acct.setDebitHistory(debitHistory);
		assertEquals(543420.5, acct.calcNegativeBalance());
	}

	@Test
	void testCalcPositiveBalance() {
		double[][] creditHistory = {
				{1, 10.25}, 
				{2, 200},
				{3, 3000}, 
				{1, 40000}, 
				{2, 500000}, 
				{3, 10.25}, 
				{1, 200}};
		Account acct = new Account();
		acct.setCreditHistory(creditHistory);
		assertEquals(543420.5, acct.calcPositiveBalance());
	}

	@Test
	void testCalcTotalBalance() {
		double[][] debitHistory = {
				{235427520, 10.25}, 
				{235427520, 200},
				{235427065, 3000}, 
				{227520065, 40000}, 
				{278436947, 500000}, 
				{278436947, 10.25}, 
				{278436947, 200}};
		double[][] creditHistory = {
				{1, 10.25}, 
				{2, 200},
				{3, 3000}, 
				{1, 40000}, 
				{2, 500000}, 
				{3, 10.25}, 
				{1, 200}};
		Account acct = new Account();
		acct.setCreditHistory(creditHistory);
		acct.setDebitHistory(debitHistory);
		assertEquals(0, acct.calcTotalBalance());
	}

	@Test
	void testMakeDebit() {
		Account acct = new Account();
		// before
		assertEquals(0, acct.getDebitHistory().length);
		assertEquals(0, acct.getDebitBalance());
		assertEquals(0, acct.getGeneralBalance());
		
		acct.makeDebit(123456789, 50.33);
		
		// after debit
		assertEquals(1, acct.getDebitHistory().length);
		assertEquals(50.33, acct.getDebitBalance());
		assertEquals(-50.33, acct.getGeneralBalance());
	}

	@Test
	void testMakeCredit() {
		Account acct = new Account();
		// before
		assertEquals(0, acct.getDebitHistory().length);
		assertEquals(0, acct.getDebitBalance());
		assertEquals(0, acct.getGeneralBalance());
		
		acct.makeCredit(123456789, 50.33);
		
		// after credit
		assertEquals(1, acct.getCreditHistory().length);
		assertEquals(50.33, acct.getCreditBalance());
		assertEquals(50.33, acct.getGeneralBalance());
	}

	@Test
	void testRevertDebit() {
		Account acct = new Account();
		acct.makeDebit(123456789, 5.33);
		acct.revertDebit(0);
		assertEquals(0, acct.getDebitHistory().length);
		assertEquals(0, acct.getDebitBalance());
		assertEquals(0, acct.getGeneralBalance());
	}

	@Test
	void testRevertCredit() {
		Account acct = new Account();
		acct.makeCredit(1, 5.33);
		acct.revertCredit(0);
		assertEquals(0, acct.getCreditHistory().length);
		assertEquals(0, acct.getCreditBalance());
		assertEquals(0, acct.getGeneralBalance());
	}

	@Test
	void testCalcAverageDebit() {
		double[][] debitHistory = {
				{235427520, 10.25}, 
				{235427520, 200},
				{235427065, 3000}, 
				{227520065, 40000}, 
				{278436947, 500000}, 
				{278436947, 10.25}, 
				{278436947, 200}};
		Account acct = new Account();
		acct.setDebitHistory(debitHistory);
		assertEquals((543420.5/7), acct.calcAverageDebit());
	}

	@Test
	void testCalcHighestDebit() {
		double[][] debitHistory = {
				{235427520, 10.25}, 
				{235427520, 200},
				{235427065, 3000}, 
				{227520065, 40000}, 
				{278436947, 500000}, 
				{278436947, 10.25}, 
				{278436947, 200}};
		Account acct = new Account();
		acct.setDebitHistory(debitHistory);
		assertEquals(500000, acct.calcHighestDebit());
	}

}
