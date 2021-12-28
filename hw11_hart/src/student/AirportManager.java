package student;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AirportManager {
	private Map<String, Airport> airportsMap = new HashMap<String, Airport>();
	
	public AirportManager(Map<String, Airport> airportsMap) {
		this.airportsMap = airportsMap;
	}
	
	public Airport getAirport(String code) {
		Airport a = null;
		if(airportsMap.containsKey(code)) {
			a = airportsMap.get(code);
			return a;
		}
		return a;
	}

	public List<Airport> getAirports(){
		List<Airport> airports = new ArrayList<Airport>();
		for(Airport a: airportsMap.values()) {
			airports.add(a);
		}
		return airports;
	}
	
	public boolean addAirport(Airport a) {
		for(Airport b: airportsMap.values()) {
			if(a.getCode().equals(b.getCode())) {
				return false;
			}
		}
		airportsMap.put(a.getCode(), a);
		return true;
	}
	
	public double getDistance(double lat1, double long1, double lat2, double long2) {
		return DistanceCalculator.getDistance(lat1, long1, lat2, long2);
	}
	
	public double getDistanceBetween(Airport airport1, Airport airport2) {
		return DistanceCalculator.getDistance(airport1.getLatitude(), airport1.getLongitude(), airport2.getLatitude(), airport2.getLongitude());
	}
	
	public double getDistanceBetween(String code1, String code2) {
		return getDistanceBetween(getAirport(code1), getAirport(code2));
	}
	
	public List<Airport> getAirportsByCity(String city){
		List<Airport> cities = new ArrayList<Airport>();
		for(Airport a: airportsMap.values()) {
			String currCity = a.getCity();
			if(!currCity.equals(city)) {
				continue;
			}else {
				cities.add(a);
			}
		}
		if(cities.size() == 0) {
			return null;
		}
		return cities;
	}
	
	public List<Airport> getAirportsByState(String state){
		List<Airport> states = new ArrayList<Airport>();
		for(Airport a: airportsMap.values()) {
			String currState = a.getState();
			if(!currState.equals(state)) {
				continue;
			}else {
				states.add(a);
			}
		}
		if(states.size() == 0) {
			return null;
		}
		return states;
	}
	
	public List<Airport> getAirportsByCityState(String city, String state){
		List<Airport> other = new ArrayList<Airport>();
		for(Airport a: airportsMap.values()) {
			String currCity = a.getCity();
			String currState = a.getState();
			if(!(currState.equals(state)) || !(currCity.equals(city))) {
				continue;
			}else {
				other.add(a);
			}
		}
		if(other.size() == 0) {
			return null;
		}
		return other;
	}
	
	public List<Airport> getNWSNamedAirports(){
		List<Airport> nwsNamed = new ArrayList<Airport>();
		for(Airport a: airportsMap.values()) {
			if(!(a.getCode().substring(2).equals("X"))) {
				continue;
			}else {
				nwsNamed.add(a);
			}
		}
		return nwsNamed;
	}
	
	public List<Airport> getAirportsSortedBy(String sortBy){
		List<Airport> sorted = new ArrayList<Airport>();
		for(Airport a: airportsMap.values()) {
			sorted.add(a);
		}
		sortBy.toLowerCase();
		if(sortBy.equals("city")) {
			sorted.sort(new AirportCityComparator());
		}else if(sortBy.equals("state")) {
			sorted.sort(new AirportStateComparator());
		}
		return sorted;
	}
	
	public Airport getAirportClosestTo(String code) {
		Airport test = getAirport(code);
		double d = 2108293;
		Airport b = null;
		for(Airport a: airportsMap.values()) {
			if(a.equals(test)) {
				continue;
			}
			double dist = getDistanceBetween(test, a);
			if(dist < d) {
				d = dist;
				b = a;
			}
		}
		return b;
	}
	
	public Airport getAirportClosestTo(Airport a) {
		return getAirportClosestTo(a.getCode());
	}

	public List<Airport> getAirportsClosestTo(String code, int num){
		Map<Double, Airport> distMap = new HashMap<>(getDistanceMap(code));
		List<Double> distList = new ArrayList<>(getDistances(code));
		List<Airport> list = new ArrayList<>();
		distList.sort(new AirportDistanceComparator());
		for(int i = 0; i < num; i++) {
				Airport a = distMap.get(distList.get(i));
				list.add(a);
		}
		return list;
	}
	
	public List<Double> getDistances(Airport a) {
		List<Double> dist = new ArrayList<>();
		for(Airport b: airportsMap.values()) {
			double d = getDistanceBetween(a, b);
			dist.add(d);
		}
		return dist;
	}
	
	public List<Double> getDistances(String code) {
		List<Double> dist = new ArrayList<>();
		for(Airport a: airportsMap.values()) {
			double d = getDistanceBetween(a.getCode(), code);
			dist.add(d);
		}
		return dist;
	}
	
	public Map<Double, Airport> getDistanceMap(String code){
		Map<Double, Airport> distMap = new HashMap<>();
		List<Double> distances = new ArrayList<>(getDistances(code));
		List<Airport> airports = new ArrayList<>();
		for(Airport a: airportsMap.values()) {
			airports.add(a);
		}
		for(int i = 0; i < distances.size(); i++) {
			distMap.put(distances.get(i), airports.get(i));
		}
		return distMap;
	}
	
	public List<Airport> getAirportsWithin(String code, double distance){
		List<Airport> aps = new ArrayList<>();
		Map<Double, Airport> distMap = new HashMap<>(getDistanceMap(code));
		for(double dist: distMap.keySet()) {
			if(dist < distance) {
				aps.add(distMap.get(dist));
			}
		}
		return aps;
	}
	
	public List<Airport> getAirportsWithin(String code1, String code2, double withinDist){
		List<Airport> within = new ArrayList<>();
		for(Airport a: airportsMap.values()) {
			if((getAirportsWithin(code1, withinDist).contains(a)) && (getAirportsWithin(code2, withinDist).contains(a))) {
				within.add(a);
			}
		}
		return within;
	}

	public List<Airport> getAirportsWithin(double dist, double lat, double lon){
		Airport dummy = new Airport("TST", lat, lon, "Test", "EX");
		airportsMap.put(dummy.getCode(), dummy);
		return getAirportsWithin("TST", dist);
	}
	
	public String toString() {
		return String.format("Airport Manager: " + airportsMap);
	}	
	
}