import Model.*;

public class Controller implements ControllerInterface {
	private Factory factory = new Factory();
	private AccountInterface model = factory.createModel();
	private ViewInterface view = factory.createView();

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
		//getView().promptAction();
		return getView().promptAction();
	}

	/* (non-Javadoc)
	 * @see ControllerInterface#showTotalBalance()
	 */
	@Override
	public int showTotalBalance() {
		getView().showTotalBalance(getModel().calcTotalBalance());
		//getView().promptAction();
		return getView().promptAction();
	}

	/* (non-Javadoc)
	 * @see ControllerInterface#showDebitAverage()
	 */
	@Override
	public int showDebitAverage() {
		getView().showDebitAverage(getModel().calcAverageDebit());
		//getView().promptAction();
		return getView().promptAction();
	}

	/* (non-Javadoc)
	 * @see ControllerInterface#showDebitHighest()
	 */
	@Override
	public int showDebitHighest() {
		getView().showDebitHighest(getModel().calcHighestDebit());
		//getView().promptAction();
		return getView().promptAction();
	}

	/* (non-Javadoc)
	 * @see ControllerInterface#showCounts()
	 */
	@Override
	public int showCounts() {
		getView().showCounts(getModel().getDebitHistory().length, getModel().getCreditHistory().length);
		//getView().promptAction();
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
			if (debitId!=0) {
				getModel().revertDebit(debitId-1);
				getView().showResults(getModel().calcTotalBalance());
			}
		} while (debitId!=0);
		return getView().promptAction();
	}

	@Override
	public int revertCredit() {
		int creditId;
		do {
			creditId = getView().promptCreditId(getModel().getCreditHistory());
			if (creditId!=0) {
				getModel().revertCredit(creditId-1);
				getView().showResults(getModel().calcTotalBalance());
			}
		} while (creditId!=0);
		return getView().promptAction();
	}

}
