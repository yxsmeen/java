package student;

import java.io.File;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class FlightManagerTest {

	static final String path = "src/student/";
	static final String airportsSmallFileName = path + "airportsSmall.txt";
	static final String airportsMediumFileName = path + "airportsMedium.txt";
	static final String airportsSameCitiesFileName = path + "airportsSameCities.txt";
	static final String airportsAllFileName = path + "airports.txt";
	static final File airportsSmallFile = new File(airportsSmallFileName);
	static final File airportsMediumFile = new File(airportsMediumFileName);
	static final File airportsSameCitiesFile = new File(airportsSameCitiesFileName);
	static final File airportsAllFile = new File(airportsAllFileName);
	
	public static void main(String[] args) {
		constructorAndAddFlightTest();
		addFlightTest_Sec();
		getFlightTest();
		getFlightsByOriginTest();
		getFlightsByDestinationTest();
		getFlightsByOriginAndDateTest();
		getFlightsByOriginAndDestinationTest();
		getNumFlightsTest();
		removeFlightsTest();
	}

	public static void constructorAndAddFlightTest() {
		Map<String,Airport> airports = AirportLoader.getAirportMap(airportsSmallFile);
		AirportManager am = new AirportManager(airports);
		FlightManager fm = new FlightManager(am);
		
		Airport a = new Airport("BOS", 123.21, 23.234, "Boston", "MA");
		Airport b = new Airport("LAX", 125.34, 45.345, "Los Angeles", "CA");
		Flight f1 = new Flight("1273", LocalDate.of(2021, 01, 27), a, b, 127.03);
		
		Airport c = new Airport("ATL", 323.264, 39.230, "Atlanta", "GA");
		Airport d = new Airport("DFW", 29.129, 129.393, "Dallas", "TX");
		Flight f2 = new Flight("3819", LocalDate.of(2021, 01, 27), c, d, 127.03);
		
		fm.addFlight(f1);
		fm.addFlight(f2);
		System.out.println("constructorAndAddFlightTest(): ");
		System.out.println(fm);
	}
	
	public static void addFlightTest_Sec() {
		Map<String,Airport> airports = AirportLoader.getAirportMap(airportsSmallFile);
		AirportManager am = new AirportManager(airports);
		FlightManager fm = new FlightManager(am);

		fm.addFlight("8293", "2021-12-25", "CSG", "HSV", 202.54);
		fm.addFlight("4893", "2021-12-07", "ANB", "MXF", 239.29);
		
		System.out.println("addFlightTest_Sec(): ");
		System.out.println(fm );
	}
	
	public static void getFlightTest() {
		Map<String,Airport> airports = AirportLoader.getAirportMap(airportsSmallFile);
		AirportManager am = new AirportManager(airports);
		FlightManager fm = new FlightManager(am);

		fm.addFlight("8293", "2021-12-25", "CSG", "HSV", 202.54);
		fm.addFlight("4893", "2021-12-07", "ANB", "MXF", 239.29);
		
		System.out.println("getFlightTest: ");
		System.out.println(fm.getFlight("8293") + "\n");
	}
	
	public static void getFlightsByOriginTest() {
		Map<String,Airport> airports = AirportLoader.getAirportMap(airportsSmallFile);
		AirportManager am = new AirportManager(airports);
		FlightManager fm = new FlightManager(am);

		fm.addFlight("8293", "2021-12-25", "CSG", "HSV", 202.54);
		fm.addFlight("4893", "2021-12-07", "ANB", "MXF", 239.29);
		fm.addFlight("8932", "2021-12-16", "CSG", "VLD", 392.12);
		
		System.out.println("getFlightsByOrigin(): ");
		System.out.println(fm.getFlightsByOrigin("CSG") + "\n\n");
	}
	
	public static void getFlightsByDestinationTest() {
		Map<String,Airport> airports = AirportLoader.getAirportMap(airportsSmallFile);
		AirportManager am = new AirportManager(airports);
		FlightManager fm = new FlightManager(am);

		fm.addFlight("8293", "2021-12-25", "CSG", "HSV", 202.54);
		fm.addFlight("4893", "2021-12-07", "ANB", "MXF", 239.29);
		fm.addFlight("8932", "2021-12-16", "CSG", "VLD", 392.12);
		
		System.out.println("getFlightsByDestination(): ");
		System.out.println(fm.getFlightsByDestination("MXF") + "\n\n");
	}
	
	public static void getFlightsByOriginAndDateTest() {
		Map<String,Airport> airports = AirportLoader.getAirportMap(airportsSmallFile);
		AirportManager am = new AirportManager(airports);
		FlightManager fm = new FlightManager(am);

		fm.addFlight("8293", "2021-12-25", "CSG", "HSV", 202.54);
		fm.addFlight("4893", "2021-12-07", "ANB", "MXF", 239.29);
		fm.addFlight("8932", "2021-12-16", "CSG", "VLD", 392.12);
		
		System.out.println("getFlightsByOriginAndDate(): ");
		System.out.println(fm.getFlightsByOrigin("CSG", "2021-12-16") + "\n");
	}
	
	public static void getFlightsByOriginAndDestinationTest() {
		Map<String,Airport> airports = AirportLoader.getAirportMap(airportsSmallFile);
		AirportManager am = new AirportManager(airports);
		FlightManager fm = new FlightManager(am);

		fm.addFlight("8293", "2021-12-25", "CSG", "HSV", 202.54);
		fm.addFlight("4893", "2021-12-07", "ANB", "MXF", 239.29);
		fm.addFlight("8932", "2021-12-16", "CSG", "VLD", 392.12);
		
		System.out.println("getFlightsByOriginAndDestination(): ");
		System.out.println(fm.getFlightsByOriginAndDestination("CSG", "HSV", "2021-12-25") + "\n\n");
	}
	
	public static void getNumFlightsTest() {
		Map<String,Airport> airports = AirportLoader.getAirportMap(airportsSmallFile);
		AirportManager am = new AirportManager(airports);
		FlightManager fm = new FlightManager(am);

		fm.addFlight("8293", "2021-12-25", "CSG", "HSV", 202.54);
		fm.addFlight("4893", "2021-12-07", "ANB", "MXF", 239.29);
		fm.addFlight("8932", "2021-12-16", "CSG", "VLD", 392.12);
		
		System.out.println("getNumFlights(): ");
		System.out.println(fm.getNumFlights() + "\n");
	}
	
	public static void removeFlightsTest() {
		Map<String,Airport> airports = AirportLoader.getAirportMap(airportsSmallFile);
		AirportManager am = new AirportManager(airports);
		FlightManager fm = new FlightManager(am);

		fm.addFlight("8293", "2021-12-25", "CSG", "HSV", 202.54);
		fm.addFlight("4893", "2021-12-07", "ANB", "MXF", 239.29);
		fm.addFlight("8932", "2021-12-16", "CSG", "VLD", 392.12);
		
		System.out.println("removeFlightsTest(): ");
		System.out.println(fm.getNumFlights());
		System.out.println(fm.removeFlight("8932"));
		System.out.println(fm.getNumFlights() + "\n\n");
	}
}
