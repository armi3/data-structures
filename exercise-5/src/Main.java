import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		final String loremIpsum = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.".toUpperCase();
		int[] alphabetFrequencies = new int[(90-65)];
		
		for(int i = 0; i < loremIpsum.length(); i++) {
			for(int j =0; j < alphabetFrequencies.length; j++) {
				if((65+j)==loremIpsum.charAt(i)) {
					alphabetFrequencies[j]++;
	            }
				
			}
			
            
        }
		System.out.print("\nalphabetFrequencies: " + Arrays.toString(alphabetFrequencies));
		

	}

}
