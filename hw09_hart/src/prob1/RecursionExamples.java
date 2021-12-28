package prob1;

public class RecursionExamples {

	// Problem 1a
	public static double sumSeries(int n) {
		double sum = 0.0;
		for(int i = 1; i < n; i++) {
			if(n % 2 == 1) {
				if(i % 2 == 1) {
					sum += sumSeries(1/i);
				}
				else {
					sum -= sumSeries(1/i);
				}
			}
			else {
				if(i % 2 == 1) {
					sum += sumSeries(1/i);
				}
				else {
					sum -= sumSeries(1/i);
				}
			}
		}
		return sum;
	}

	// Problem 1b
	public static void printReverse2(String s) {
		// *** WRITE CODE HERE ***
	}
	
	// Problem 1c
	public static void printReverse(String s, int n) {
		// *** WRITE CODE HERE ***
	}

	// Problem 1d
	public static int countVowels(String s) {
		// *** WRITE CODE HERE ***
		return 0;
	}
	
	// Problem 1e, requires a helper
	public static int countLength(String[] strs) {
		// *** WRITE CODE HERE ***
		return 0;
	}

	// Problem 1f, requires a helper
	public static int getMax(int[] vals) {
		// *** WRITE CODE HERE ***
		return 0;
	}

	// Problem 1g, requires a helper
	public static int countCode(String msg, String code ) {
		// *** WRITE CODE HERE ***
		return 0;
	}

}
