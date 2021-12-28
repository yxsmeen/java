package array_list;
import java.util.ArrayList;

public class ArrayListExamples {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> cities = new ArrayList<>();
		cities.add("New York");
		cities.add("Chicago");
		cities.add("Atlanta");
		
		//get(i)
		String city = cities.get(1);
		System.out.println("-->Illustrate get(i) method: ");
		System.out.println(city);

		
		//size()
		int size = cities.size();
		System.out.println("\n-->Illustrate size() method: ");
		System.out.println(size);

		
		//enhanced for loop
		System.out.println("\n-->Illustrate enhanced for loop: ");
		for(String c: cities) {
			System.out.println(c + " ");
		}
		
		//indexed for loop
		System.out.println("\n-->Illustrate indexed for loop: ");
		for(int i = 0; i < cities.size(); i++) {
			System.out.println(cities.get(i) + " ");
		}
		
		//add(index, object)
		System.out.println("\n-->Illustrate add(index, object) method: ");
		cities.add(1, "Memphis");
		for(String c: cities) {
			System.out.println(c + " ");
		}
		
		//toString
		System.out.println("\n-->Illustrate toString method: ");
		System.out.println(cities.toString());
		
		//contains(object)
		System.out.println("\n-->Illustrate contains(object) method: ");
		System.out.println("Is Memphis in list? " + cities.contains("Memphis"));
		System.out.println("Is Seattle in list? " + cities.contains("Seattle"));
		
		//indexOf(object)
		System.out.println("\n-->Illustrate indexOf(object) method: ");
		System.out.println("What is location of Chicago in list? " + cities.indexOf("Chicago"));
		System.out.println("What is location of Detroit in list? " + cities.indexOf("Detroit"));
		
		//remove(index)
		System.out.println("\n-->Illustrate remove(index) method: ");
		System.out.println("List before remove: ");
		System.out.println(cities.toString());
		String cRemoved = cities.remove(2);
		System.out.println("List after remove: ");
		System.out.println(cities.toString());
		System.out.println("City removed: " + cRemoved);
		
		//remove(object)
		System.out.println("\n-->Illustrate remove(object) method: ");
		System.out.println("List before remove: ");
		System.out.println(cities.toString());
		cities.remove("Memphis");
		System.out.println("List after remove: ");
		System.out.println(cities.toString());
		
		//addAll(list)
		System.out.println("\n-->Illustrate addAll(list) method: ");
			//create new list of cities
		ArrayList<String> cities2 = new ArrayList<>();
		cities2.add("Oakland");
		cities2.add("Portland");
		
		System.out.println("Cities: " + cities);
		System.out.println("Cities2: " + cities2);
		
			//add new list to original list
		cities.addAll(cities2);
		System.out.println("Cities after addAll: " + cities);

		//constructor that accepts another list
		System.out.println("\n-->Illustrate constructor that accepts another list: ");
		ArrayList<String> cities3 = new ArrayList<>(cities);
		System.out.println("Cities: " + cities);
		System.out.println("Cities3: " + cities3);
		
		//isEmpty() & clear()
		System.out.println("\n-->Illustrate isEmpty & clear methods: ");
		System.out.println("Is cities empty? " + cities.isEmpty() + ", size= " + cities.size());
		cities.clear();
		System.out.println("Is cities empty? " + cities.isEmpty() + ", size= " + cities.size());
	}

}
