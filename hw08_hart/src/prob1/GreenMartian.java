package prob1;

public class GreenMartian extends Martian implements Teleporter {
	public GreenMartian(int id, int volume) {
		super(id, volume);
	}
	public GreenMartian(int id) {
		this(id, 1);
	}
	public int power() {
		return getVolume();
	}
	
	public String speak() {
		return String.format("id: %d, Grobldy Grock", getId());
	}

	public String teleport(String dest) {
		return String.format("id: %d teleporting to %s", getId(), dest);
	}
	
	public String toString() {
		return String.format("Green Martian - id: %d, volume: %d", getId(), getVolume());
	}

}
