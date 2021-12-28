package prob2;
import java.util.ArrayList;

public class MartianManagerTest {

	public static void main(String[] args) {
		addMartian_Red_Success();
		addMartian_Green_Success();
		addMartian_RedGreen_Failure();
		addMartian_GreenRed_Failure();
		testContains_Success();
		testContains_Failure();
		testGetMartianAt_ValidIndex();
		testGetMartianAt_InvalidIndex_Low();
		testGetMartianAt_InvalidIndex_High();
		testGetMartianClosestTo_Index_LowerMatch();
		testGetMartianClosestTo_Index_HigherMatch();
		testGetMartianClosestTo_Martian_LowerMatch();
		testGetMartianWithId_Success();
		testGetMartianWithId_Failure();
		getSortedMartians();
		testGetTeleporterAt_ValidIndex();
		testGetTeleporterAt_InvalidIndex_Low();
		testGetTeleporterAt_InvalidIndex_High();
		testGroupSpeak();
		testGroupTeleport();
		testObliterateTeleporters_One();
		testObliterateTeleporters_Many();
		testRemoveMartianWithId_Success_Red();
		testRemoveMartianWithId_Success_Green();
		testRemoveMartianWithId_Failure();
		testToString();
		testBattle_Small();
	}

	//add red and verify that there's only one martian
	//no teleporters
	public static void addMartian_Red_Success() {
		System.out.println("-->addMartian_Red_Success()");
		RedMartian m = new RedMartian(450, 17, 15);
		MartianManager martians = new MartianManager();
		martians.addMartian(m);
		System.out.println(martians);
	}
	
	//add green and verify that there's only one martian
	//one teleporter
	public static void addMartian_Green_Success() {
		System.out.println("-->addMartian_Green_Success()");
		GreenMartian m = new GreenMartian(020, 5);
		MartianManager martians = new MartianManager();
		martians.addMartian(m);
		System.out.println(martians);	
	}
	
	//add a red and green with the same id, verify one martian
	//no teleporters
	public static void addMartian_RedGreen_Failure() {
		System.out.println("-->addMartian_RedGreen_Failure()");
		RedMartian rm = new RedMartian(123, 5);
		GreenMartian gm = new GreenMartian(123, 3);
		MartianManager martians = new MartianManager();
		martians.addMartian(rm);
		martians.addMartian(gm);
		System.out.println(martians);	
	}
	
	//add a green and red with the same id, verify one martian
	//one teleporter
	public static void addMartian_GreenRed_Failure() {
		System.out.println("-->addMartian_GreenRed_Failure()");
		RedMartian rm = new RedMartian(456, 5);
		GreenMartian gm = new GreenMartian(456, 5);
		MartianManager martians = new MartianManager();
		martians.addMartian(gm);
		martians.addMartian(rm);
		System.out.println(martians);	
	}
	
	//add a few, ask if it contains a martian with an id that does exist
	//FIX
	public static void testContains_Success() {
		System.out.println("-->testContains_Success()");
		RedMartian m1 = new RedMartian(123, 5);
		GreenMartian m2 = new GreenMartian(456, 4);
		GreenMartian m3 = new GreenMartian(789, 3);
		MartianManager martians = new MartianManager();
		martians.addMartian(m1);
		martians.addMartian(m2);
		martians.addMartian(m3);
		System.out.println("Expected outcome: true");
		System.out.println("Actual outcome: " + martians.contains(456));
	}
	
	//add a few, ask if it contains a martian with an id that doesn't exist
	public static void testContains_Failure() {
		System.out.println("\n-->testContains_Failure()");
		RedMartian m1 = new RedMartian(123, 5);
		GreenMartian m2 = new GreenMartian(456, 4);
		GreenMartian m3 = new GreenMartian(789, 3);
		MartianManager martians = new MartianManager();
		martians.addMartian(m1);
		martians.addMartian(m2);
		martians.addMartian(m3);
		System.out.println("Expected outcome: false");
		System.out.println("Actual outcome: " + martians.contains(999));
	}
	
	//add 4 martians, call one with a valid index
	public static void testGetMartianAt_ValidIndex() {
		System.out.println("\n-->testGetMartianAt_ValidIndex()");
		RedMartian m1 = new RedMartian(123, 5);
		GreenMartian m2 = new GreenMartian(456, 4);
		GreenMartian m3 = new GreenMartian(789, 3);
		RedMartian m4 = new RedMartian(101, 77, 4);
		MartianManager martians = new MartianManager();
		martians.addMartian(m1);
		martians.addMartian(m2);
		martians.addMartian(m3);
		martians.addMartian(m4);
		System.out.println("Expected outcome: Green Martian - id: 789, volume: 3");
		System.out.println("Actual outcome:   " + martians.getMartianAt(2));
	}
	
	//add 4 martians, call one with a negative index
	public static void testGetMartianAt_InvalidIndex_Low() {
		System.out.println("\n-->testGetMartianAt_InvalidIndex_Low()");
		RedMartian m1 = new RedMartian(123, 5);
		GreenMartian m2 = new GreenMartian(456, 4);
		GreenMartian m3 = new GreenMartian(789, 3);
		RedMartian m4 = new RedMartian(101, 77, 4);
		MartianManager martians = new MartianManager();
		martians.addMartian(m1);
		martians.addMartian(m2);
		martians.addMartian(m3);
		martians.addMartian(m4);
		System.out.println("Expected outcome: null");
		System.out.println("Actual outcome:   " + martians.getMartianAt(-4));
	}
	
	//add 4 martians, call one with index >= list size
	public static void testGetMartianAt_InvalidIndex_High() {
		System.out.println("\n-->testGetMartianAt_InvalidIndex_High()");
		RedMartian m1 = new RedMartian(123, 5);
		GreenMartian m2 = new GreenMartian(456, 4);
		GreenMartian m3 = new GreenMartian(789, 3);
		RedMartian m4 = new RedMartian(101, 77, 4);
		MartianManager martians = new MartianManager();
		martians.addMartian(m1);
		martians.addMartian(m2);
		martians.addMartian(m3);
		martians.addMartian(m4);
		System.out.println("Expected outcome: null");
		System.out.println("Actual outcome:   " + martians.getMartianAt(9));
	}
	
	//add 2 reds & 2 greens with ids: 1, 3, 8, 13
	//search for id = 6, return id = 8
	public static void testGetMartianClosestTo_Index_LowerMatch() {
		System.out.println("\n-->testGetMartianClosestTo_Index_LowerMatch()");
		RedMartian m1 = new RedMartian(1, 5);
		GreenMartian m2 = new GreenMartian(3, 4);
		GreenMartian m3 = new GreenMartian(8, 3);
		RedMartian m4 = new RedMartian(13, 77, 4);
		MartianManager martians = new MartianManager();
		martians.addMartian(m1);
		martians.addMartian(m2);
		martians.addMartian(m3);
		martians.addMartian(m4);
		System.out.println("Search for id: 6");
		System.out.println("Expected outcome: Green Martian - id: 8, volume: 3");
		System.out.println("Actual outcome:   " + martians.getMartianClosestTo(6));
	}
	
	//add 2 reds & 2 greens with ids: 1, 3, 8, 13
	//search for id = 4, return id = 3
	public static void testGetMartianClosestTo_Index_HigherMatch() {
		System.out.println("\n-->testGetMartianClosestTo_Index_LowerMatch()");
		RedMartian m1 = new RedMartian(1, 5);
		GreenMartian m2 = new GreenMartian(3, 4);
		GreenMartian m3 = new GreenMartian(8, 3);
		RedMartian m4 = new RedMartian(13, 77, 4);
		MartianManager martians = new MartianManager();
		martians.addMartian(m1);
		martians.addMartian(m2);
		martians.addMartian(m3);
		martians.addMartian(m4);
		System.out.println("Search for id: 4");
		System.out.println("Expected outcome: Green Martian - id: 3, volume: 4");
		System.out.println("Actual outcome:   " + martians.getMartianClosestTo(4));
	}
	
	//add 2 reds & 2 greens with ids: 1, 3, 8, 13
	//search for a martian with id = 6, return martian with id = 8
	public static void testGetMartianClosestTo_Martian_LowerMatch() {
		System.out.println("\n-->testGetMartianClosestTo_Martian_LowerMatch()");
		RedMartian m1 = new RedMartian(1, 5);
		GreenMartian m2 = new GreenMartian(3, 4);
		GreenMartian m3 = new GreenMartian(8, 3);
		RedMartian m4 = new RedMartian(13, 77, 4);
		RedMartian search = new RedMartian(6, 24);
		MartianManager martians = new MartianManager();
		martians.addMartian(m1);
		martians.addMartian(m2);
		martians.addMartian(m3);
		martians.addMartian(m4);
		System.out.println("Search for id: 6");
		System.out.println("Expected outcome: Green Martian - id: 8, volume: 3");
		System.out.println("Actual outcome:   " + martians.getMartianClosestTo(search));
	}
	
	//add 4, call with an id that exists
	public static void testGetMartianWithId_Success() {
		System.out.println("\n-->testGetMartianWithId_Success()");
		RedMartian m1 = new RedMartian(1, 5);
		GreenMartian m2 = new GreenMartian(3, 4);
		GreenMartian m3 = new GreenMartian(8, 3);
		RedMartian m4 = new RedMartian(13, 77, 4);
		MartianManager martians = new MartianManager();
		martians.addMartian(m1);
		martians.addMartian(m2);
		martians.addMartian(m3);
		martians.addMartian(m4);
		System.out.println("Expected outcome: Red Martian - id: 13, volume: 77, tenacity: 4");
		System.out.println("Actual outcome:   " + martians.getMartianWithId(13));
	}
	
	//add 4, call with an id that does not exist
	public static void testGetMartianWithId_Failure() {
		System.out.println("\n-->testGetMartianWithId_Failure()");
		RedMartian m1 = new RedMartian(1, 5);
		GreenMartian m2 = new GreenMartian(3, 4);
		GreenMartian m3 = new GreenMartian(8, 3);
		RedMartian m4 = new RedMartian(13, 77, 4);
		MartianManager martians = new MartianManager();
		martians.addMartian(m1);
		martians.addMartian(m2);
		martians.addMartian(m3);
		martians.addMartian(m4);
		System.out.println("Expected outcome: null");
		System.out.println("Actual outcome:   " + martians.getMartianWithId(999));
	}
	
	//add 4 with ids in this order: 4, 8, 1, 2
	//verify that it is sorted and order is preserved in the internal arraylist
	public static void getSortedMartians() {
		System.out.println("\n-->getSortedMartians()");
		RedMartian m1 = new RedMartian(4, 5);
		GreenMartian m2 = new GreenMartian(8, 4);
		GreenMartian m3 = new GreenMartian(1, 3);
		RedMartian m4 = new RedMartian(2, 77, 4);
		MartianManager martians = new MartianManager();
		martians.addMartian(m1);
		martians.addMartian(m2);
		martians.addMartian(m3);
		martians.addMartian(m4);
		System.out.println("Expected outcome: id: 1, 2, 4, 8");
		System.out.println("Actual outcome:   " + martians.getSortedMartians());
	}
	
	//add 6 martians with 4 being green
	//call for valid index for teleporters
	public static void testGetTeleporterAt_ValidIndex() {
		System.out.println("\n-->testGetTeleporterAt_ValidIndex()");
		RedMartian m1 = new RedMartian(4, 5);
		GreenMartian m2 = new GreenMartian(8, 4);
		GreenMartian m3 = new GreenMartian(1, 3);
		RedMartian m4 = new RedMartian(2, 77, 4);
		GreenMartian m5 = new GreenMartian(43, 7);
		GreenMartian m6 = new GreenMartian(12, 2);
		MartianManager martians = new MartianManager();
		martians.addMartian(m1);
		martians.addMartian(m2);
		martians.addMartian(m3);
		martians.addMartian(m4);
		martians.addMartian(m5);
		martians.addMartian(m6);
		System.out.println("Expected outcome: Green Martian - id: 43, volume: 7");
		System.out.println("Actual outcome:   " + martians.getTeleporterAt(2));
	}
	
	//add 6 martians with 4 being green
	//call for negative index
	public static void testGetTeleporterAt_InvalidIndex_Low() {
		System.out.println("\n-->testGetTeleporterAt_InvalidIndex_Low()");
		RedMartian m1 = new RedMartian(4, 5);
		GreenMartian m2 = new GreenMartian(8, 4);
		GreenMartian m3 = new GreenMartian(1, 3);
		RedMartian m4 = new RedMartian(2, 77, 4);
		GreenMartian m5 = new GreenMartian(43, 7);
		GreenMartian m6 = new GreenMartian(12, 2);
		MartianManager martians = new MartianManager();
		martians.addMartian(m1);
		martians.addMartian(m2);
		martians.addMartian(m3);
		martians.addMartian(m4);
		martians.addMartian(m5);
		martians.addMartian(m6);
		System.out.println("Expected outcome: null");
		System.out.println("Actual outcome:   " + martians.getTeleporterAt(-4));
		
	}
	
	//add 6 martians with 4 being green
	//call for index >= list size
	public static void testGetTeleporterAt_InvalidIndex_High() {
		System.out.println("\n-->testGetTeleporterAt_InvalidIndex_High()");
		RedMartian m1 = new RedMartian(4, 5);
		GreenMartian m2 = new GreenMartian(8, 4);
		GreenMartian m3 = new GreenMartian(1, 3);
		RedMartian m4 = new RedMartian(2, 77, 4);
		GreenMartian m5 = new GreenMartian(43, 7);
		GreenMartian m6 = new GreenMartian(12, 2);
		MartianManager martians = new MartianManager();
		martians.addMartian(m1);
		martians.addMartian(m2);
		martians.addMartian(m3);
		martians.addMartian(m4);
		martians.addMartian(m5);
		martians.addMartian(m6);
		System.out.println("Expected outcome: null");
		System.out.println("Actual outcome:   " + martians.getTeleporterAt(8));
	}
	
	//add 2 reds and 1 green, verify output format
	public static void testGroupSpeak() {
		System.out.println("\n-->testGroupSpeak()");
		RedMartian m1 = new RedMartian(4, 5);
		GreenMartian m2 = new GreenMartian(8, 4);
		RedMartian m3 = new RedMartian(1, 3);
		MartianManager martians = new MartianManager();
		martians.addMartian(m1);
		martians.addMartian(m2);
		martians.addMartian(m3);
		System.out.println("Expected outcome: Rubldy Rock, Grobldy Grock, Rubldy Rock");
		System.out.println("Actual outcome: \n" + martians.groupSpeak());
	}
	
	//add 1 red and 3 greens, verify output format
	public static void testGroupTeleport() {
		System.out.println("\n-->testGroupTeleport()");
		RedMartian m1 = new RedMartian(4, 5);
		GreenMartian m2 = new GreenMartian(8, 4);
		GreenMartian m3 = new GreenMartian(1, 3);
		GreenMartian m4 = new GreenMartian(12, 3);
		MartianManager martians = new MartianManager();
		martians.addMartian(m1);
		martians.addMartian(m2);
		martians.addMartian(m3);
		martians.addMartian(m4);
		System.out.println("Expected outcome: teleporting to Italy");
		System.out.println("Actual outcome: \n" + martians.groupTeleport("Italy"));
	}
	
	//add 3 with one being green
	public static void testObliterateTeleporters_One() {
		System.out.println("\n-->testObliterateTeleporters_One()");
		RedMartian m1 = new RedMartian(4, 5);
		GreenMartian m2 = new GreenMartian(8, 4);
		RedMartian m3 = new RedMartian(1, 3);
		MartianManager martians = new MartianManager();
		martians.addMartian(m1);
		martians.addMartian(m2);
		martians.addMartian(m3);
		System.out.println("Before obliterateTeleporters(): \n" + martians);
		martians.obliterateTeleporters();
		System.out.println("After obliterateTeleporters(): \n" + martians);
	}
	
	//add 6 with 3 being green
	public static void testObliterateTeleporters_Many() {
		System.out.println("\n-->testObliterateTeleporters_Many()");
		RedMartian m1 = new RedMartian(4, 5);
		GreenMartian m2 = new GreenMartian(8, 4);
		GreenMartian m3 = new GreenMartian(1, 3);
		RedMartian m4 = new RedMartian(2, 77, 4);
		GreenMartian m5 = new GreenMartian(43, 7);
		RedMartian m6 = new RedMartian(12, 2);
		MartianManager martians = new MartianManager();
		martians.addMartian(m1);
		martians.addMartian(m2);
		martians.addMartian(m3);
		martians.addMartian(m4);
		martians.addMartian(m5);
		martians.addMartian(m6);
		System.out.println("Before obliterateTeleporters(): \n" + martians);
		martians.obliterateTeleporters();
		System.out.println("After obliterateTeleporters(): \n" + martians);
	}
	
	//add 2 reds and 2 greens, call an id that exists in a red
	public static void testRemoveMartianWithId_Success_Red() {
		System.out.println("\n-->testRemoveMartianWithId_Success_Red()");
		RedMartian m1 = new RedMartian(4, 5);
		GreenMartian m2 = new GreenMartian(8, 4);
		GreenMartian m3 = new GreenMartian(1, 3);
		RedMartian m4 = new RedMartian(2, 77, 4);
		MartianManager martians = new MartianManager();
		martians.addMartian(m1);
		martians.addMartian(m2);
		martians.addMartian(m3);
		martians.addMartian(m4);
		System.out.println("Expected outcome: Red Martian - id: 2, volume: 77, tenacity: 4");
		System.out.println("Actual outcome:   " + martians.removeMartian(3));
	}
	
	//add 2 reds and 2 greens, call an id that exists in a green
	public static void testRemoveMartianWithId_Success_Green() {
		System.out.println("\n-->testRemoveMartianWithId_Success_Green()");
		RedMartian m1 = new RedMartian(4, 5);
		GreenMartian m2 = new GreenMartian(8, 4);
		GreenMartian m3 = new GreenMartian(1, 3);
		RedMartian m4 = new RedMartian(2, 77, 4);
		MartianManager martians = new MartianManager();
		martians.addMartian(m1);
		martians.addMartian(m2);
		martians.addMartian(m3);
		martians.addMartian(m4);
		System.out.println("Expected outcome: Green Martian - id: 1, volume: 3");
		System.out.println("Actual outcome:   " + martians.removeMartian(2));
	}
	
	//add 4, call with an id that does not exist
	public static void testRemoveMartianWithId_Failure() {
		System.out.println("\n-->testRemoveMartianWithId_Failure()");
		RedMartian m1 = new RedMartian(4, 5);
		GreenMartian m2 = new GreenMartian(8, 4);
		GreenMartian m3 = new GreenMartian(1, 3);
		RedMartian m4 = new RedMartian(2, 77, 4);
		MartianManager martians = new MartianManager();
		martians.addMartian(m1);
		martians.addMartian(m2);
		martians.addMartian(m3);
		martians.addMartian(m4);
		System.out.println("Expected outcome: null");
		System.out.println("Actual outcome:   " + martians.removeMartian(4));
	}
	
	//add 2 reds and 2 greens, verify output
	public static void testToString() {
		System.out.println("\n-->testToString()");
		RedMartian m1 = new RedMartian(4, 5);
		GreenMartian m2 = new GreenMartian(8, 4);
		GreenMartian m3 = new GreenMartian(1, 3);
		RedMartian m4 = new RedMartian(2, 77, 4);
		MartianManager martians = new MartianManager();
		martians.addMartian(m1);
		martians.addMartian(m2);
		martians.addMartian(m3);
		martians.addMartian(m4);
		System.out.println(martians);
	}
	
	//3 martians, 1 invader, get a kill
	//3 martians, 1 invader, 0 kills
	//1 red invader, 1 green invader, 1 invader gets a kill but the other doesn't
	//5 martians, 3 invaders, 2 kills
	//2 martians, 2 invaders, both killed
	//2 martians, 3 invaders, both killed
	
	public static void testBattle_Small() {
		System.out.println("\n-->testBattle_Small()");
		ArrayList<Martian> invaders = new ArrayList<>();
		RedMartian m1 = new RedMartian(4, 5); // power: 6
		GreenMartian m2 = new GreenMartian(8, 4); // power: 4
		GreenMartian m3 = new GreenMartian(1, 5); // power: 5
		MartianManager martians = new MartianManager();
		martians.addMartian(m1);
		martians.addMartian(m2);
		invaders.add(m3);
		
		System.out.println(martians.battle(invaders));
	}
}
