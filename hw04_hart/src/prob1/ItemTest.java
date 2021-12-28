package prob1;

public class ItemTest {

	public static void main(String[] args) {
		testConstructor();
		testItemCost();
		testIsEqualTrue();
		testIsEqualFalse();
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
	
	//test equals method: return true
	public static void testIsEqualTrue() {
		System.out.println("-->testIsEqualTrue"); 
		Item i = new Item("Pudding", 3.423);
		Item t = new Item("Pudding", 4.396);
		System.out.println(i.equals(t));
	}
	
	//test equals method: return false
		public static void testIsEqualFalse() {
			System.out.println("-->testIsEqualFalse"); 
			Item i = new Item("Pudding", 3.423);
			Item t = new Item("Peanut Butter", 4.396);
			System.out.println(i.equals(t));
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
