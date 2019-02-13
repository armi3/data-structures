import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class View implements ViewInterface {

	private String menu = "\n" +
			"------------- Main menu ------------- \n" +
			"0. Repeat menu \n" +
			"1. Add item(s) to shopping cart\n" + 
			"2. Register payment(s)\n" +
			"3. Show total of shopping cart\n" +
			"4. Show balance payable\n" +
			"5. Show items average price\n" +
			"6. Show highest item price\n" +
			"7. Print receipt\n"+
			"8. Revert item(s)\n" +
			"9. Revert payment(s)\n" +
			"10. Exit\n" +
			"\nInput action (0-10): ";

	@Override
	public String getMenu() {
		return menu;
	}

	@Override
	public void setMenu(String menu) {
		this.menu = menu;
	}

	@Override
	public int promptActionWithMenu() {
		int menuChoice =11;
		Scanner sc = new Scanner(System.in);
		System.out.print(getMenu());
		try {
			menuChoice = Integer.parseInt(sc.next(Pattern.compile("^([0-9]|10|11)$")));
		} 
		catch (InputMismatchException e) {
			System.out.print("\nInvalid input.");
		}
		return menuChoice;
	}

	@Override
	public int promptAction() {
		int menuChoice;
		Scanner sc = new Scanner(System.in);
		System.out.print("\nInput action (1-10) or 0 for menu: ");
		try {
			menuChoice = Integer.parseInt(sc.next(Pattern.compile("^([0-9]|10|11|12)$")));
		} 
		catch (InputMismatchException e) {
			System.out.print("\nInput action (1-10) or 0 for menu: ");
			menuChoice = 11;
		}
		return menuChoice;
	}


	@Override
	public double promptGeneralAmount() {
		double amount =0;
		Scanner sc = new Scanner(System.in);
		try {
			amount = Double.parseDouble(sc.next(Pattern.compile("^\\d+([,\\.]\\d{1,2})?$")));
		} 
		catch (InputMismatchException e) {
			System.out.print("\nInvalid input.");
		}
		return amount;
	}
	
	@Override
	public String promptItemCode() {
		System.out.print("\nEnter item ID (or '0' for summary): ");
		String itemCode = "";
		Scanner sc = new Scanner(System.in);
		try {
			itemCode = sc.next(Pattern.compile("(\\d{9}|0{1})"));
		}
		catch (InputMismatchException e) {
			System.out.print("\nInvalid input.");
		}
		return itemCode;
	}
	
	/* (non-Javadoc)
	 * @see ViewInterface#promptCreditAmount()
	 */
	/* (non-Javadoc)
	 * @see ViewInterface#promptCreditAmount()
	 */
	@Override
	public double promptCreditAmount() {
		System.out.print("\nEnter amount to credit (or '0' for summary): ");
		double amount = promptGeneralAmount();
		return amount;
	}
	
	/* (non-Javadoc)
	 * @see ViewInterface#promptPaymentMethod()
	 */
	@Override
	public double promptPaymentMethod() {
		System.out.print("\nAvailable methods: cash (1) credit card (2) paypal (3).");
		System.out.print("\nEnter payment method (or '0' for summary): ");
		double method=0;
		Scanner sc = new Scanner(System.in);
		try {
			method = Double.parseDouble(sc.next(Pattern.compile("([0-3]){1}")));
		} 
		catch (InputMismatchException e) {
			System.out.print("\nInvalid input.");
		}
		return method;
	}
	
	/* (non-Javadoc)
	 * @see ViewInterface#showResults(double)
	 */
	/* (non-Javadoc)
	 * @see ViewInterface#showResults(double)
	 */
	@Override
	public int showResults(double totalBalance) {
		System.out.print("\nSuccesful transaction!" + "\nUpdated total balance: " + totalBalance);
		int goBack = 0;
		return goBack;
	}
	
	/* (non-Javadoc)
	 * @see ViewInterface#showNegativeBalance(double)
	 */
	/* (non-Javadoc)
	 * @see ViewInterface#showNegativeBalance(double)
	 */
	@Override
	public void showNegativeBalance(double negativeBalance) {
		System.out.println("\nThis cart's total price is: " + negativeBalance);
	}
	
	/* (non-Javadoc)
	 * @see ViewInterface#showTotalBalance(double)
	 */
	/* (non-Javadoc)
	 * @see ViewInterface#showTotalBalance(double)
	 */
	@Override
	public void showTotalBalance(double totalBalance) {
		System.out.print("\nThis account's current balance payable is: " + totalBalance);
	}
	
	/* (non-Javadoc)
	 * @see ViewInterface#showDebitAverage(double)
	 */
	/* (non-Javadoc)
	 * @see ViewInterface#showDebitAverage(double)
	 */
	@Override
	public void showDebitAverage(double average) {
		System.out.print("\nThis cart's average item price is: " + average);
	}
	
	/* (non-Javadoc)
	 * @see ViewInterface#showDebitHighest(double)
	 */
	/* (non-Javadoc)
	 * @see ViewInterface#showDebitHighest(double)
	 */
	@Override
	public void showDebitHighest(double highest) {
		System.out.print("\nThis cart's highest item price is: " + highest);
	}
	
	/* (non-Javadoc)
	 * @see ViewInterface#showCounts(double, double)
	 */
	/* (non-Javadoc)
	 * @see ViewInterface#showCounts(double, double)
	 */
	@Override
	public void showCounts(double countDebits, double countCredits) {
		System.out.print("\nThis account has registered " + countDebits + " debits and " + countCredits + " credits.");
	}
	
	/* (non-Javadoc)
	 * @see ViewInterface#showDebitHistory(double[])
	 */
	/* (non-Javadoc)
	 * @see ViewInterface#showDebitHistory(double[][])
	 */
	@Override
	public void showDebitHistory(double[][] historyDebits) {
		System.out.print("\nThis carts's current item history (code/price) is: " + Arrays.deepToString(historyDebits));
	}
	
	/* (non-Javadoc)
	 * @see ViewInterface#showCreditHistory(double[])
	 */
	/* (non-Javadoc)
	 * @see ViewInterface#showCreditHistory(double[][])
	 */
	@Override
	public void showCreditHistory(double[][] historyCredits) {
		System.out.print("\nThis account's current credit history (amount/method) is: " + Arrays.deepToString(historyCredits));
	}
	
	/* (non-Javadoc)
	 * @see ViewInterface#promptDebitId(double[])
	 */
	/* (non-Javadoc)
	 * @see ViewInterface#promptDebitId(double[][])
	 */
	@Override
	public int promptDebitId(double[][] historyDebits) {
		showDebitHistory(historyDebits);
		System.out.print("\nEnter index of debit to be reverted: ");
		return (int) promptGeneralAmount();
	}
	
	/* (non-Javadoc)
	 * @see ViewInterface#promptCreditId(double[])
	 */
	/* (non-Javadoc)
	 * @see ViewInterface#promptCreditId(double[][])
	 */
	@Override
	public int promptCreditId(double[][] historyCredits) {
		showCreditHistory(historyCredits);
		System.out.print("\nEnter index of credit to be reverted: ");
		return (int) promptGeneralAmount();
	}

}
