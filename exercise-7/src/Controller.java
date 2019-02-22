
public class Controller implements ControllerInterface {
	
	private PlayQueueInterface playQueue;
	private ViewInterface view;
	
	public Controller(PlayQueueInterface playQueue, ViewInterface view) {
		super();
		this.playQueue = playQueue;
		this.view = view;
	}

	@Override
	public PlayQueueInterface getPlayQueue() {
		return playQueue;
	}

	@Override
	public void setPlayQueue(PlayQueueInterface playQueue) {
		this.playQueue = playQueue;
	}
	
	@Override
	public ViewInterface getView() {
		return view;
	}

	@Override
	public void setView(ViewInterface view) {
		this.view = view;
	}

	@Override
	public int playNow(SongInterface song) {
		song.setSongInfo(getView().promptSongInfo());
		getPlayQueue().playNow(song);
		getView().showPlayQueue(getPlayQueue());
		return getView().promptAction();
	}
	
	@Override
	public int playNext(SongInterface song) {
		song.setSongInfo(getView().promptSongInfo());
		getPlayQueue().playNext(song);
		getView().showPlayQueue(getPlayQueue());
		return getView().promptAction();
	}
	
	@Override
	public int playLater(SongInterface song) {
		song.setSongInfo(getView().promptSongInfo());
		getPlayQueue().playLater(song);
		getView().showPlayQueue(getPlayQueue());
		return getView().promptAction();
	}
	
	@Override
	public int nextSong() {
		getPlayQueue().nextSong();
		getView().showPlayQueue(getPlayQueue());
		return getView().promptAction();
	}
	
	@Override
	public int previousSong() {
		getPlayQueue().previousSong();
		getView().showPlayQueue(getPlayQueue());
		return getView().promptAction();
	}
	
	@Override
	public int showPlayQueue() {
		getView().showPlayQueue(getPlayQueue());
		return getView().promptAction();
	}
	
}
