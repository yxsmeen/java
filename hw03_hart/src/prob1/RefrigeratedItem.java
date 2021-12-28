package prob1;

public class RefrigeratedItem extends Item {
	protected double temp;
	protected String name;
	protected double weight;
	
	public RefrigeratedItem(String name, double weight, double temp) {
		super(name, weight);
		this.name = name;
		this.weight = weight;
		this.temp = temp;
	}
	
	public RefrigeratedItem(Item i, double temp) {
		super(i.name, i.weight);
		this.temp = temp;
	}
	
	public double getTemp() {
		return temp;
	}
	
	public double cost() {
		return ((weight * 2) + (100 - temp) * 0.1);
	}
	
	public String toString() {
		return String.format("name=%s, cost=$%.2f, weight=%.2f, temp=%.2f degrees",
				name, cost(), weight, temp);
	}
}
