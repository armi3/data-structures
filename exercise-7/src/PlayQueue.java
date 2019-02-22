
public class PlayQueue implements PlayQueueInterface {
	
	private SongInterface nowPlaying;

	public PlayQueue(SongInterface nowPlaying) {
		super();
		this.nowPlaying = nowPlaying;
	}

	@Override
	public SongInterface getNowPlaying() {
		return nowPlaying;
	}

	@Override
	public void setNowPlaying(SongInterface nowPlaying) {
		this.nowPlaying = nowPlaying;
	}

	@Override
	public void playNow(SongInterface song) {
		if(getNowPlaying().getNextSong()==null) {
			song.setNextSong(song);
			song.setPreviousSong(song);
			
		} else if (getNowPlaying().getNextSong()==getNowPlaying()) {
			song.setNextSong(getNowPlaying());
			song.setPreviousSong(getNowPlaying());
			
			getNowPlaying().setNextSong(song);
			getNowPlaying().setPreviousSong(song);
			
		} else {
			getNowPlaying().getNextSong().setPreviousSong(song);
			
			song.setPreviousSong(getNowPlaying());
			song.setNextSong(getNowPlaying().getNextSong());
			
			getNowPlaying().setNextSong(song);
		}
		setNowPlaying(song);		
	}
	
	@Override
	public void playNext(SongInterface song) {
		if(getNowPlaying().getNextSong()==null) {
			song.setNextSong(song);
			song.setPreviousSong(song);
			
		} else if (getNowPlaying().getNextSong()==getNowPlaying()) {
			song.setNextSong(getNowPlaying());
			song.setPreviousSong(getNowPlaying());
			
			getNowPlaying().setNextSong(song);
			getNowPlaying().setPreviousSong(song);
			
		} else {
			getNowPlaying().getNextSong().setPreviousSong(song);
			
			song.setPreviousSong(getNowPlaying());
			song.setNextSong(getNowPlaying().getNextSong());
			
			getNowPlaying().setNextSong(song);
		}
	}
	
	@Override
	public void playLater(SongInterface song) {
		if(getNowPlaying().getNextSong()==null) {
			song.setNextSong(song);
			song.setPreviousSong(song);
			
		} else if (getNowPlaying().getNextSong()==getNowPlaying()) {
			song.setNextSong(getNowPlaying());
			song.setPreviousSong(getNowPlaying());
			
			getNowPlaying().setNextSong(song);
			getNowPlaying().setPreviousSong(song);
			
		} else {
			song.setNextSong(getNowPlaying());
			getNowPlaying().setPreviousSong(song);
			
			SongInterface previousSong = getNowPlaying().getNextSong();
			while(previousSong!=getNowPlaying()) {
				song.setPreviousSong(previousSong);
				previousSong = previousSong.getNextSong();
			}
			previousSong.setNextSong(song);
		}
	}

	@Override
	public String toString() {
		return "PlayQueue [nowPlaying=" + getNowPlaying() + "]";
	}

	@Override
	public void nextSong() {
		this.setNowPlaying(this.getNowPlaying().getNextSong());
		
	}

	@Override
	public void previousSong() {
		this.setNowPlaying(this.getNowPlaying().getPreviousSong());
		
	}

}
