
public interface SongInterface {

	SongInterface getPreviousSong();

	void setPreviousSong(SongInterface previousSong);

	SongInterface getNextSong();

	void setNextSong(SongInterface nextSong);

	String[] getSongInfo();

	void setSongInfo(String[] songInfo);

}