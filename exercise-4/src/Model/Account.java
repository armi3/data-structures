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
	private double[][] creditHistory;
	private double[][] debitHistory;

	public Account() {
		super();
		this.currency = "";
		this.creditBalance = 0;
		this.debitBalance = 0;
		this.generalBalance = 0;
		this.creditHistory = new double[0][2];
		this.debitHistory = new double[0][2];
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
	public double[][] getCreditHistory() {
		double[][] copy = new double[this.creditHistory.length][2];
		System.arraycopy(this.creditHistory, 0, copy, 0, copy.length);
		return copy;
	}
	public void setCreditHistory(double[][] creditHistory) {
		this.creditHistory = new double[creditHistory.length][2];
		System.arraycopy(creditHistory, 0, this.creditHistory, 0, creditHistory.length);
	}
	public double[][] getDebitHistory() {
		double[][] copy = new double[this.debitHistory.length][2];
		System.arraycopy(this.debitHistory, 0, copy, 0, copy.length);
		return copy;
	}
	public void setDebitHistory(double[][] debitHistory) {
		this.debitHistory = new double[debitHistory.length][2];
		System.arraycopy(debitHistory, 0, this.debitHistory, 0, debitHistory.length);
	}

	
	/* (non-Javadoc)
	 * @see Model.AccountInterface#calcNegativeBalance()
	 */
	@Override
	public double calcNegativeBalance() {
		double balance = 0;
//		for (double[] h : getDebitHistory()) {
//			for (double i : h) {
//				balance +=i;
//			}
//		}
		for (int i = 0; i < getDebitHistory().length; i++) {
			balance += getDebitHistory()[i][1];
		}
		return balance;
	}
	
	/* (non-Javadoc)
	 * @see Model.AccountInterface#calcPositiveBalance()
	 */
	@Override
	public double calcPositiveBalance() {
		double balance = 0;
//		for (double[] h : getCreditHistory()) {
//			for (double i : h) {
//				balance +=i;
//			}
//		}
		for (int i = 0; i < getCreditHistory().length; i++) {
			balance += getCreditHistory()[i][1];
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
	public void makeDebit(double itemCode, double itemPrice) {
		// register the transaction
		double[][] updatedDebitHistory = new double[getDebitHistory().length +1][2];
		System.arraycopy(getDebitHistory(), 0, updatedDebitHistory, 0, getDebitHistory().length);
		
		updatedDebitHistory[getDebitHistory().length][0]= itemCode;
		updatedDebitHistory[getDebitHistory().length][1]= itemPrice;
		setDebitHistory(updatedDebitHistory);
		
		// update balance
		setDebitBalance(calcNegativeBalance());
		setGeneralBalance(calcTotalBalance());
	}
	
	/* (non-Javadoc)
	 * @see Model.AccountInterface#makeCredit(double)
	 */
	@Override
	public void makeCredit(double paymentMethod, double paymentAmount) {
		// register the transaction
		double[][] updatedCreditHistory = new double[getCreditHistory().length +1][2];
		System.arraycopy(getCreditHistory(), 0, updatedCreditHistory, 0, getCreditHistory().length);
		
		updatedCreditHistory[getCreditHistory().length][0]=paymentMethod;
		updatedCreditHistory[getCreditHistory().length][1]=paymentAmount;
		setCreditHistory(updatedCreditHistory);
		
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
		double[][] updatedDebitHistory = new double[getDebitHistory().length-1][2];
		System.arraycopy(getDebitHistory(), 0, updatedDebitHistory, 0, debitId);
		System.arraycopy(getDebitHistory(), debitId+1, updatedDebitHistory, debitId, updatedDebitHistory.length-debitId);
		setDebitHistory(updatedDebitHistory);

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
		double[][] updatedCreditHistory = new double[getCreditHistory().length-1][2];
		System.arraycopy(getCreditHistory(), 0, updatedCreditHistory, 0, creditId);
		System.arraycopy(getCreditHistory(), creditId+1, updatedCreditHistory, creditId, updatedCreditHistory.length-creditId);
		setCreditHistory(updatedCreditHistory);

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
		double max = getDebitHistory()[0][1]; 
	    for(int i = 1; i < getDebitHistory().length; i++){ 
	      if(getDebitHistory()[i][1] > max){ 
	         max = getDebitHistory()[i][1]; 
	      } 
	    } 
	    return max;
	}
	
}
