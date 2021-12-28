package ver1;

public class WolfDog extends Dog {
	
	public WolfDog(String name) {
		super(name);
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
