public class Factory {
	public PlayQueueInterface createPlayQueue() {
		return new PlayQueue();
	}
	public SongInterface createSong() {
		return new Song();
	}

}
