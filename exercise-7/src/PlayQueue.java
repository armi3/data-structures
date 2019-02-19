
public class PlayQueue implements PlayQueueInterface {
	
	private Song nowPlaying;
	
	@Override
	public Song getNowPlaying() {
		return nowPlaying;
	}

	@Override
	public void setNowPlaying(Song nowPlaying) {
		this.nowPlaying = nowPlaying;
	}

	@Override
	public PlayQueueInterface playNow(PlayQueueInterface playQueue, Song song) {
		return playQueue;
	}
	
	@Override
	public PlayQueueInterface playNext(PlayQueueInterface playQueue, Song song) {
		return playQueue;
	}
	
	@Override
	public PlayQueueInterface playLater(PlayQueueInterface playQueue, Song song) {
		return playQueue;
	}

	@Override
	public String toString() {
		return "PlayQueue [nowPlaying=" + nowPlaying + "]";
	}

}
