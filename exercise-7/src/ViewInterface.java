import Model.PlayQueueInterface;

public interface ViewInterface {

	String getMenu();

	int promptActionWithMenu();

	int promptAction();

	String[] promptSongInfo();

	void showPlayQueue(PlayQueueInterface playQueue);

}