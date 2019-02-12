
public interface ViewInterface {

	String getMenu();

	void setMenu(String menu);

	int promptActionWithMenu();

	int promptAction();

	double promptGeneralAmount();

	double promptDebitAmount();

	double promptCreditAmount();

	int showResults(double totalBalance);

	void showNegativeBalance(double negativeBalance);

	void showTotalBalance(double totalBalance);

	void showDebitAverage(double average);

	void showDebitHighest(double highest);

	void showCounts(double countDebits, double countCredits);

	void showDebitHistory(double[] historyDebits);

	void showCreditHistory(double[] historyCredits);

	int promptDebitId(double[] historyDebits);

	int promptCreditId(double[] historyCredits);

}