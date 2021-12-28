package exception_examples1;
import java.util.ArrayList;
//import java.util.Arrays;

public class Example4 {
	public static void main(String[] args) {
		//ArrayList<Integer> ints = new ArrayList<>(Arrays.asList(4,6,0,3,5));
		ArrayList<Integer> ints = null;
		int x = 1;
		int y = 2;
		
		try {
			System.out.println(divide(ints, x, y));
		}
		catch(RuntimeException e) {
			System.out.println("exception caught: ");
			System.out.println(e);
		}
		finally {
			System.out.println("finally block executed");
		}
		System.out.println("all done");
		
	}
	
	public static double divide(ArrayList<Integer> ints, int x, int y) {
		return ints.get(x)/ints.get(y);
	}
}
