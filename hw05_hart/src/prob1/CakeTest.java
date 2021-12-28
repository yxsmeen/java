package prob1;

public class CakeTest {
	public static void main(String[] args) {
		//test classic yellow cake
		Cake classicYellow = new ClassicYellowCake("Duncan Hines Classic Yellow Cake Mix");
		System.out.println("Classic Yellow Cake");
		System.out.println("-------------------");
		System.out.println(classicYellow.makeCake());
		
		//test high altitude classic yellow cake
		Cake highAltitudeClassicYellow = new HighAltitudeClassicYellowCake("Duncan Hines Classic Yellow Cake Mix");
		System.out.println("\nHigh Altitude Classic Yellow Cake");
		System.out.println("----------------------------------");
		System.out.println(highAltitudeClassicYellow.makeCake());
		
		//test organic cake
		Cake organicVanilla = new OrganicCake("Organic Vanilla Cake Mix");
		System.out.println("\nOrganic Vanilla Cake");
		System.out.println("----------------------");
		System.out.println(organicVanilla.makeCake());
	}
}
