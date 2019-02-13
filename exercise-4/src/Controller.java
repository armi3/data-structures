import java.util.Arrays;

import Model.*;

public class Controller implements ControllerInterface {
	private Factory factory = new Factory();
	private AccountInterface model = factory.createModel();
	private ViewInterface view = factory.createView();
	private CatalogInterface catalog = factory.createCatalog();

	public Factory getFactory() {
		return factory;
	}
	public void setFactory(Factory factory) {
		this.factory = factory;
	}
	@Override
	public AccountInterface getModel() {
		return model;
	}
	public void setModel(AccountInterface model) {
		this.model = model;
	}
	@Override
	public ViewInterface getView() {
		return view;
	}
	public void setView(ViewInterface view) {
		this.view = view;
	}
	public CatalogInterface getCatalog() {
		return catalog;
	}
	public void setCatalog(CatalogInterface catalog) {
		this.catalog = catalog;
	}	


	@Override
	public int addToCart() {
		String itemCode ="";
		double itemPrice=0;
		boolean validCode = false;

		do {
			itemCode = getView().promptItemCode();
			if (!itemCode.equals("0")) {
				for(int i =0; i < getCatalog().getProducts().length; i++) {
					if (getCatalog().getProducts()[i][0].equals(itemCode)) {
						getModel().makeDebit(Double.parseDouble(itemCode), Double.parseDouble(getCatalog().getProducts()[i][2]));
						getView().showResults(getModel().calcTotalBalance());
					}	
				}
			}
		} while(!itemCode.equals("0"));
		return getView().promptAction();
	}

	/* (non-Javadoc)
	 * @see ControllerInterface#registerCredits()
	 */
	@Override
	//	public int registerPayment() {
	//		double amount;
	//		do {
	//			amount = getView().promptCreditAmount();
	//			if (amount !=0) {
	//				getModel().makeCredit(amount);
	//				getView().showResults(getModel().calcTotalBalance());
	//			}
	//		} while(amount != 0);
	//		return getView().promptAction();
	//	}

	public int registerPayment() {
		double amount =0;
		double method =0;

		do {
			method = getView().promptPaymentMethod();
			if (method !=0) {
				do {
					amount = getView().promptCreditAmount();
					if (amount !=0) {
						getModel().makeCredit(method, amount);
						getView().showResults(getModel().calcTotalBalance());
					}
				} while(amount != 0);
			}
		} while(amount != 0);
		return getView().promptAction();
	}

	/* (non-Javadoc)
	 * @see ControllerInterface#showNegativeBalance()
	 */
	@Override
	public int showCartTotal() {
		getView().showNegativeBalance(getModel().calcNegativeBalance());
		return getView().promptAction();
	}

	/* (non-Javadoc)
	 * @see ControllerInterface#showTotalBalance()
	 */
	@Override
	public int showBalancePayable() {
		getView().showNegativeBalance(getModel().calcNegativeBalance());
		return getView().promptAction();
	}

	/* (non-Javadoc)
	 * @see ControllerInterface#showDebitAverage()
	 */
	@Override
	public int showItemAverage() {
		getView().showDebitAverage(getModel().calcAverageDebit());
		return getView().promptAction();
	}

	/* (non-Javadoc)
	 * @see ControllerInterface#showDebitHighest()
	 */
	@Override
	public int showItemHighest() {
		getView().showDebitHighest(getModel().calcHighestDebit());
		return getView().promptAction();
	}

	/* (non-Javadoc)
	 * @see ControllerInterface#printReceipt()
	 */
	@Override
	public int printReceipt() {
		getView().showDebitHistory(getModel().getDebitHistory());
		getView().showCreditHistory(getModel().getCreditHistory());
		return getView().promptAction();
	}

	/* (non-Javadoc)
	 * @see ControllerInterface#revertDebit()
	 */
	@Override
	public int revertItem() {
		int debitId;
		do {
			debitId = getView().promptDebitId(getModel().getDebitHistory());
		} while (!(0<=debitId || debitId<=(getModel().getDebitHistory().length-1)));
		getModel().revertDebit(debitId);
		getView().showDebitHistory(getModel().getDebitHistory());
		return getView().promptAction();
	}

	/* (non-Javadoc)
	 * @see ControllerInterface#revertCredit()
	 */
	@Override
	public int revertPayment() {
		int creditId;
		do {
			creditId = getView().promptCreditId(getModel().getCreditHistory());
		} while (!(0<=creditId || creditId<=(getModel().getCreditHistory().length-1)));
		getModel().revertCredit(creditId);
		getView().showCreditHistory(getModel().getCreditHistory());
		return getView().promptAction();
	}

}
