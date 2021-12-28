package prob1;

public class WarehouseTest {

	public static void main(String[] args) {
		testAddItem();
		testAddItem_Multiple();
		testAddItem_11_Items();
		testGetItem_WithIndex();
		testGetItem_WithIndex_Null_Index();
		testGetItem_WithName();
		testGetItem_WithNullName();
		testGetAverageTemp();
		testGetAverageTemp_Null();
		testGetRefrigeratedItems();
		testGetTotalCost();
		testGetTotalCostRefrigerated();
		testRemoveItem_WithIndex();
		testRemoveItem_WithNullIndex();
		testRemoveItem_WithName();
		testRemoveItem_WithNullName();
		testToString();
	}
	
	/**
	 * Add one item and check the number of items to verify.
	 */
	public static void testAddItem() {
		System.out.println("-->testAddItem"); 
		Warehouse w = new Warehouse();
		Item i = new RefrigeratedItem("Pudding", 3.246, 3.279);
		w.addItem(i);
		System.out.println("Number of items: " + w.getNumItems()); 
		System.out.println("");
	}
	
	/**
	 * Add three items and check the number of items to verify. At least one should be a refrigerated item.
	 */
	public static void testAddItem_Multiple() {
		System.out.println("-->testAddItem_Multiple"); 
		Warehouse w = new Warehouse();
		Item one = new Item("Pudding", 3.246);
		Item two = new Item("Pudding", 3.246);
		Item three = new Item("Pudding", 3.246);
		w.addItem(one);
		w.addItem(two);
		w.addItem(three);
		System.out.println("Number of items: " + w.getNumItems()); 
		System.out.println("");
	}
	
	//adds 11 items, should stop at ten
	public static void testAddItem_11_Items() {
		System.out.println("-->testAddItem_11_Items"); 
		Warehouse w = new Warehouse();
		Item a = new Item("Pudding", 3.246);
		Item b = new Item("Pudding", 3.246);
		Item c = new Item("Pudding", 3.246);
		Item d = new Item("Pudding", 3.246);
		Item e = new Item("Pudding", 3.246);
		Item f = new Item("Pudding", 3.246);
		Item g = new Item("Pudding", 3.246);
		Item h = new Item("Pudding", 3.246);
		Item i = new Item("Pudding", 3.246);
		Item j = new Item("Pudding", 3.246);
		Item k = new Item("Pudding", 3.246);
		w.addItem(a);
		w.addItem(b);
		w.addItem(c);
		w.addItem(d);
		w.addItem(e);
		w.addItem(f);
		w.addItem(g);
		w.addItem(h);
		w.addItem(i);
		w.addItem(j);
		w.addItem(k);

		System.out.println("Number of items: " + w.getNumItems()); 
		System.out.println("");
	}
	
	/**
	 * Add three items and retrieve the one at index 1.
	 */
	public static void testGetItem_WithIndex() {
		System.out.println("-->testGetItem_WithIndex"); 
		Warehouse w = new Warehouse();
		Item one = new Item("Pudding", 3.246);
		Item two = new Item("Ice cream", 3.246);
		Item three = new Item("Popsicle", 3.246);
		w.addItem(one);
		w.addItem(two);
		w.addItem(three);
		System.out.println("Item at index 1 expected: Ice cream. Actual: " + w.getItem(1)); 
		System.out.println("");
	}
	
	//get item with null index
	public static void testGetItem_WithIndex_Null_Index() {
		System.out.println("-->testGetItem_WithIndex_Null_Index"); 
		Warehouse w = new Warehouse();
		Item one = new Item("Pudding", 3.246);
		Item two = new Item("Ice cream", 3.246);
		Item three = new Item("Popsicle", 3.246);
		w.addItem(one);
		w.addItem(two);
		w.addItem(three);
		System.out.println("Item at index 1 expected: null. Actual: " + w.getItem(4)); 
		System.out.println("");
	}

	/**
	 * Add three items and try to find one with a name that exists.
	 */
	public static void testGetItem_WithName() {
		System.out.println("-->testGetItem_WithName"); 
		Warehouse w = new Warehouse();
		Item one = new Item("Pudding", 3.246);
		Item two = new Item("Ice cream", 3.246);
		Item three = new Item("Popsicle", 3.246);
		w.addItem(one);
		w.addItem(two);
		w.addItem(three);
		System.out.println("Item: " + w.getItem("Popsicle")); 
		System.out.println("");
	}
	
	//get item with name that does not exist
	public static void testGetItem_WithNullName() {
		System.out.println("-->testGetItem_WithNullName"); 
		Warehouse w = new Warehouse();
		Item one = new Item("Pudding", 3.246);
		Item two = new Item("Ice cream", 3.246);
		Item three = new Item("Popsicle", 3.246);
		w.addItem(one);
		w.addItem(two);
		w.addItem(three);
		System.out.println("Item: " + w.getItem("Peanut butter")); 
		System.out.println("");
	}

	/**
	 * Add 5 items, 3 of which are refrigerated. Verify the average temperature.
	 */
	public static void testGetAverageTemp() {
		System.out.println("-->testGetAverageTemp"); 
		Warehouse w = new Warehouse();
		Item one = new Item("Pudding", 3.246);
		Item two = new RefrigeratedItem("Ice cream", 3.246, 23.45);
		Item three = new RefrigeratedItem("Popsicle", 3.246, 21.199);
		Item four = new Item("Crackers", 1.246);
		Item five = new RefrigeratedItem("Smoothie", 3.246, 19.239);
		w.addItem(one);
		w.addItem(two);
		w.addItem(three);
		w.addItem(four);
		w.addItem(five);
		System.out.printf("Average temp expected: 21.30, actual: %.2f", w.getAverageTemp()); 
		System.out.println(""); 
		System.out.println("");
	}
	
	//get average temp but no items are refrigerated
	public static void testGetAverageTemp_Null() {
		System.out.println("-->testGetAverageTemp_Null"); 
		Warehouse w = new Warehouse();
		Item one = new Item("Pudding", 3.246);
		Item two = new Item("Crackers", 1.246);
		w.addItem(one);
		w.addItem(two);
		System.out.println("Average temp expected: not a number, actual: " + w.getAverageTemp()); 
		System.out.println("");
	}
	
	/**
	 * Add 5 items, 3 of which are refrigerated. Verify that the 3 are returned in array.
	 */
	public static void testGetRefrigeratedItems() {
		System.out.println("-->testGetRefrigeratedItems"); 
		Warehouse w = new Warehouse();
		Item one = new Item("Pudding", 3.246);
		Item two = new RefrigeratedItem("Ice cream", 3.246, 23.45);
		Item three = new RefrigeratedItem("Popsicle", 3.246, 21.199);
		Item four = new Item("Crackers", 1.246);
		Item five = new RefrigeratedItem("Smoothie", 3.246, 19.239);
		w.addItem(one);
		w.addItem(two);
		w.addItem(three);
		w.addItem(four);
		w.addItem(five);
		
		System.out.println("Refrigerated Items array: "); 
		RefrigeratedItem[] r = w.getRefrigeratedItems();
		for(int i = 0; i < w.getNumRI(); i++) {
			System.out.println(r[i].toString());
		}
		System.out.println("");
	}
	
	/**
	 * Add 5 items, 3 of which are refrigerated. Verify the total cost.
	 */
	public static void testGetTotalCost() {
		System.out.println("-->testGetTotalCost"); 
		Warehouse w = new Warehouse();
		Item one = new Item("Pudding", 3.246);
		Item two = new RefrigeratedItem("Ice cream", 3.246, 23.45);
		Item three = new RefrigeratedItem("Popsicle", 3.246, 21.199);
		Item four = new Item("Crackers", 1.246);
		Item five = new RefrigeratedItem("Smoothie", 3.246, 19.239);
		w.addItem(one);
		w.addItem(two);
		w.addItem(three);
		w.addItem(four);
		w.addItem(five);
		
		System.out.printf("Total cost expected: $52.07, actual: $%.2f", w.getTotalCost()); 
		System.out.println(""); 
		System.out.println("");
	}

	/**
	 * Add 5 items, 3 of which are refrigerated. Verify the total cost of the 3 refrigerated items
	 */
	public static void testGetTotalCostRefrigerated() {
		System.out.println("-->testGetTotalCostRefrigerated"); 
		Warehouse w = new Warehouse();
		Item one = new Item("Pudding", 3.246);
		Item two = new RefrigeratedItem("Ice cream", 3.246, 23.45);
		Item three = new RefrigeratedItem("Popsicle", 3.246, 21.199);
		Item four = new Item("Crackers", 1.246);
		Item five = new RefrigeratedItem("Smoothie", 3.246, 19.239);
		w.addItem(one);
		w.addItem(two);
		w.addItem(three);
		w.addItem(four);
		w.addItem(five);
		
		System.out.printf("Total cost expected: $43.09, actual: $%.2f", w.getTotalCostRefrigerated()); 
		System.out.println(""); 
		System.out.println("");
	}

	/**
	 * Add 5 items, 3 of which are refrigerated. Remove the one at position 2 and 
	 * verify: the item is returned, and the number of items is decremented.
	 */
	public static void testRemoveItem_WithIndex() {
		System.out.println("-->testRemoveItem_WithIndex"); 
		Warehouse w = new Warehouse();
		Item one = new Item("Pudding", 3.246);
		Item two = new RefrigeratedItem("Ice cream", 3.246, 23.45);
		Item three = new RefrigeratedItem("Popsicle", 3.246, 21.199);
		Item four = new Item("Crackers", 1.246);
		Item five = new RefrigeratedItem("Smoothie", 3.246, 19.239);
		w.addItem(one);
		w.addItem(two);
		w.addItem(three);
		w.addItem(four);
		w.addItem(five);
		
		System.out.println("Number of items: " + w.getNumItems());
		System.out.println("Item removed expected: Popsicle, actual: " + w.removeItem(2) + "\nNumber of items: " + w.getNumItems()); 
		System.out.println("");
	}
	
	//remove item with invalid index
	public static void testRemoveItem_WithNullIndex() {
		System.out.println("-->testRemoveItem_WithNullIndex"); 
		Warehouse w = new Warehouse();
		Item one = new Item("Pudding", 3.246);
		Item two = new RefrigeratedItem("Ice cream", 3.246, 23.45);
		Item three = new RefrigeratedItem("Popsicle", 3.246, 21.199);
		Item four = new Item("Crackers", 1.246);
		Item five = new RefrigeratedItem("Smoothie", 3.246, 19.239);
		w.addItem(one);
		w.addItem(two);
		w.addItem(three);
		w.addItem(four);
		w.addItem(five);
		
		System.out.println("Number of items: " + w.getNumItems());
		System.out.println("Item removed expected: null, actual: " + w.removeItem(6) + "\nNumber of items: " + w.getNumItems()); 
		System.out.println("");
	}

	/**
	 * Add 5 items, 3 of which are refrigerated. Remove one with a name that exists and 
	 * verify: the item is returned, and the number of items is decremented.
	 */
	public static void testRemoveItem_WithName() {
		System.out.println("-->testRemoveItem_WithName"); 
		Warehouse w = new Warehouse();
		Item one = new Item("Pudding", 3.246);
		Item two = new RefrigeratedItem("Ice cream", 3.246, 23.45);
		Item three = new RefrigeratedItem("Popsicle", 3.246, 21.199);
		Item four = new Item("Crackers", 1.246);
		Item five = new RefrigeratedItem("Smoothie", 3.246, 19.239);
		w.addItem(one);
		w.addItem(two);
		w.addItem(three);
		w.addItem(four);
		w.addItem(five);
		
		System.out.println("Number of items: " + w.getNumItems());
		System.out.println("Item removed expected: Crackers, actual: " + w.removeItem("Crackers") + "\nNumber of items: " + w.getNumItems());
		System.out.println("");
	}

	//remove item with nonexistent name
	public static void testRemoveItem_WithNullName() {
		System.out.println("-->testRemoveItem_WithNullName"); 
		Warehouse w = new Warehouse();
		Item one = new Item("Pudding", 3.246);
		Item two = new RefrigeratedItem("Ice cream", 3.246, 23.45);
		Item three = new RefrigeratedItem("Popsicle", 3.246, 21.199);
		Item four = new Item("Crackers", 1.246);
		Item five = new RefrigeratedItem("Smoothie", 3.246, 19.239);
		w.addItem(one);
		w.addItem(two);
		w.addItem(three);
		w.addItem(four);
		w.addItem(five);
		
		System.out.println("Number of items: " + w.getNumItems());
		System.out.println("Item removed expected: null, actual: " + w.removeItem("Peanut Butter") + "\nNumber of items: " + w.getNumItems());
		System.out.println("");
	}
	
	/**
	 * Verify that the toString method produces a string exactly
	 * as specified in the assignment document. 
	 */
	public static void testToString() {
		System.out.println("-->testToString"); 
		Warehouse w = new Warehouse();
		Item one = new Item("Pudding", 1.546);
		Item two = new RefrigeratedItem("Icecream", 3.436, 23.45);
		Item three = new RefrigeratedItem("Popsicle", 7.246, 21.199);
		Item four = new Item("Crackers", 1.246);
		Item five = new RefrigeratedItem("Smoothie", 5.646, 19.239);
		w.addItem(one);
		w.addItem(two);
		w.addItem(three);
		w.addItem(four);
		w.addItem(five);
		System.out.println(w); 
	}

}
