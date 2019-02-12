import Model.*;

public class Main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Factory factory = new Factory();
		ControllerInterface controller = factory.createController();

		int menuChoice = 0;
		do{
			switch(menuChoice) {
			case 0:
				menuChoice = controller.getView().promptActionWithMenu();
				break;
			case 1:
				menuChoice = controller.registerDebits();
				break;
			case 2:
				menuChoice = controller.registerCredits();
				break;
			case 3:
				menuChoice = controller.showNegativeBalance();
				break;
			case 4:
				menuChoice = controller.showTotalBalance();
				break;
			case 5:
				menuChoice = controller.showDebitAverage();
				break;
			case 6:
				menuChoice = controller.showDebitHighest();
				break;
			case 7:
				menuChoice = controller.showCounts();
				break;
			case 8:
				menuChoice = controller.showHistories();
				break;
			case 9:
				menuChoice = controller.revertDebit();
				break;
			case 10:
				menuChoice = controller.revertCredit();
				break;
			case 12:
				menuChoice = controller.getView().promptAction();
				break;
			}

		} while(!String.valueOf(menuChoice).equals("11"));
		System.exit(0);

	}

}
