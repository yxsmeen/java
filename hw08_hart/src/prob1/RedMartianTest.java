package prob1;

public class RedMartianTest {
	public static void main(String[] args) {
		testSpeakAndToString();
		testEquals_Success();
		testEquals_Fail();
		testCompareTo_Negative();
		testCompareTo_Positive();
		testCompareTo_Zero();
	}
	
	//check that the format is realized
	//toString method for MartianManager will be the same as
	//RedMartian and GreenMartian
	public static void testSpeakAndToString() {
		System.out.println("-->testSpeakAndTeleportAndToString");
		GreenMartian gm = new GreenMartian(123, 4);
		RedMartian rm = new RedMartian(321, 7);
		System.out.println("Green Martian:");
		System.out.println(gm.speak());
		System.out.println(gm.toString());
		System.out.println("Red Martian:");
		System.out.println(rm.speak());
		System.out.println(rm.toString());
	}
	
	//create two reds with the same id
	//return should be true
	public static void testEquals_Success() {
		System.out.println("\n-->testEquals_Success()");
		RedMartian red1 = new RedMartian(123, 4);
		RedMartian red2 = new RedMartian(123, 6);
		System.out.println("Expected outcome: true");
		System.out.println("Actual outcome: " + red1.equals(red2));
	}
	
	//create two reds with different ids
	//return should be false
	public static void testEquals_Fail() {
		System.out.println("\n-->testEquals_Fail()");
		RedMartian red1 = new RedMartian(123, 4);
		RedMartian red2 = new RedMartian(456, 6);
		System.out.println("Expected outcome: false");
		System.out.println("Actual outcome: " + red1.equals(red2));
	}
	
	//create two reds where the first is less than the second
	//return should be negative
	public static void testCompareTo_Negative() {
		System.out.println("\n-->testCompareTo_Negative()");
		RedMartian red1 = new RedMartian(123, 4);
		RedMartian red2 = new RedMartian(456, 6);
		System.out.println("Expected outcome: negative");
		System.out.println("Actual outcome: " + red1.compareTo(red2));
	}
	
	//create two reds where the first is greater than the second
	//return should be positive
	public static void testCompareTo_Positive() {
		System.out.println("\n-->testCompareTo_Positive()");
		RedMartian red1 = new RedMartian(456, 4);
		RedMartian red2 = new RedMartian(123, 6);
		System.out.println("Expected outcome: positive");
		System.out.println("Actual outcome: " + red1.compareTo(red2));
	}
	
	//create two reds with the same id
	//return should be zero
	public static void testCompareTo_Zero() {
		System.out.println("\n-->testCompareTo_Zero()");
		RedMartian red1 = new RedMartian(123, 4);
		RedMartian red2 = new RedMartian(123, 6);
		System.out.println("Expected outcome: 0");
		System.out.println("Actual outcome: " + red1.compareTo(red2));
	}
}
