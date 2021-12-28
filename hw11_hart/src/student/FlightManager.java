package student;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class FlightManager {
	private Map<String, Flight> flights = new HashMap<String, Flight>();
	private Map<String, Airport> airports = new HashMap<String, Airport>();
	private AirportManager airportManager = new AirportManager(airports);
	
	public FlightManager(AirportManager airportManager) {
		this.airportManager = airportManager;
	}
	
	public boolean addFlight(Flight flight) {
		if(!flights.containsKey(flight)) {
			flights.put(flight.getNumber(), flight);
			return true;
		}else {
			return false;
		}
	}
	
	public boolean addFlight(String number, String date, String originCode, String destinationCode, double cost) {
		if(!flights.containsValue(number)) {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			LocalDate d = LocalDate.parse(date, formatter);
			Flight flight = new Flight(number, d, airportManager.getAirport(originCode), airportManager.getAirport(destinationCode), cost);
			flights.put(number, flight);
			return true;
		}else {
			return false;
		}
	}
	
	public Flight getFlight(String number) {
		if(flights.containsKey(number)) {
			return flights.get(number);
		}
		else {
			return null;
		}
	}
	
	public List<Flight> getFlightsByOrigin(String originCode){
		List<Flight> originFlights = new ArrayList<>();
		for(Flight f: flights.values()) {
			if(f.getOrigin().getCode().equals(originCode)) {
				originFlights.add(f);
			}
		}
		return originFlights;	
	}
	
	public List<Flight> getFlightsByDestination(String destinationCode){
		List<Flight> destinationFlights = new ArrayList<>();
		for(Flight f: flights.values()) {
			if(f.getDestination().getCode().equals(destinationCode)) {
				destinationFlights.add(f);
			}
		}
		return destinationFlights;	
	}
	
	public List<Flight> getFlightsByOrigin(String originCode, String date){
		List<Flight> originFlights = new ArrayList<>();
		for(Flight f: flights.values()) {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			LocalDate d = LocalDate.parse(date, formatter);
			if((f.getOrigin().getCode().equals(originCode)) && (f.getDate().equals(d))) {
				originFlights.add(f);
			}
		}
		return originFlights;	
	}
	
	public List<Flight> getFlightsByOriginAndDestination(String originCode, String destinationCode, String date){
		List<Flight> originFlights = new ArrayList<>();
		for(Flight f: flights.values()) {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			LocalDate d = LocalDate.parse(date, formatter);
			if((f.getOrigin().getCode().equals(originCode)) && (f.getDestination().getCode().equals(destinationCode)) && (f.getDate().equals(d))) {
				originFlights.add(f);
			}
		}
		return originFlights;
	}
	
	public int getNumFlights() {
		int num = 0;
		for(Flight f: flights.values()) {
			num++;
		}
		return num;
	}
	
	public Flight removeFlight(String number) {
		return flights.remove(number);
	}
	
	public String toString() {
		String msg = "";
		for(Flight f: flights.values()) {
			msg += f + "\n";
		}
		return msg;
	}
}
