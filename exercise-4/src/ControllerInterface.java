import Model.AccountInterface;

public interface ControllerInterface {

	AccountInterface getModel();

	ViewInterface getView();

	int addToCart();

	int registerPayment();

	int showCartTotal();

	int showBalancePayable();

	int showItemAverage();

	int showItemHighest();

	int printReceipt();

	int revertItem();

	int revertPayment();

}