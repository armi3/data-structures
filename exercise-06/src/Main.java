import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
	public static int getQuadrant(double x, double y) {
		int quadrant;
		if(x>0 && y>0){
			quadrant =1;
		}else if(x<0 && y>0){
			quadrant=2;
		}else if(x<0 && y<0){
			quadrant=3;
		}else if(x>0 && y<0){
			quadrant=4;
		}else {
			quadrant=0;
		}
		return quadrant;
	}

	public static void main(String[] args) {
		Point point = new Point();
		int menuChoice = 0;
		int quadrant;
		do{
			switch(menuChoice) {
			case 0:
				Scanner sc = new Scanner(System.in);
				System.out.print("\nEnter (1) to analyze new point or (2) to exit: ");
				try {
					menuChoice = Integer.parseInt(sc.next(Pattern.compile("(1|2)")));
				} 
				catch (InputMismatchException e) {
					System.out.print("\nInvalid input.");
					menuChoice = 0;
				}
				break;
			
			case 1:
				Scanner sc1 = new Scanner(System.in);
				System.out.print("Enter x coordinate: ");
				try {
					point.x = Double.parseDouble(sc1.next(Pattern.compile("([+-]?[0-9]+(?:\\.[0-9]*)?)")));
				} 
				catch (InputMismatchException e) {
					System.out.print("\nInvalid input.");
					menuChoice = 0;
				}
				
				System.out.print("Enter y coordinate: ");
				try {
					point.y = Double.parseDouble(sc1.next(Pattern.compile("([+-]?[0-9]+(?:\\.[0-9]*)?)")));
				} 
				catch (InputMismatchException e) {
					System.out.print("\nInvalid input.");
					menuChoice = 0;
				}
				quadrant = getQuadrant(point.x, point.y);
				if(quadrant!=0){
					System.out.print("\nQuadrant " + quadrant +".");
				}else {
					System.out.print("\nPoint is either origin or on axis.");
				}
				menuChoice = 0;
				break;
			}

		} while(!String.valueOf(menuChoice).equals("2"));
		System.exit(0);

	}

}
