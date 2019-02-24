import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import Model.*;

class TestPlayQueue {
	/*
	 * Note to assistant professor:
	 * void methods or PlayQueueInterface methods 
	 * with PlayQueueInterface as parameter?
	 * Pros/cons?
	 */
	Factory factory = new Factory();

	@Test
	void testPlayNow() {
		PlayQueueInterface playQueue = factory.createPlayQueue(factory.createSong());
		// before method
		assertEquals(null, playQueue.getNowPlaying().getPreviousSong());
		assertEquals(null, playQueue.getNowPlaying().getNextSong());
		
		// case 1 (0 songs -> 1 song)
		playQueue.playNow(factory.createSong());
		assertEquals(playQueue.getNowPlaying(), playQueue.getNowPlaying().getPreviousSong());
		assertEquals(playQueue.getNowPlaying(), playQueue.getNowPlaying().getNextSong());
		
		// case 2 (1 song -> 2 songs)
		playQueue.playNow(factory.createSong());
		assertEquals(playQueue.getNowPlaying().getNextSong(), playQueue.getNowPlaying().getPreviousSong());
		assertEquals(playQueue.getNowPlaying().getPreviousSong(), playQueue.getNowPlaying().getNextSong());
		
		// case 3 (2 songs -> 3 songs)
		SongInterface song = factory.createSong();
		playQueue.playNow(song);
		assertEquals(song, playQueue.getNowPlaying());
	}

	@Test
	void testPlayNext() {
		PlayQueueInterface playQueue = factory.createPlayQueue(factory.createSong());
		// before method
		assertEquals(null, playQueue.getNowPlaying().getPreviousSong());
		assertEquals(null, playQueue.getNowPlaying().getNextSong());
		
		// case 1 (0 songs -> 1 song)
		playQueue.playNext(factory.createSong());
		assertEquals(playQueue.getNowPlaying(), playQueue.getNowPlaying().getPreviousSong());
		assertEquals(playQueue.getNowPlaying(), playQueue.getNowPlaying().getNextSong());
		
		// case 2 (1 song -> 2 songs)
		playQueue.playNext(factory.createSong());
		assertEquals(playQueue.getNowPlaying().getNextSong(), playQueue.getNowPlaying().getPreviousSong());
		assertEquals(playQueue.getNowPlaying().getPreviousSong(), playQueue.getNowPlaying().getNextSong());
		
		// case 3 (2 songs ->3 songs)
		SongInterface song = factory.createSong();
		playQueue.playNext(song);
		assertEquals(song, playQueue.getNowPlaying().getNextSong());
	}

	@Test
	void testPlayLater() {
		PlayQueueInterface playQueue = factory.createPlayQueue(factory.createSong());
		// before method
		assertEquals(null, playQueue.getNowPlaying().getPreviousSong());
		assertEquals(null, playQueue.getNowPlaying().getNextSong());
		
		// case 1 (0 songs -> 1 song)
		playQueue.playLater(factory.createSong());
		assertEquals(playQueue.getNowPlaying().getNextSong(), playQueue.getNowPlaying().getPreviousSong());
		assertEquals(playQueue.getNowPlaying().getPreviousSong(), playQueue.getNowPlaying().getNextSong());
		
		// case 2 (1 song -> 2 songs)
		playQueue.playLater(factory.createSong());
		assertEquals(playQueue.getNowPlaying().getNextSong(), playQueue.getNowPlaying().getPreviousSong());
		assertEquals(playQueue.getNowPlaying().getPreviousSong(), playQueue.getNowPlaying().getNextSong());
		
		// case 3 (2 songs -> 3 songs)
		SongInterface song = factory.createSong();
		playQueue.playLater(song);
		assertEquals(song, playQueue.getNowPlaying().getNextSong().getNextSong());
	}

	@Test
	void testNextSong() {
		PlayQueueInterface playQueue = factory.createPlayQueue(factory.createSong());
		// before method
		assertEquals(null, playQueue.getNowPlaying().getPreviousSong());
		assertEquals(null, playQueue.getNowPlaying().getNextSong());
		
		// case 1 (no songs in queue)
		playQueue.nextSong();
		assertEquals(null, playQueue.getNowPlaying().getPreviousSong());
		
		// case 2 (1 song in queue)
		SongInterface song1 = factory.createSong();
		playQueue.playNow(song1);
		playQueue.nextSong();
		assertEquals(song1, playQueue.getNowPlaying());
		
		// case 3 (2 or more songs in queue)
		SongInterface song2 = factory.createSong();
		playQueue.playNow(song2);
		assertEquals(song2, playQueue.getNowPlaying());
		playQueue.nextSong();
		assertEquals(song1, playQueue.getNowPlaying());
	}

	@Test
	void testPreviousSong() {
		PlayQueueInterface playQueue = factory.createPlayQueue(factory.createSong());
		// before method
		assertEquals(null, playQueue.getNowPlaying().getPreviousSong());
		assertEquals(null, playQueue.getNowPlaying().getNextSong());
		
		// case 1 (no songs in queue)
		playQueue.previousSong();
		assertEquals(null, playQueue.getNowPlaying().getPreviousSong());
		
		// case 2 (1 song in queue)
		SongInterface song1 = factory.createSong();
		playQueue.playNow(song1);
		playQueue.previousSong();
		assertEquals(song1, playQueue.getNowPlaying());
		
		// case 3 (2 or more songs in queue)
		SongInterface song2 = factory.createSong();
		playQueue.playNow(song2);
		assertEquals(song2, playQueue.getNowPlaying());
		playQueue.previousSong();
		assertEquals(song1, playQueue.getNowPlaying());
	}

}
