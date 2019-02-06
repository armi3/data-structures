package Model;

public interface AccountInterface {

	double calcNegativeBalance();

	double calcPositiveBalance();

	double calcTotalBalance();

	void makeDebit(double amount);

	void makeCredit(double amount);
	
	void revertDebit(int debitId);
	
	void revertCredit(int creditId);

	double calcAverageDebit();

	double calcHighestDebit();
	
}