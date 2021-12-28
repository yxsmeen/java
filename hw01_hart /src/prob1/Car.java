package prob1;

public class Car {
	private double fuelCapacity;
	private double fuelEfficiency;
	private double fuelLevel;
	private double totalDistance;
	
	//constructor with three arguments
	public Car(double fuelCapacity, double fuelEfficiency, double fuelLevel) {
		this.fuelCapacity = fuelCapacity;
		this.fuelEfficiency = fuelEfficiency;
		this.fuelLevel = fuelLevel;
	}
	//constructor with two arguments
	public Car(double fuelCapacity, double fuelEfficiency) {
		this.fuelCapacity = fuelCapacity;
		this.fuelEfficiency = fuelEfficiency;
	}
	
	//add fuel to tank without overfueling
	public void fillUp(double amount) {
		if(fuelLevel == 0) {
			fuelLevel += amount;
		}
		else if(fuelCapacity - fuelLevel >= amount) {
			fuelLevel += amount;
		}
		else {
			fuelLevel += fuelCapacity - fuelLevel;
		}
	}
	
	//returns fuel capacity
	public double getFuelCapacity() {
		double fuelCapacity = this.fuelCapacity;
		return fuelCapacity;
	}
	
	//returns fuel efficiency
	public double getFuelEfficiency() {
		double fuelEfficiency = this.fuelEfficiency;
		return fuelEfficiency;
	}
	
	//returns fuel level
	public double getFuelLevel() {
		double fuelLevel = this.fuelLevel;
		return fuelLevel;
	}
	
	//returns total distance
	public double getTotalDistance() {
		double totalDistance = this.totalDistance;
		return totalDistance;
	}
	
	//drives car for given time & speed
	public void drive(double time, double rate) {
		double distanceDriven = rate * time;
		double fuelUsed = distanceDriven / fuelEfficiency;
		
		if (fuelUsed > fuelLevel) {
			distanceDriven = fuelLevel * fuelEfficiency;
			totalDistance += distanceDriven;
			fuelLevel = 0;
		}
		else {
		totalDistance += distanceDriven;
		fuelLevel -= fuelUsed;
		}
	}
	
	//return the four instance variables
	public String toString() {
		String msg = "fuelLevel=" + fuelLevel + ", totalDistance=" + totalDistance
				+ ", fuelCapacity=" + fuelCapacity + ",fuelEfficiency=" + fuelEfficiency;
		return msg;
	}
}
