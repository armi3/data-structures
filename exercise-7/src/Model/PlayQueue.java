package Model;

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
			setNowPlaying(song);
			
		} else if (getNowPlaying().getNextSong()==getNowPlaying()) {
			song.setNextSong(getNowPlaying());
			song.setPreviousSong(getNowPlaying());
			
			getNowPlaying().setNextSong(song);
			getNowPlaying().setPreviousSong(song);
			
		} else {
			song.setPreviousSong(getNowPlaying());
			song.setNextSong(getNowPlaying().getNextSong());
			
			getNowPlaying().getNextSong().setPreviousSong(song);
			getNowPlaying().setNextSong(song);
		}
	}
	
	@Override
	public void playLater(SongInterface song) {
		if(getNowPlaying().getNextSong()==null) {
			song.setNextSong(song);
			song.setPreviousSong(song);
			setNowPlaying(song);
			
		} else if (getNowPlaying().getNextSong()==getNowPlaying()) {
			song.setNextSong(getNowPlaying());
			song.setPreviousSong(getNowPlaying());
			
			getNowPlaying().setNextSong(song);
			getNowPlaying().setPreviousSong(song);
			
		} else {
			song.setNextSong(getNowPlaying());
			getNowPlaying().setPreviousSong(song);
			
			SongInterface lastSong = getNowPlaying().getNextSong();
			while(lastSong!=getNowPlaying()) {
				song.setPreviousSong(lastSong);
				lastSong = lastSong.getNextSong();
			}
			song.getPreviousSong().setNextSong(song);
		}
	}

	@Override
	public String toString() {
		return "PlayQueue [nowPlaying=" + getNowPlaying() + "]";
	}

	@Override
	public void nextSong() {
		if(getNowPlaying().getNextSong()!=null) {
			this.setNowPlaying(this.getNowPlaying().getNextSong());
		}
	}

	@Override
	public void previousSong() {
		if(getNowPlaying().getNextSong()!=null) {
			this.setNowPlaying(this.getNowPlaying().getPreviousSong());
		}
	}

}
