
public interface PlayQueueInterface {

	Song getNowPlaying();

	void setNowPlaying(Song nowPlaying);

	PlayQueueInterface playNow(PlayQueueInterface playQueue, Song song);

	PlayQueueInterface playNext(PlayQueueInterface playQueue, Song song);

	PlayQueueInterface playLater(PlayQueueInterface playQueue, Song song);

	String toString();

}