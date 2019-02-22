import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class View implements ViewInterface {
	
	private String menu = "\n" +
			"------------- Main menu ------------- \n" +
			"0. Repeat menu \n" +
			"1. Play a song now\n" + 
			"2. Play a song next\n" +
			"3. Play a song later\n" +
			"4. >> Next\n" +
			"5. << Previous\n" +
			"6. Show queue\n" +
			"7. Exit\n" +
			"\nInput action (0-7): ";
	
	@Override
	public String getMenu() {
		return menu;
	}
	
	@Override
	public int promptActionWithMenu() {
		int menuChoice =8;
		Scanner sc = new Scanner(System.in);
		System.out.print(getMenu());
		try {
			menuChoice = Integer.parseInt(sc.next(Pattern.compile("^([0-7])$")));
		} 
		catch (InputMismatchException e) {
			System.out.print("\nInvalid input.");
		}
		return menuChoice;
	}
	
	@Override
	public int promptAction() {
		int menuChoice;
		Scanner sc = new Scanner(System.in);
		System.out.print("\nInput action (1-7) or 0 for menu: ");
		try {
			menuChoice = Integer.parseInt(sc.next(Pattern.compile("^([0-7])$")));
		} 
		catch (InputMismatchException e) {
			menuChoice = 8;
		}
		return menuChoice;
	}
	
	@Override
	public String[] promptSongInfo() {
		Scanner sc = new Scanner(System.in);
		String[] songInfo = new String[3];
		System.out.print("\nInput song name: ");
		songInfo[0]=sc.nextLine();
		System.out.print("\nInput song artist: ");
		songInfo[1]=sc.nextLine();
		System.out.print("\nInput song album: ");
		songInfo[2]=sc.nextLine();
		return songInfo;
	}
	
	@Override
	public void showPlayQueue(PlayQueueInterface playQueue) {
		if(playQueue.getNowPlaying().getNextSong()==null) {
			System.out.print("\nNo song is playing yet.");
			System.out.print("\nPlay queue is empty.");
			
		} else if (playQueue.getNowPlaying().getNextSong()==playQueue.getNowPlaying()) {
			System.out.print("\nNow playing: " + Arrays.toString(playQueue.getNowPlaying().getSongInfo()));
			System.out.print("\nPlay queue is empty.");
			
		} else {
			System.out.print("\nNow playing: " + Arrays.toString(playQueue.getNowPlaying().getSongInfo()));
			SongInterface nextInQueue = playQueue.getNowPlaying().getNextSong();
			int queuePosition = 1;
			while(nextInQueue!=playQueue.getNowPlaying()) {
				System.out.print("\nNo. " + queuePosition + " " + Arrays.toString(nextInQueue.getSongInfo()));
				nextInQueue = nextInQueue.getNextSong();
				queuePosition++;
			}
		}	
	}
}
