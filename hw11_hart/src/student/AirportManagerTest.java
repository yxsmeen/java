package student;

import java.io.File;
import java.util.Map;

public class AirportManagerTest {
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
		constructorTest();
		getAirportTest_Pass();
		getAirportTest_Fail();
		getAirportsTest();
		getDistanceTest();
		getDistanceBetweenTest_Code();
		getDistanceBetweenTest_Airport();
		getAirportsByCityTest_Pass();
		getAirportsByCityTest_Fail();
		getAirportsByStateTest_Pass();
		getAirportsByStateTest_Fail();
		getAirportsByCityStateTest_Pass();
		getAirportsByCityStateTest_Fail();
		getNWSNamedAirportsTest();
		getAirportsSortedByTest_City();
		getAirportsSortedByTest_State();
		getAirportsClosestToTest_Code();
		getAirportsClosestToTest_Airport();
		getAirportsWithin();
		getAirportsWithin_Both();
		getAirportsClosestToTest();
		getAirportsWithinTest_LatAndLong();
	}
	
	public static void constructorTest() {
		Map<String,Airport> airports = AirportLoader.getAirportMap(airportsSmallFile);
		AirportManager am = new AirportManager(airports);
		System.out.println("constructorTest(): ");
		System.out.println(am + "\n");
	}
	
	public static void getAirportTest_Pass() {
		Map<String,Airport> airports = AirportLoader.getAirportMap(airportsAllFile);
		AirportManager am = new AirportManager(airports);
		System.out.println("getAirportTest_Pass(): ");
		System.out.println(am.getAirport("CSG") + "\n");
	}

	public static void getAirportTest_Fail() {
		Map<String,Airport> airports = AirportLoader.getAirportMap(airportsAllFile);
		AirportManager am = new AirportManager(airports);
		System.out.println("getAirportTest_Fail(): ");
		System.out.println(am.getAirport("PPP") + "\n");
	}
	
	public static void getAirportsTest() {
		Map<String,Airport> airports = AirportLoader.getAirportMap(airportsSmallFile);
		AirportManager am = new AirportManager(airports);
		System.out.println("getAirportsTest(): ");
		System.out.println(am.getAirports() + "\n");
	}
	
	public static void getDistanceTest() {
		Map<String,Airport> airports = AirportLoader.getAirportMap(airportsSmallFile);
		AirportManager am = new AirportManager(airports);
		System.out.println("getDistanceTest(): ");
		System.out.println(String.format("%8.3f", am.getDistance(12.322, 23.123, 65.231, 21.324)) + "\n");
	}
	
	public static void getDistanceBetweenTest_Code() {
		Map<String,Airport> airports = AirportLoader.getAirportMap(airportsAllFile);
		AirportManager am = new AirportManager(airports);
		System.out.println("getDistanceBetweenTest_Code(): ");
		System.out.println(String.format("%8.3f", am.getDistanceBetween("ANB", "CSG")) + "\n");
	}
	
	public static void getDistanceBetweenTest_Airport() {
		Map<String,Airport> airports = AirportLoader.getAirportMap(airportsAllFile);
		AirportManager am = new AirportManager(airports);
		Airport a = new Airport("AAA", 34.209, 93.129, "Atlanta", "GA");
		Airport b = new Airport("BBB", 62.290, 42.453, "Boston", "MA");
		System.out.println("getDistanceBetweenTest_Airport(): ");
		System.out.println(String.format("%8.3f", am.getDistanceBetween(a, b)) + "\n");
	}
	
	public static void getAirportsByCityTest_Pass() {
		Map<String,Airport> airports = AirportLoader.getAirportMap(airportsAllFile);
		AirportManager am = new AirportManager(airports);
		System.out.println("getAirportsByCityTest_Pass(): ");
		System.out.println(am.getAirportsByCity("Greenville") + "\n");
	}
	
	public static void getAirportsByCityTest_Fail() {
		Map<String,Airport> airports = AirportLoader.getAirportMap(airportsAllFile);
		AirportManager am = new AirportManager(airports);
		System.out.println("getAirportsByCityTest_Fail(): ");
		System.out.println(am.getAirportsByCity("Yasmeen") + "\n");
	}
	
	public static void getAirportsByStateTest_Pass() {
		Map<String,Airport> airports = AirportLoader.getAirportMap(airportsAllFile);
		AirportManager am = new AirportManager(airports);
		System.out.println("getAirportsByStateTest_Pass(): ");
		System.out.println(am.getAirportsByState("DE") + "\n");
	}
	
	public static void getAirportsByStateTest_Fail() {
		Map<String,Airport> airports = AirportLoader.getAirportMap(airportsAllFile);
		AirportManager am = new AirportManager(airports);
		System.out.println("getAirportsByStateTest_Fail(): ");
		System.out.println(am.getAirportsByState("YH") + "\n");
	}
	
	public static void getAirportsByCityStateTest_Pass() {
		Map<String,Airport> airports = AirportLoader.getAirportMap(airportsAllFile);
		AirportManager am = new AirportManager(airports);
		System.out.println("getAirportsByCityStateTest_Pass(): ");
		System.out.println(am.getAirportsByCityState("Boston", "MA") + "\n");
	}
	
	public static void getAirportsByCityStateTest_Fail() {
		Map<String,Airport> airports = AirportLoader.getAirportMap(airportsAllFile);
		AirportManager am = new AirportManager(airports);
		System.out.println("getAirportsByCityStateTest_Fail(): ");
		System.out.println(am.getAirportsByCityState("Yasmeen", "YH") + "\n");
	}
	
	public static void getNWSNamedAirportsTest() {
		Map<String,Airport> airports = AirportLoader.getAirportMap(airportsMediumFile);
		AirportManager am = new AirportManager(airports);
		System.out.println("getNWSNamedAirportsTest(): ");
		System.out.println(am.getNWSNamedAirports() + "\n");
	}
	
	public static void getAirportsSortedByTest_City() {
		Map<String,Airport> airports = AirportLoader.getAirportMap(airportsSmallFile);
		AirportManager am = new AirportManager(airports);
		System.out.println("getAirportsSortedByTest_City(): ");
		System.out.println(am.getAirportsSortedBy("city") + "\n");
	}
	
	public static void getAirportsSortedByTest_State() {
		Map<String,Airport> airports = AirportLoader.getAirportMap(airportsSmallFile);
		AirportManager am = new AirportManager(airports);
		System.out.println("getAirportsSortedByTest_State(): ");
		System.out.println(am.getAirportsSortedBy("state") + "\n");
	}
	
	public static void getAirportsClosestToTest_Code() {
		Map<String,Airport> airports = AirportLoader.getAirportMap(airportsAllFile);
		AirportManager am = new AirportManager(airports);
		System.out.println("getAirportsClosestToTest_Code(): ");
		System.out.println(am.getAirportClosestTo("FNL") + "\n");
	}
	
	public static void getAirportsClosestToTest_Airport() {
		Map<String,Airport> airports = AirportLoader.getAirportMap(airportsSmallFile);
		AirportManager am = new AirportManager(airports);
		Airport a = new Airport("YAZ", 12.703, 26.473, "Austell", "GA");
		am.addAirport(a);
		System.out.println("getAirportsClosestToTest_Airport(): ");
		System.out.println(am.getAirportClosestTo(a) + "\n");
	}
	
	public static void getAirportsWithin() {
		Map<String,Airport> airports = AirportLoader.getAirportMap(airportsMediumFile);
		AirportManager am = new AirportManager(airports);
		System.out.println("getAirportsWithin(): ");
		System.out.println(am.getAirportsWithin("MGM", 50.00) + "\n");
	}
	
	public static void getAirportsWithin_Both() {
		Map<String,Airport> airports = AirportLoader.getAirportMap(airportsMediumFile);
		AirportManager am = new AirportManager(airports);
		System.out.println("getAirportsWithin_Both(): ");
		System.out.println(am.getAirportsWithin("ANB", "VLD", 150.00) + "\n");
	}

	public static void getAirportsClosestToTest() {
		Map<String,Airport> airports = AirportLoader.getAirportMap(airportsMediumFile);
		AirportManager am = new AirportManager(airports);
		System.out.println("getAirportsClosestToTest(): ");
		System.out.println("1: " + am.getAirportsClosestTo("ANB", 1));
		System.out.println("2: " + am.getAirportsClosestTo("ANB", 2));
		System.out.println("3: " + am.getAirportsClosestTo("ANB", 3) + "\n");
	}
	
	public static void getAirportsWithinTest_LatAndLong() {
		Map<String,Airport> airports = AirportLoader.getAirportMap(airportsMediumFile);
		AirportManager am = new AirportManager(airports);
		System.out.println("getAirportsWithinTest_LatAndLong(): ");
		System.out.println(am.getAirportsWithin(50.00, 23.322, 45.234) + "\n");
	}
	
}
