package prob1;

public class ItemTest {

	public static void main(String[] args) {
		testConstructor();
		testItemCost();
		testToString();
	}
	
	/**
	 * Verify that the name & weight are initialized with the constructor.
	 */
	public static void testConstructor() {
		System.out.println("-->testConstructor"); 
		Item i = new Item("Pudding", 3.426);
		String name = i.getName();
		double weight = i.getWeight();
		System.out.println("Name: " + name + ", Weight: "+ weight);
	}

	/**
	 * Verify that the cost method works correctly.
	 */
	public static void testItemCost() {
		System.out.println("-->testItemCost"); 
		Item i = new Item("Pudding", 3.423);
		double cost = i.cost();
		System.out.println("Cost: " + cost); 
	}

	/**
	 * Verify that the toString method produces a string exactly
	 * as specified in the assignment document. 
	 */
	public static void testToString() {
		System.out.println("-->testToString"); 
		Item i = new Item("Pudding", 3.423);
		System.out.println(i); 
	}

}
