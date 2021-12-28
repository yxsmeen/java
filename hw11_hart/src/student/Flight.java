package student;

import java.time.LocalDate;

public class Flight {
	private String number;
	private LocalDate date;
	private Airport origin;
	private Airport destination;
	private double cost;
	private double distance;

	public Flight(String number, LocalDate date, Airport origin, Airport destination, double cost) {
		this.number = number;
		this.date = date;
		this.origin = origin;
		this.destination = destination;
		this.cost = cost;
	}
	
	public String getNumber() {
		return number;
	}
	
	public LocalDate getDate() {
		return date;
	}
	
	public Airport getOrigin() {
		return origin;
	}
	
	public Airport getDestination() {
		return destination;
	}
	
	public double getCost() {
		return cost;
	}
	
	public double getDistance() {
		distance = DistanceCalculator.getDistance(getOrigin().getLatitude(), getOrigin().getLongitude(), getDestination().getLatitude(), getDestination().getLongitude());
		return distance;
	}
	
	public String toString() {
		return String.format( "  Flight: %s, Date: %d-%d-%d \n"
							+ "    From: %s-%s, %s \n"
							+ "      To: %s-%s, %s \n"
							+ "Distance: %.0f miles, Cost: $%.2f \n", 
							getNumber(), date.getYear(), date.getMonthValue(), date.getDayOfMonth(),
							getOrigin().getCode(), getOrigin().getCity(), getOrigin().getState(), 
							getDestination().getCode(), getDestination().getCity(), getDestination().getState(),
							getDistance(), getCost());
	}	
	
}
