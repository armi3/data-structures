import Model.PlayQueueInterface;
import Model.SongInterface;

public interface ControllerInterface {

	PlayQueueInterface getPlayQueue();

	void setPlayQueue(PlayQueueInterface playQueue);

	ViewInterface getView();

	void setView(ViewInterface view);

	int playNow(SongInterface song);

	int playNext(SongInterface song);

	int playLater(SongInterface song);

	int nextSong();

	int previousSong();

	int showPlayQueue();

}