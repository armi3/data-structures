import java.util.Arrays;
import java.util.Comparator;

public class Main {

	// Function to sort by column 
	public static int[][] sortbyColumn(int arr[][], int col) 
	{ 
		// Using built-in sort function Arrays.sort 
		Arrays.sort(arr, new Comparator<int[]>(){ 

			@Override              
			// Compare values according to columns 
			public int compare(final int[] entry1, final int[] entry2) { 

				// To sort in descending order revert  
				// the '>' Operator 
				if (entry1[col] < entry2[col]) 
					return 1; 
				else
					return -1; 
			} 
		});  // End of function call sort(). 
		return arr;
	} 

	public static void main(String[] args) {
		final String loremIpsum = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.".toUpperCase();
		int[][] alphabetFrequencies = new int[26][2];
		for(int j =0; j < alphabetFrequencies.length; j++) {
			alphabetFrequencies[j][0]=65+j;
		}
		System.out.print("\nalphabetFrequencies before counting: " + Arrays.deepToString(alphabetFrequencies));
		for(int i = 0; i < loremIpsum.length(); i++) {
			for(int j =0; j < alphabetFrequencies.length; j++) {
				if((65+j)==loremIpsum.charAt(i)) {
					alphabetFrequencies[j][1]++;
				}
			}
		}
		System.out.print("\nalphabetFrequencies before sorting: " + Arrays.deepToString(alphabetFrequencies));
		sortbyColumn(alphabetFrequencies, 1);
		System.out.print("\nalphabetFrequencies after sorting: " + Arrays.deepToString(alphabetFrequencies));
		int[][] copy = new int[10][2];
		System.arraycopy(alphabetFrequencies, 0, copy, 0, 10);
		alphabetFrequencies = copy;
		System.out.print("\nalphabetFrequencies after cropping: " + Arrays.deepToString(alphabetFrequencies));
		for (int i=0; i<10; i++) {
			System.out.print("\n" + (char)alphabetFrequencies[i][0] + ": ");
			for (int j=0; j<alphabetFrequencies[i][1]; j++) {
				System.out.print("*");
			}
		}
	}

}
