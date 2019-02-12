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
	/* (non-Javadoc)
	 * @see ControllerInterface#getModel()
	 */
	@Override
	public AccountInterface getModel() {
		return model;
	}
	public void setModel(AccountInterface model) {
		this.model = model;
	}
	/* (non-Javadoc)
	 * @see ControllerInterface#getView()
	 */
	@Override
	public ViewInterface getView() {
		return view;
	}
	public void setView(ViewInterface view) {
		this.view = view;
	}

	/* (non-Javadoc)
	 * @see ControllerInterface#registerDebits()
	 */
	@Override
	public int registerDebits() {
		double amount;
		do {
			amount = getView().promptDebitAmount();
			if (amount !=0) {
				getModel().makeDebit(amount);
				getView().showResults(getModel().calcTotalBalance());
			}
		} while(amount != 0);
		return getView().promptAction();
	}

	/* (non-Javadoc)
	 * @see ControllerInterface#registerCredits()
	 */
	@Override
	public int registerCredits() {
		double amount;
		do {
			amount = getView().promptCreditAmount();
			if (amount !=0) {
				getModel().makeCredit(amount);
				getView().showResults(getModel().calcTotalBalance());
			}
		} while(amount != 0);
		return getView().promptAction();
	}

	/* (non-Javadoc)
	 * @see ControllerInterface#showNegativeBalance()
	 */
	@Override
	public int showNegativeBalance() {
		getView().showNegativeBalance(getModel().calcNegativeBalance());
		getView().promptAction();
		return getView().promptAction();
	}

	/* (non-Javadoc)
	 * @see ControllerInterface#showTotalBalance()
	 */
	@Override
	public int showTotalBalance() {
		getView().showNegativeBalance(getModel().calcNegativeBalance());
		return getView().promptAction();
	}

	/* (non-Javadoc)
	 * @see ControllerInterface#showDebitAverage()
	 */
	@Override
	public int showDebitAverage() {
		getView().showDebitAverage(getModel().calcAverageDebit());
		return getView().promptAction();
	}

	/* (non-Javadoc)
	 * @see ControllerInterface#showDebitHighest()
	 */
	@Override
	public int showDebitHighest() {
		getView().showDebitHighest(getModel().calcHighestDebit());
		return getView().promptAction();
	}

	/* (non-Javadoc)
	 * @see ControllerInterface#showCounts()
	 */
	@Override
	public int showCounts() {
		getView().showCounts(getModel().getDebitHistory().length, getModel().getCreditHistory().length);
		return getView().promptAction();
	}

	/* (non-Javadoc)
	 * @see ControllerInterface#showHistories()
	 */
	@Override
	public int showHistories() {
		getView().showDebitHistory(getModel().getDebitHistory());
		getView().showCreditHistory(getModel().getCreditHistory());
		return getView().promptAction();
	}

	/* (non-Javadoc)
	 * @see ControllerInterface#revertDebit()
	 */
	@Override
	public int revertDebit() {
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
	public int revertCredit() {
		int creditId;
		do {
			creditId = getView().promptCreditId(getModel().getCreditHistory());
		} while (!(0<=creditId || creditId<=(getModel().getCreditHistory().length-1)));
		getModel().revertCredit(creditId);
		getView().showCreditHistory(getModel().getCreditHistory());
		return getView().promptAction();
	}

}
