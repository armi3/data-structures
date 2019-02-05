package Model;

public interface AccountInterface {

	long calcNegativeBalance();

	long calcPositiveBalance();

	double calcTotalBalance();

	void makeDebit(long amount);

	void makeCredit(long amount);

	long calcAverageDebit();

	long calcHighestDebit();

}