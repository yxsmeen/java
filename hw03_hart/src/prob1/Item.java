package prob1;

public class Item {
	protected double weight;
	protected String name;
	
	public Item(String name, double weight) {
		this.weight = weight;
		this.name = name;
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
	
	public String toString() {
		return String.format("name=%s, cost=$%.2f, weight=%.2f", name, cost(), weight);
	}

	/*public double getTemp() {
		// TODO Auto-generated method stub
		return 0;
	}*/
	
}
