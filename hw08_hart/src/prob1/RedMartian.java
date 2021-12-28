package prob1;

public class RedMartian extends Martian{
	private int tenacity;
	
	public RedMartian(int id, int volume, int tenacity) {
		super(id, volume);
		this.tenacity = tenacity;
	}
	
	public RedMartian(int id, int tenacity) {
		this(id, 1, tenacity);
	}
	
	public int getTenacity() {
		return tenacity;
	}
	
	public int power() {
		return getVolume() + getTenacity();
	}
	
	public String speak() {
		return String.format("id: %d, Rubldy Rock", getId());
	}
	
	public String toString() {
		return String.format("Red Martian - id: %d, volume: %d, tenacity: %d", getId(), getVolume(), getTenacity());
	}
}
