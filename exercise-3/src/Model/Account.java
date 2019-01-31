/**
 * @author baroness
 */
package Model;

import java.util.Arrays;

public class Account {
	private long creditBalance; // positive
	private long debitBalance;
	private long balance;
	private String currency;
	private long[] creditHistory;
	private long[] debitHistory;
	
	
	
	/**
	 * @param creditBalance
	 * @param debitBalance
	 * @param balance
	 * @param currency
	 * @param creditHistory
	 * @param debitHistory
	 */
	public Account(long creditBalance, long debitBalance, long balance, String currency, long[] creditHistory,
			long[] debitHistory) {
		super();
		this.creditBalance = creditBalance;
		this.debitBalance = debitBalance;
		this.balance = balance;
		this.currency = currency;
		this.creditHistory = creditHistory;
		this.debitHistory = debitHistory;
	}
	
	public Account() {
		super();
		this.creditBalance = 0;
		this.debitBalance = 0;
		this.balance = 0;
		this.currency = "";
		this.creditHistory = new long[0];
		this.debitHistory = new long[0];
	}

	public long getCreditBalance() {
		return creditBalance;
	}
	public void setCreditBalance(long creditBalance) {
		this.creditBalance = creditBalance;
	}
	public long getDebitBalance() {
		return debitBalance;
	}
	public void setDebitBalance(long debitBalance) {
		this.debitBalance = debitBalance;
	}
	public long getBalance() {
		return balance;
	}
	public void setBalance(long balance) {
		this.balance = balance;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public long[] getCreditHistory() {
		return creditHistory;
	}
	public void setCreditHistory(long[] creditHistory) {
		this.creditHistory = creditHistory;
	}
	public long[] getDebitHistory() {
		return debitHistory;
	}
	public void setDebitHistory(long[] debitHistory) {
		this.debitHistory = debitHistory;
	}
	@Override
	public String toString() {
		return "Account [creditBalance=" + creditBalance + ", debitBalance=" + debitBalance + ", balance=" + balance
				+ ", currency=" + currency + ", creditHistory=" + Arrays.toString(creditHistory) + ", debitHistory="
				+ Arrays.toString(debitHistory) + "]";
	}
	
	public void makeDebit(long amount) {
		
	}
	
	public void makeCredit(long amount) {
		
	}
	
	public long countDebits() {
		long count = 0;
		return count;
	}
	
	public long countCredits() {
		long count = 0;
		return count;
	}
	
	public long countTransactions() {
		long count = 0;
		return count;
	}
	
	public long averagingDebits() {
		long average =0;
		return average;
	}
	
	public long maxDebit() {
		long max=0;
		return max;
	}


}
