package student;

import java.time.LocalDate;

public class FlightTest {

	public static void main(String[] args) {
		constructorTest();
		getNumberTest();
		getDateTest();
		getOriginTest();
		getDestinationTest();
		getCostTest();
		getDistanceTest();
	}
	
	public static void constructorTest() {
		Airport a = new Airport("BOS", 123.21, 23.234, "Boston", "MA");
		Airport b = new Airport("LAX", 125.34, 45.345, "Boston", "MA");
		Flight f = new Flight("1273", LocalDate.of(2021, 01, 27), a, b, 127.03);
		System.out.println("constructorTest()");
		System.out.println(f + "\n");
	}

	public static void getNumberTest() {
		Airport a = new Airport("BOS", 123.21, 23.234, "Boston", "MA");
		Airport b = new Airport("LAX", 125.34, 45.345, "Boston", "MA");
		Flight f = new Flight("1273", LocalDate.of(2021, 01, 27), a, b, 127.03);
		System.out.println("getNumberTest()");
		System.out.println(f.getNumber() + "\n");
	}
	
	public static void getDateTest() {
		Airport a = new Airport("BOS", 123.21, 23.234, "Boston", "MA");
		Airport b = new Airport("LAX", 125.34, 45.345, "Boston", "MA");
		Flight f = new Flight("1273", LocalDate.of(2021, 01, 27), a, b, 127.03);
		System.out.println("getDateTest()");
		System.out.println(f.getDate() + "\n");
	}
	
	public static void getOriginTest() {
		Airport a = new Airport("BOS", 123.21, 23.234, "Boston", "MA");
		Airport b = new Airport("LAX", 125.34, 45.345, "Boston", "MA");
		Flight f = new Flight("1273", LocalDate.of(2021, 01, 27), a, b, 127.03);
		System.out.println("getOriginTest()");
		System.out.println(f.getOrigin() + "\n");
	}
	
	public static void getDestinationTest() {
		Airport a = new Airport("BOS", 123.21, 23.234, "Boston", "MA");
		Airport b = new Airport("LAX", 125.34, 45.345, "Boston", "MA");
		Flight f = new Flight("1273", LocalDate.of(2021, 01, 27), a, b, 127.03);
		System.out.println("getDestinationTest()");
		System.out.println(f.getDestination() + "\n");
	}
	
	public static void getCostTest() {
		Airport a = new Airport("BOS", 123.21, 23.234, "Boston", "MA");
		Airport b = new Airport("LAX", 125.34, 45.345, "Boston", "MA");
		Flight f = new Flight("1273", LocalDate.of(2021, 01, 27), a, b, 127.03);
		System.out.println("getCostTest()");
		System.out.println(f.getCost() + "\n");
	}
	
	public static void getDistanceTest() {
		Airport a = new Airport("BOS", 123.21, 23.234, "Boston", "MA");
		Airport b = new Airport("LAX", 125.34, 45.345, "Boston", "MA");
		Flight f = new Flight("1273", LocalDate.of(2021, 01, 27), a, b, 127.03);
		System.out.println("getDistanceTest()");
		System.out.println(f.getDistance() + "\n");
	}
}
