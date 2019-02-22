public class Factory {
	
	public SongInterface createSong() {
		return new Song();
	}
	
	public PlayQueueInterface createPlayQueue(SongInterface song) {
		return new PlayQueue(song);
	}
	
	public ViewInterface createView() {
		return new View();
	}
	
	public ControllerInterface createController(PlayQueueInterface playQueue, ViewInterface view) {
		return new Controller(playQueue, view);
	}

}
