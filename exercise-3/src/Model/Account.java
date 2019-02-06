/**
 * @author baroness
 */
package Model;
import java.util.Arrays;

public class Account implements AccountInterface {
	
	private String currency;
	private double creditBalance; // positive
	private double debitBalance;
	private double generalBalance;
	private double[] creditHistory;
	private double[] debitHistory;
	
	// case 1: new non-empty acct
	public Account(String currency, double initialCredit, double initialDebit) {
		super();
		this.currency = currency;
		this.creditBalance = initialCredit;
		this.debitBalance = initialDebit;
		this.generalBalance = initialCredit-initialDebit;
		double[] creditHistory = {initialCredit};
		this.creditHistory = creditHistory;
		double[] debitHistory = {initialDebit};
		this.debitHistory = debitHistory;
	}
	
	// case 2: new empty acct
	public Account() {
		super();
		this.currency = "";
		this.creditBalance = 0;
		this.debitBalance = 0;
		this.generalBalance = 0;
		this.creditHistory = new double[0];
		this.debitHistory = new double[0];
	}
	public double getCreditBalance() {
		return creditBalance;
	}
	public void setCreditBalance(double creditBalance) {
		this.creditBalance = creditBalance;
	}
	public double getDebitBalance() {
		return debitBalance;
	}
	public void setDebitBalance(double debitBalance) {
		this.debitBalance = debitBalance;
	}
	public double getGeneralBalance() {
		return generalBalance;
	}
	public void setGeneralBalance(double generalBalance) {
		this.generalBalance = generalBalance;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public double[] getCreditHistory() {
		double[] copy = new double[this.creditHistory.length];
		System.arraycopy(this.creditHistory, 0, copy, 0, copy.length);
		return copy;
	}
	public void setCreditHistory(double[] creditHistory) {
		this.creditHistory = new double[creditHistory.length];
		System.arraycopy(creditHistory, 0, this.creditHistory, 0, creditHistory.length);
	}
	public double[] getDebitHistory() {
		double[] copy = new double[this.debitHistory.length];
		System.arraycopy(this.debitHistory, 0, copy, 0, copy.length);
		return copy;
	}
	public void setDebitHistory(double[] debitHistory) {
		this.debitHistory = new double[debitHistory.length];
		System.arraycopy(debitHistory, 0, this.debitHistory, 0, debitHistory.length);
	}
	@Override
	public String toString() {
		return "Account [creditBalance=" + getCreditBalance() + ", debitBalance=" + getDebitBalance() + ", generalBalance=" + getGeneralBalance()
				+ ", currency=" + getCurrency() + ", creditHistory=" + Arrays.toString(getCreditHistory()) + ", debitHistory="
				+ Arrays.toString(getDebitHistory()) + "]";
	}
	
	
	/* (non-Javadoc)
	 * @see Model.AccountInterface#calcNegativeBalance()
	 */
	@Override
	public double calcNegativeBalance() {
		double balance = 0;
		for (double i : getDebitHistory()) {
			balance +=i;
		}
		return balance;
	}
	
	/* (non-Javadoc)
	 * @see Model.AccountInterface#calcPositiveBalance()
	 */
	@Override
	public double calcPositiveBalance() {
		double balance = 0;
		for (double i : getCreditHistory()) {
			balance +=i;
		}
		return balance;
	}
	
	/* (non-Javadoc)
	 * @see Model.AccountInterface#calcTotalBalance()
	 */
	@Override
	public double calcTotalBalance() {
		return (this.calcPositiveBalance()-this.calcNegativeBalance());
	}
	
	/* (non-Javadoc)
	 * @see Model.AccountInterface#makeDebit(double)
	 */
	@Override
	public void makeDebit(double amount) {
		// register the transaction
		double[] updatedDebitHistory = new double[getDebitHistory().length +1];
		System.arraycopy(getDebitHistory(), 0, updatedDebitHistory, 0, getDebitHistory().length);
		updatedDebitHistory[getDebitHistory().length]=amount;
		
		// update balance
		setDebitBalance(calcNegativeBalance());
		setGeneralBalance(calcTotalBalance());
	}
	
	/* (non-Javadoc)
	 * @see Model.AccountInterface#makeCredit(double)
	 */
	@Override
	public void makeCredit(double amount) {
		// register the transaction
		double[] updatedCreditHistory = new double[getCreditHistory().length +1];
		System.arraycopy(getCreditHistory(), 0, updatedCreditHistory, 0, getCreditHistory().length);
		updatedCreditHistory[getCreditHistory().length]=amount;
		
		// update balance
		setCreditBalance(calcPositiveBalance());
		setGeneralBalance(calcTotalBalance());
	}
	
	/* (non-Javadoc)
	 * @see Model.AccountInterface#revertDebit()
	 */
	@Override
	public void revertDebit(int debitId) {
		// register the transaction
		double[] updatedDebitHistory = new double[getDebitHistory().length-1];
		System.arraycopy(getDebitHistory(), 0, updatedDebitHistory, 0, debitId);
		System.arraycopy(getDebitHistory(), debitId+1, updatedDebitHistory, debitId, updatedDebitHistory.length-debitId);

		// update balance
		setDebitBalance(calcNegativeBalance());
		setGeneralBalance(calcTotalBalance());
	}
	
	/* (non-Javadoc)
	 * @see Model.AccountInterface#revertCredit()
	 */
	@Override
	public void revertCredit(int creditId){
		// register the transaction
		double[] updatedCreditHistory = new double[getCreditHistory().length-1];
		System.arraycopy(getCreditHistory(), 0, updatedCreditHistory, 0, creditId);
		System.arraycopy(getCreditHistory(), creditId+1, updatedCreditHistory, creditId, updatedCreditHistory.length-creditId);

		// update balance
		setCreditBalance(calcPositiveBalance());
		setGeneralBalance(calcTotalBalance());
	}
	
	/* (non-Javadoc)
	 * @see Model.AccountInterface#calcAverageDebit()
	 */
	@Override
	public double calcAverageDebit() {
		double average = calcNegativeBalance()/getDebitHistory().length;
		return average;
	}
	
	/* (non-Javadoc)
	 * @see Model.AccountInterface#calcHighestDebit()
	 */
	@Override
	public double calcHighestDebit() {
		double max = getDebitHistory()[0]; 
	    for(int i = 1; i < getDebitHistory().length; i++){ 
	      if(getDebitHistory()[i] > max){ 
	         max = getDebitHistory()[i]; 
	      } 
	    } 
	    return max;
	}
	
}
