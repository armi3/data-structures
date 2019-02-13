
public interface ViewInterface {

	/* (non-Javadoc)
	 * @see ViewInterface#getMenu()
	 */
	String getMenu();

	/* (non-Javadoc)
	 * @see ViewInterface#setMenu(java.lang.String)
	 */
	void setMenu(String menu);

	/* (non-Javadoc)
	 * @see ViewInterface#promptActionWithMenu()
	 */
	int promptActionWithMenu();

	/* (non-Javadoc)
	 * @see ViewInterface#promptAction()
	 */
	int promptAction();

	/* (non-Javadoc)
	 * @see ViewInterface#promptGeneralAmount()
	 */
	double promptGeneralAmount();

	/* (non-Javadoc)
	 * @see ViewInterface#promptDebitAmount()
	 */
	String promptItemCode();

	/* (non-Javadoc)
	 * @see ViewInterface#promptCreditAmount()
	 */
	double promptCreditAmount();

	double promptPaymentMethod();

	/* (non-Javadoc)
	 * @see ViewInterface#showResults(double)
	 */
	int showResults(double totalBalance);

	/* (non-Javadoc)
	 * @see ViewInterface#showNegativeBalance(double)
	 */
	void showNegativeBalance(double negativeBalance);

	/* (non-Javadoc)
	 * @see ViewInterface#showTotalBalance(double)
	 */
	void showTotalBalance(double totalBalance);

	/* (non-Javadoc)
	 * @see ViewInterface#showDebitAverage(double)
	 */
	void showDebitAverage(double average);

	/* (non-Javadoc)
	 * @see ViewInterface#showDebitHighest(double)
	 */
	void showDebitHighest(double highest);

	/* (non-Javadoc)
	 * @see ViewInterface#showCounts(double, double)
	 */
	void showCounts(double countDebits, double countCredits);

	/* (non-Javadoc)
	 * @see ViewInterface#showDebitHistory(double[])
	 */
	void showDebitHistory(double[][] historyDebits);

	/* (non-Javadoc)
	 * @see ViewInterface#showCreditHistory(double[])
	 */
	void showCreditHistory(double[][] historyCredits);

	/* (non-Javadoc)
	 * @see ViewInterface#promptDebitId(double[])
	 */
	int promptDebitId(double[][] historyDebits);

	/* (non-Javadoc)
	 * @see ViewInterface#promptCreditId(double[])
	 */
	int promptCreditId(double[][] historyCredits);

}