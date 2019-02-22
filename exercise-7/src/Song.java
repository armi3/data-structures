
public class Song implements SongInterface {
	private SongInterface previousSong;
	private SongInterface nextSong;
	private String[] songInfo = new String[3];
	
	public Song() {
		super();
		this.previousSong = null;
		this.nextSong = null;
		this.songInfo = new String[3];
	}
	
	@Override
	public SongInterface getPreviousSong() {
		return previousSong;
	}
	@Override
	public void setPreviousSong(SongInterface previousSong) {
		this.previousSong = previousSong;
	}
	@Override
	public SongInterface getNextSong() {
		return nextSong;
	}
	@Override
	public void setNextSong(SongInterface nextSong) {
		this.nextSong = nextSong;
	}
	@Override
	public String[] getSongInfo() {
		return songInfo;
	}
	@Override
	public void setSongInfo(String[] songInfo) {
		this.songInfo = songInfo;
	}

}
