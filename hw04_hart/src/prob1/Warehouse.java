package prob1;
import java.util.ArrayList;

public class Warehouse {
	protected ArrayList<Item> items = new ArrayList<>();
	//protected Item[] items = new Item[10];
	protected int numItems = 0;
	
	public Warehouse() {
		
	}
	
//	public void addItem(Item item) {
//		if(numItems < 10) {
//			items[numItems] = item;
//			numItems++;
//		}
//	}
	
	public ArrayList<Item> getItems(){
		return items;
	}
	
	public boolean addItem(Item item) {
		for(int i = 0; i < items.size(); i++) {
			if(items.get(i).equals(item)) {
				return false;
			}
		}
		items.add(item);
		numItems++;
		return true;
	}
	
	public int getNumRI() {
		int numRI = 0;
		for(int i = 0; i < items.size(); i++) {
			if(items.get(i) instanceof RefrigeratedItem) {
				numRI++;
			}
		}
		return numRI;
	}
	
	public Item getItem(int i) {
		Item p = null;
		if((0 <= i) && (i < numItems)) {
			p = items.get(i);
		}
		return p;
	}
	
//	public Item getItem(String name) {
//		Item p = null;
//		for(int i = 0; i < numItems; i++) {
//			if(items[i].getName().equals(name)) {
//				p = items[i];
//			}
//		}
//		return p;
//	}
	
	public Item getItem(String name) {
		Item i = new Item(name);
		int loc = items.lastIndexOf(i);
//		for(Item it:items) {
//			System.out.println(it);
//		}
		if(loc >= 0) {
			return items.get(loc);
		}
		return null;
	}
	
	public int getNumItems() {
		return numItems;
	}
	
	public double getAverageTemp() {
		double total = 0;
		double avTemp = 0;
		int numRI = getNumRI();
		RefrigeratedItem[] r = getRefrigeratedItems();
		for(int i = 0; i < numRI; i++) {
			total += r[i].getTemp();
		}
		avTemp = total/numRI;
		return avTemp;
	}


	public RefrigeratedItem[] getRefrigeratedItems() {
		int numRI = 0;
		RefrigeratedItem[] r = new RefrigeratedItem[10];
		
		for(int i = 0; i < items.size(); i++) {
			if(items.get(i) instanceof RefrigeratedItem) {
				r[numRI] = (RefrigeratedItem) items.get(i);
				numRI++;	
			}
		}
		
		return r;
	}
	
	public double getTotalCost() {
		double sum = 0;
		for(int i = 0; i < numItems; i++) {
			sum += items.get(i).cost();
		}
		return sum;
	}
	
	public double getTotalCostRefrigerated() {
		double sum = 0;
		RefrigeratedItem[] r = getRefrigeratedItems();
		int numRI = getNumRI();
		for(int i = 0; i < numRI; i++) {
			sum += r[i].cost();
		}
		return sum;
	}

//	public Item removeItem(String name) {
//		Item i = null;
//		for (int x = 0; x < numItems; x++) {
//			if(items.get(x).getName().equals(name)) {
//				i = items.get(x);
//				numItems--;
//			}
//		}	
//		return i;
//	}
	public Item removeItem(String name) {
		Item i = new Item(name);
		int loc = items.indexOf(i);
		if(items.contains(i)) {
		//if(loc >= 0) {
			return items.remove(loc);
		}
		return null;
	}
	
	public Item removeItem(int x) {
		Item i = null;
		if((0 <= x) && (x < numItems)){
			i = items.get(x);
			for(int j = x + 1; j < numItems; j++) {
				Item temp = items.get(j - 1);
				temp = items.get(j);
			}
			numItems--;
			return i;
		}
		return null;
	}
	
	public String toString() {
		String msg = "";
		for(int i = 0; i < numItems; i++) {
			msg += String.format("name= %s, cost= $%.2f, weight= %.2f \n", items.get(i).getName(), items.get(i).cost(), items.get(i).getWeight());
		}
		return msg;
	}
	
	public ArrayList <Item> getItemsWithName(String partialName){
		ArrayList <Item> inCommon = new ArrayList<>();
		for(int i = 0; i < items.size(); i++) {
			if(items.get(i).getName().contains(partialName)) {
				inCommon.add(items.get(i));
			}
		}
		return inCommon;
	}
	
	public boolean hasItem(String name) {
		for(int i = 0; i < items.size(); i++) {
			if(items.get(i).getName().equals(name)) {
				return true;
			}
		}
		return false;
	}
}
