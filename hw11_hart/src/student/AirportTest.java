package student;

public class AirportTest {

	public static void main(String[] args) {
		testEq1();
		testEq2();
	}
	
	public static void testEq1() {
		Airport a = new Airport("ATL", 10.42, 12.56, "Atlanta", "GA");
		Airport b = new Airport("ATL", 42.34, 19.02, "Seattle", "WA");
		System.out.println(a.equals(b));
	}
	
	public static void testEq2() {
		Airport a = new Airport("ATL", 10.42, 12.56, "Atlanta", "GA");
		Airport b = new Airport("SEA", 42.34, 19.02, "Seattle", "WA");
		System.out.println(a.equals(b));
	}

}
