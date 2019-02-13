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
				menuChoice = controller.addToCart();
				break;
			case 2:
				menuChoice = controller.registerPayment();
				break;
			case 3:
				menuChoice = controller.showCartTotal();
				break;
			case 4:
				menuChoice = controller.showBalancePayable();
				break;
			case 5:
				menuChoice = controller.showItemAverage();
				break;
			case 6:
				menuChoice = controller.showItemHighest();
				break;
			case 7:
				menuChoice = controller.printReceipt();
				break;
			case 8:
				menuChoice = controller.revertItem();
				break;
			case 9:
				menuChoice = controller.revertPayment();
				break;
			case 11:
				menuChoice = controller.getView().promptAction();
				break;
			}

		} while(!String.valueOf(menuChoice).equals("10"));
		System.exit(0);

	}

}
