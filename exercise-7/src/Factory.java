public class Factory {
	public SongInterface createSong() {
		return new Song();
	}
	
	public PlayQueueInterface createPlayQueue(SongInterface song) {
		return new PlayQueue(song);
	}
	
//	public ControllerInterface createController(PlayQueueInterface playQueue) {
//		return new Controller(playQueue);
//	}

}
