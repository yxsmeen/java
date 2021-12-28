package prob1;

public class Item {
	protected double weight;
	protected String name;
	
	public Item(String name, double weight) {
		this.weight = weight;
		this.name = name;
	}
	
	public Item(String name) {
		this(name, 0.0);
	}
	
	public double getWeight() {
		return weight;
	}
	
	public String getName() {
		return name;
	}
	
	public double cost() {
		return weight * 2;
	}
	
	public boolean equals(Object i) {
		if(i == null) {
			return false;
		}
		if(!(i instanceof Item)) {
			return false;
		}
		Item ii = (Item)i;
		return ii.getName().equals(this.getName());
	}
	
	public String toString() {
		return String.format("name=%s, cost=$%.2f, weight=%.2f", name, cost(), weight);
	}
	
}
