package student;

public class Airport {
	private String code;
	private double latitude;
	private double longitude;
	private String city;
	private String state;
	
	public Airport(String code, double latitude, double longitude, String city, String state){
		this.code = code;
		this.latitude = latitude;
		this.longitude = longitude;
		this.city = city;
		this.state = state;
	}
	
	protected Airport(String code) {
		this.code = code;
	}
	
	public boolean equals(Object o) {
		if(o != null) {
			return ((Airport) o).getCode().equals(this.getCode());
		}
		return false;
	}
	
	public String getCity() {
		return city;
	}
	
	public String getCode() {
		return code;
	}
	
	public double getLatitude() {
		return latitude;
	}
	
	public double getLongitude() {
		return longitude;
	}
	
	public String getState() {
		return state;
	}
	
	public String toString() {
		return String.format("(" + getCode() + "-" + getCity() + ", " + getState() + ": " + 
							getLatitude() + ", " + getLongitude() + ")");
	}
}
