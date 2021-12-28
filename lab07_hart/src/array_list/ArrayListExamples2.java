package array_list;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class ArrayListExamples2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Arrays.asList()
		System.out.println("-->Illustrate Arrays.asList: ");
		String[] citiesAry = {"Boston", "Philly", "Norfolk"};
		ArrayList<String> cities = new ArrayList<>(Arrays.asList(citiesAry));
		System.out.println(cities);
			//consolidated
		System.out.println("\n-->Illustrate Arrays.asList, again: ");
		ArrayList<String> cities2 = new ArrayList<>(Arrays.asList("SF", "KC", "NYC"));
		System.out.println(cities2);

		//collections class
		System.out.println("\n-->Illustrate Collections methods: ");
		System.out.println("Before sort: " + cities);
		Collections.sort(cities);
		System.out.println("After sort: " + cities);
		System.out.println("'Min' city: " + Collections.min(cities));
		System.out.println("'Max' city: " + Collections.max(cities));

	}

}
