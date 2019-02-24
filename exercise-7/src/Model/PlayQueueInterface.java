package Model;

public interface PlayQueueInterface {

	SongInterface getNowPlaying();

	void setNowPlaying(SongInterface nowPlaying);
	
	/*
	 * Note to assistant professor:
	 * void methods or PlayQueueInterface methods 
	 * with PlayQueueInterface as parameter?
	 * Pros/cons?
	 */
	  
	// Ends any song playing (without discarding it) and plays input
	void playNow(SongInterface song);

	// Makes input first in play queue
	void playNext(SongInterface song);

	// Makes input last in play queue
	void playLater(SongInterface song);
	
	// Ends any song playing (without discarding it) and plays next in play queue
	void nextSong();
	
	// Ends any song playing (without discarding it) and plays previous in play queue
	void previousSong();
 
	String toString();

}