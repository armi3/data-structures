
public class Main {

	public static void main(String[] args) {
		Factory factory = new Factory();
		ControllerInterface controller = factory.createController(
				factory.createPlayQueue(factory.createSong()), 
				factory.createView());

		int menuChoice = 0;
		do{
			switch(menuChoice) {
			case 0:
				menuChoice = controller.getView().promptActionWithMenu();
				break;
			case 1:
				menuChoice = controller.playNow(factory.createSong());
				break;
			case 2:
				menuChoice = controller.playNext(factory.createSong());
				break;
			case 3:
				menuChoice = controller.playLater(factory.createSong());
				break;
			case 4:
				menuChoice = controller.nextSong();
				break;
			case 5:
				menuChoice = controller.previousSong();
				break;
			case 6:
				menuChoice = controller.showPlayQueue();
				break;
			case 8:
				menuChoice = controller.getView().promptAction();
				break;
			}

		} while(!String.valueOf(menuChoice).equals("7"));
		System.exit(0);

	}

}
