package prob1;

public class RefrigeratedItemTest {

	public static void main(String[] args) {
		testConstructorMain();
		testIsEqualTrue();
		testIsEqualFalse();
		testConstructorAcceptsItem();
		testItemCost();
		testToString();
	}
	
	/**
	 * Verify that the name, weight, & temp are initialized with the main constructor.
	 */
	public static void testConstructorMain() {
		System.out.println("-->testConstructorMain"); 
		RefrigeratedItem r = new RefrigeratedItem("Ice Cream", 3.526, 23.003);
		String name = r.name;
		double weight = r.weight;
		double temp = r.temp;
		System.out.println("name: " + name + ", weight: " + weight + ", temp: " + temp); 
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
	 * Verify that the name, weight, & temp are initialized with the second constructor.
	 */
	public static void testConstructorAcceptsItem() {
		System.out.println("-->testConstructorAcceptsItem"); 
		Item i = new Item("Pudding", 3.423);
		RefrigeratedItem r = new RefrigeratedItem(i, 41.243);
		String name = r.name;
		double weight = r.weight;
		double temp = r.temp;
		System.out.println("name: " + name + ", weight: " + weight + ", temp: " + temp); 
	}

	/**
	 * Verify that the cost method works correctly.
	 */
	public static void testItemCost() {
		System.out.println("-->testItemCost"); 
		RefrigeratedItem r = new RefrigeratedItem("Popsicle", 3.0, 10.0);
		double cost = r.cost();
		System.out.println("cost=" + cost); 
	}

	/**
	 * Verify that the toString method produces a string exactly
	 * as specified in the assignment document. 
	 */
	public static void testToString() {
		System.out.println("-->testToString"); 
		RefrigeratedItem r = new RefrigeratedItem("Peas", 3.526, 23.003);
		System.out.println(r); 
	}

}
