package prob1;

//import emps.Employee;

//import emps.Employee;

public class Warehouse {
	protected Item[] items = new Item[10];
	protected int numItems = 0;
	
	public Warehouse() {
		
	}
	
	public void addItem(Item item) {
		if(numItems < 10) {
			items[numItems] = item;
			numItems++;
		}
	}
	public int getNumRI() {
		int numRI = 0;
		for(int i = 0; i < items.length; i++) {
			if(items[i] instanceof RefrigeratedItem) {
				numRI++;
			}
		}
		return numRI;
	}
	
	public Item getItem(int i) {
		Item p = null;
		if((0 <= i) && (i < numItems)) {
			p = items[i];
		}
		return p;
	}
	
	public Item getItem(String name) {
		Item p = null;
		for(int i = 0; i < numItems; i++) {
			if(items[i].getName().equals(name)) {
				p = items[i];
			}
		}
		return p;
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
		
		for(int i = 0; i < items.length; i++) {
			if(items[i] instanceof RefrigeratedItem) {
				r[numRI] = (RefrigeratedItem) items[i];
				numRI++;	
			}
		}
		
		return r;
	}
	
	public double getTotalCost() {
		double sum = 0;
		for(int i = 0; i < numItems; i++) {
			sum += items[i].cost();
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

	public Item removeItem(String name) {
		Item i = null;
		for (int x = 0; x < numItems; x++) {
			if(items[x].getName().equals(name)) {
				i = items[x];
				numItems--;
			}
		}	
		return i;
	}
	
	public Item removeItem(int x) {
		Item i = null;
		if((0 <= x) && (x < numItems)){
			i = items[x];
			for(int j = x + 1; j < numItems; j++) {
				items[j - 1] = items[j];
			}
			numItems--;
			return i;
		}
		return null;
	}
	
	public String toString() {
		String msg = "";
		for(int i = 0; i < numItems; i++) {
			msg += String.format("name= %s, cost= $%.2f, weight= %.2f \n", items[i].getName(), items[i].cost(), items[i].getWeight());
		}
		return msg;
	}
}
