import Model.AccountInterface;

public interface ControllerInterface {

	AccountInterface getModel();

	ViewInterface getView();

	int registerDebits();

	int registerCredits();

	int showNegativeBalance();

	int showTotalBalance();

	int showDebitAverage();

	int showDebitHighest();

	int showCounts();

	int showHistories();

	int revertDebit();

	int revertCredit();

}