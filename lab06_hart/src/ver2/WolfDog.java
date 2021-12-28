package ver2;

public class WolfDog extends Dog {
	
	private int toughness;
	
	public WolfDog(String name, int toughness) {
		super(name);
		this.toughness = toughness;
	}
	
	public int getToughness() {
		return toughness;
	}

	@Override
	public String bark() {
		return name + " says: bark";
	}
	
	@Override
	public String toString() {
		return "WolfDog named " + getName();
	}
}
