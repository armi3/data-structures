package Model;

public interface AccountInterface {

	double calcNegativeBalance();

	double calcPositiveBalance();

	double calcTotalBalance();

	void makeDebit(double itemCode, double itemPrice);

	void makeCredit(double paymentMethod, double paymentAmount);
	
	void revertDebit(int debitId);
	
	void revertCredit(int creditId);

	double calcAverageDebit();

	double calcHighestDebit();

	double[][] getDebitHistory();
	
	double[][] getCreditHistory();
	
}