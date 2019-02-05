/**
 * @author baroness
 */
package Model;

import java.util.Arrays;

public class Account implements AccountInterface {

	private long creditBalance; // positive
	private long debitBalance;
	private double balance;
	
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
	public Account(long creditBalance, long debitBalance, double balance, String currency, long[] creditHistory,
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
	public double getBalance() {
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
		long[] copy = new long[this.creditHistory.length];
		System.arraycopy(this.creditHistory, 0, copy, 0, copy.length);
		return copy;
	}
	
	public void setCreditHistory(long[] creditHistory) {
		this.creditHistory = new long[creditHistory.length];
		System.arraycopy(creditHistory, 0, this.creditHistory, 0, creditHistory.length);
	}
	
	public long[] getDebitHistory() {
		long[] copy = new long[this.debitHistory.length];
		System.arraycopy(this.debitHistory, 0, copy, 0, copy.length);
		return copy;
	}
	public void setDebitHistory(long[] debitHistory) {
		this.debitHistory = new long[debitHistory.length];
		System.arraycopy(debitHistory, 0, this.debitHistory, 0, debitHistory.length);
	}
	@Override
	public String toString() {
		return "Account [creditBalance=" + creditBalance + ", debitBalance=" + debitBalance + ", balance=" + balance
				+ ", currency=" + currency + ", creditHistory=" + Arrays.toString(creditHistory) + ", debitHistory="
				+ Arrays.toString(debitHistory) + "]";
	}
	
	
	/* (non-Javadoc)
	 * @see Model.AccountInterface#calcNegativeBalance()
	 */
	@Override
	public long calcNegativeBalance() {
		long balance = 0;
		for (long i : this.debitHistory) {
			balance +=i;
		}
		return balance;
	}
	
	/* (non-Javadoc)
	 * @see Model.AccountInterface#calcPositiveBalance()
	 */
	@Override
	public long calcPositiveBalance() {
		long balance = 0;
		for (long i : this.creditHistory) {
			balance +=i;
		}
		return balance;
	}
	
	/* (non-Javadoc)
	 * @see Model.AccountInterface#calcTotalBalance()
	 */
	@Override
	public double calcTotalBalance() {
		double balance = (double) this.calcPositiveBalance() - (double) this.calcNegativeBalance();
		return balance;
	}
	
	/* (non-Javadoc)
	 * @see Model.AccountInterface#makeDebit(long)
	 */
	@Override
	public void makeDebit(long amount) {
		
	}
	
	/* (non-Javadoc)
	 * @see Model.AccountInterface#makeCredit(long)
	 */
	@Override
	public void makeCredit(long amount) {
		
	}
	
	/* (non-Javadoc)
	 * @see Model.AccountInterface#calcAverageDebit()
	 */
	@Override
	public long calcAverageDebit() {
		long average =0;
		return average;
	}
	
	/* (non-Javadoc)
	 * @see Model.AccountInterface#calcHighestDebit()
	 */
	@Override
	public long calcHighestDebit() {
		long max=0;
		return max;
	}


}
