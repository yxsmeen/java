package prob1;

public abstract class Martian implements Comparable<Martian> {
	private int id;
	private int volume;
	
	public Martian(int id, int volume) {
		this.id = id;
		this.volume = volume;
	}
	public int getId() {
		return id;
	}
	public int getVolume() {
		return volume;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public void setVolume(int volume) {
		this.volume = volume;
	}
	
	public int compareTo(Martian m) {
		//Martian m = (Martian)o;
		return this.getId() - m.getId();
	}
	
	public boolean equals(Object o) {
		if(o == null) {
			return false;
		}
		if(!(o instanceof Martian)) {
			return false;
		}
		Martian oo = (Martian)o;
		return oo.getId() == (this.getId());
	}
	
	public abstract String speak();
	public abstract int power();
	
	public String toString() {
		return String.format("id: %d, volume: %d", getId(), getVolume());
	}
}
