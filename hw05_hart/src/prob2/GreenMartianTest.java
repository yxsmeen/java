package prob2;

public class GreenMartianTest {
	public static void main(String[] args) {
		testSpeakAndTeleportAndToString();
		testEquals_Success();
		testEquals_Fail();
		testEqualsRedAndGreenSuccess();
		testCompareToRedAndGreenSuccess();
	}
	
	//check that the format is realized
	//toString method for MartianManager will be the same as
	//RedMartian and GreenMartian
	public static void testSpeakAndTeleportAndToString() {
		System.out.println("-->testSpeakAndTeleportAndToString");
		GreenMartian gm = new GreenMartian(123, 4);
		RedMartian rm = new RedMartian(321, 7);
		System.out.println("Green Martian:");
		System.out.println(gm.speak());
		System.out.println(gm.teleport("Seattle"));
		System.out.println(gm.toString());
		System.out.println("Red Martian:");
		System.out.println(rm.speak());
		System.out.println(rm.toString());
	}
		
	//create two greens with the same id
	//return should be true
	public static void testEquals_Success() {
		System.out.println("\n-->testEquals_Success()");
		GreenMartian green1 = new GreenMartian(123, 4);
		GreenMartian green2 = new GreenMartian(123, 6);
		System.out.println("Expected outcome: true");
		System.out.println("Actual outcome: " + green1.equals(green2));
	}
		
	//create two greens with different ids
	//return should be false
	public static void testEquals_Fail() {
		System.out.println("\n-->testEquals_Fail()");
		GreenMartian green1 = new GreenMartian(123, 4);
		GreenMartian green2 = new GreenMartian(456, 6);
		System.out.println("Expected outcome: false");
		System.out.println("Actual outcome: " + green1.equals(green2));
	}
		
	//create a red and a green with the same id
	//return should be true
	public static void testEqualsRedAndGreenSuccess() {
		System.out.println("\n-->testEqualsRedAndGreenSuccess()");
		GreenMartian green = new GreenMartian(123, 4);
		RedMartian red = new RedMartian(123, 6);
		System.out.println("Expected outcome: true");
		System.out.println("Actual outcome: " + green.equals(red));
	}
	
	//create a red and green where the first is greater than the second
	//return should be positive
	public static void testCompareToRedAndGreenSuccess() {
		System.out.println("\n-->testCompareToRedAndGreenSuccess()");
		GreenMartian green = new GreenMartian(456, 4);
		RedMartian red = new RedMartian(123, 6);
		System.out.println("Expected outcome: positive");
		System.out.println("Actual outcome: " + green.compareTo(red));
	}
	
	}
