package prob1;

import emps.Employee;

public class StoreTest {

	public static void main(String[] args) {
		testAddEmp_Add_1();
		testAddEmp_Add_3();
		testAddEmp_Add_20();
		testAddEmp_Add_21();
		testGetEmp_5_Emps_Loc_Minus_2();
		testGetEmp_5_Emps_Loc_0();
		testGetEmp_5_Emps_Loc_2();
		testGetEmp_5_Emps_Loc_4();
		testGetEmp_5_Emps_Loc_5();
		testGetTotalHours_3_Employees();
		testGetTotalPay_3_Employees();
		testRemoveEmployee_With_5_Employees_Loc_Minus_2();
		testRemoveEmployee_With_5_Employees_Loc_0();
		testRemoveEmployee_With_5_Employees_Loc_2();
		testRemoveEmployee_With_5_Employees_Loc_4();
		testRemoveEmployee_With_5_Employees_Loc_5();
		testRemoveEmployee_With_20_Employees_Loc_19();
		testGetEmployeeWithName_Found();
		testGetEmployeeWithName_NotFound();
		testToString();
	}
	
	public static void testAddEmp_Add_1() {
		System.out.println("-->testAddEmp_Add_1"); 
		Store s = new Store();
		Employee e1 = createTestEmployee("Will", 23.0);
		System.out.print("Num emps before add:" + s.getNumEmployees()); 
		s.addEmployee(e1);
		System.out.println(", Num emps after add: expected= 1, actual= " + + s.getNumEmployees()); 
	}
	
	public static void testAddEmp_Add_3() {
		System.out.println("\n-->testAddEmp_Add_3"); 
		Store s = new Store();
		System.out.print("Num emps before add:" + s.getNumEmployees()); 
		s = createStoreWith3Employees();
		System.out.println(", Num emps after add: expected= 3, actual= " + + s.getNumEmployees()); 
	}
	
	public static void testAddEmp_Add_20() {
		System.out.println("\n-->testAddEmp_Add_20"); 
		Store s = new Store();
		System.out.print("Num emps before add:" + s.getNumEmployees()); 
		s = createStoreWith20Employees();
		System.out.println(", Num emps after add: expected= 20, actual= " + + s.getNumEmployees()); 
	}

	public static void testAddEmp_Add_21() {
		System.out.println("\n-->testAddEmp_Add_21_Emps"); 
		Store s = new Store();
		System.out.print("Num emps before add:" + s.getNumEmployees()); 
		s = createStoreWith20Employees();
		Employee e = createTestEmployee("Nance", 23.0);
		s.addEmployee(e);
		System.out.println(", Num emps after add: expected= 20, actual= " + + s.getNumEmployees()); 
	}

	public static void testGetEmp_5_Emps_Loc_Minus_2() {
		System.out.println("\n-->testGetEmp_5_Emps_Loc_Minus_2"); 
		Store s = StoreTest.createStoreWith5Employees();
		int loc=-2;
		String expected = "null";
		Employee e=s.getEmployee(loc);
		String msg = "5 emps, getEmp(" + loc + "): expected= " + expected +", actual= ";
		msg += getGetEmployeeMessage(e);
		System.out.println(e);
	}
	
	public static void testGetEmp_5_Emps_Loc_0() {
		System.out.println("\n-->testGetEmp_5_Emps_Loc_0"); 
		Store s = StoreTest.createStoreWith5Employees();
		int loc = 0;
		String expected = "Amanda";
		Employee e = s.getEmployee(loc);
		String msg = "5 emps, getEmp(" + loc + "): expected= " + expected +", actual= ";
		System.out.println(msg + e.getName());
	}

	public static void testGetEmp_5_Emps_Loc_2() {
		System.out.println("\n-->testGetEmp_5_Emps_Loc_2"); 
		Store s = StoreTest.createStoreWith5Employees();
		int loc = 2;
		String expected = "Lexi";
		Employee e = s.getEmployee(loc);
		String msg = "5 emps, getEmp(" + loc + "): expected= " + expected +", actual= ";
		System.out.println(msg + e.getName());
	}

	public static void testGetEmp_5_Emps_Loc_4() {
		System.out.println("\n-->testGetEmp_5_Emps_Loc_4"); 
		Store s = StoreTest.createStoreWith5Employees();
		int loc = 4;
		String expected = "Steven";
		Employee e = s.getEmployee(loc);
		String msg = "5 emps, getEmp(" + loc + "): expected= " + expected +", actual= ";
		System.out.println(msg + e.getName());
	}

	public static void testGetEmp_5_Emps_Loc_5() {
		System.out.println("\n-->testGetEmp_5_Emps_Loc_5"); 
		Store s = StoreTest.createStoreWith5Employees();
		int loc = 5;
		String expected = "null";
		Employee e = s.getEmployee(loc);
		String msg = "5 emps, getEmp(" + loc + "): expected= " + expected +", actual= ";
		System.out.println(msg + e);
	}

	public static void testGetTotalHours_3_Employees() {
		System.out.println("\n-->testGetTotalHours_3_Employees"); 
		Store s = StoreTest.createStoreWith3Employees();
		System.out.println("expected= 100.0, actual= " + s.getTotalHours());
	}
	
	public static void testGetTotalPay_3_Employees() {
		System.out.println("\n-->testGetTotalPay_3_Employees"); 
		Store s = StoreTest.createStoreWith3Employees();
		System.out.println("expected= 1200.0, actual= " + s.getTotalPay());
	}
	
	public static void testRemoveEmployee_With_5_Employees_Loc_Minus_2() {
		System.out.println("\n-->testRemoveEmployee_With_5_Employees_Loc_Minus_2");
		Store s = StoreTest.createStoreWith5Employees();
		Employee e;
		int loc = -2;
		int expectedNumEmps = 5;
		String expectedEmpName = "null";
		e = s.removeEmployee(loc);
		String msg = String.format("5 emps, after removeEmployee(%d):\n", loc);
		msg += String.format("num emps: expected= %d, actual= %d\n", expectedNumEmps, s.getNumEmployees());
		String actualEmpName = e==null ? "null" : e.getName();
		msg += String.format("emp name: expected= %s, actual= %s", expectedEmpName, actualEmpName);
		System.out.println(msg);
	}
	
	public static void testRemoveEmployee_With_5_Employees_Loc_0() {
		System.out.println("\n-->testRemoveEmployee_With_5_Employees_Loc_0");
		Store s = StoreTest.createStoreWith5Employees();
		Employee e;
		int loc = 0;
		int expectedNumEmps = 4;
		String expectedEmpName = "Amanda";
		e = s.removeEmployee(loc);
		String msg = String.format("5 emps, after removeEmployee(%d):\n", loc);
		msg += String.format("num emps: expected= %d, actual= %d\n", expectedNumEmps, s.getNumEmployees());
		String actualEmpName = e==null ? "null" : e.getName();
		msg += String.format("emp name: expected= %s, actual= %s", expectedEmpName, actualEmpName);
		System.out.println(msg);
	}

	public static void testRemoveEmployee_With_5_Employees_Loc_2() {
		System.out.println("\n-->testRemoveEmployee_With_5_Employees_Loc_2");
		Store s = StoreTest.createStoreWith5Employees();
		Employee e;
		int loc = 2;
		int expectedNumEmps = 4;
		String expectedEmpName = "Lexi";
		e = s.removeEmployee(loc);
		String msg = String.format("5 emps, after removeEmployee(%d):\n", loc);
		msg += String.format("num emps: expected= %d, actual= %d\n", expectedNumEmps, s.getNumEmployees());
		String actualEmpName = e==null ? "null" : e.getName();
		msg += String.format("emp name: expected= %s, actual= %s", expectedEmpName, actualEmpName);
		System.out.println(msg);
	}

	public static void testRemoveEmployee_With_5_Employees_Loc_4() {
		System.out.println("\n-->testRemoveEmployee_With_5_Employees_Loc_4");
		Store s = StoreTest.createStoreWith5Employees();
		Employee e;
		int loc = 4;
		int expectedNumEmps = 4;
		String expectedEmpName = "Steven";
		e = s.removeEmployee(loc);
		String msg = String.format("5 emps, after removeEmployee(%d):\n", loc);
		msg += String.format("num emps: expected= %d, actual= %d\n", expectedNumEmps, s.getNumEmployees());
		String actualEmpName = e==null ? "null" : e.getName();
		msg += String.format("emp name: expected= %s, actual= %s", expectedEmpName, actualEmpName);
		System.out.println(msg);
	}

	public static void testRemoveEmployee_With_5_Employees_Loc_5() {
		System.out.println("\n-->testRemoveEmployee_With_5_Employees_Loc_5");
		Store s = StoreTest.createStoreWith5Employees();
		Employee e;
		int loc = 5;
		int expectedNumEmps = 5;
		String expectedEmpName = "null";
		e = s.removeEmployee(loc);
		String msg = String.format("5 emps, after removeEmployee(%d):\n", loc);
		msg += String.format("num emps: expected= %d, actual= %d\n", expectedNumEmps, s.getNumEmployees());
		String actualEmpName = e==null ? "null" : e.getName();
		msg += String.format("emp name: expected= %s, actual= %s", expectedEmpName, actualEmpName);
		System.out.println(msg);
	}

	public static void testRemoveEmployee_With_20_Employees_Loc_19() {
		System.out.println("\n-->testRemoveEmployee_With_20_Employees_Loc_19");
		Store s = StoreTest.createStoreWith20Employees();
		Employee e;
		int loc = 19;
		int expectedNumEmps = 19;
		String expectedEmpName = "Tyrone";
		e = s.removeEmployee(loc);
		String msg = String.format("5 emps, after removeEmployee(%d):\n", loc);
		msg += String.format("num emps: expected= %d, actual= %d\n", expectedNumEmps, s.getNumEmployees());
		String actualEmpName = e==null ? "null" : e.getName();
		msg += String.format("emp name: expected= %s, actual= %s", expectedEmpName, actualEmpName);
		System.out.println(msg);
	}

	public static void testGetEmployeeWithName_Found() {
		System.out.println("\n-->testGetEmployeeWithName_Found");
		Store s = createStoreWith5Employees();
		
		String searchFor = "Ben";
		String expectedEmpName = "Ben";
		Employee e = s.getEmployeeWithName(searchFor);

		String actualEmpName = e==null ? "null" : e.getName();
		String msg = String.format("getEmployeeWithName(%s): expected= %s, actual= %s", searchFor, expectedEmpName, actualEmpName);
		System.out.println(msg);
	}

	public static void testGetEmployeeWithName_NotFound() {
		System.out.println("\n-->testGetEmployeeWithName_NotFound");
		Store s = createStoreWith5Employees();
		
		String searchFor = "Kynan";
		String expectedEmpName = "null";
		Employee e = s.getEmployeeWithName(searchFor);

		String actualEmpName = e==null ? "null" : e.getName();
		String msg = String.format("getEmployeeWithName(%s): expected= %s, actual= %s", searchFor, expectedEmpName, actualEmpName);
		System.out.println(msg);
	}

	public static void testToString() {
		System.out.println("\n-->testToString");
		Store s = createStoreWith3Employees();
		System.out.print(s);
	}

	//---------------------------------
	// Helper methods below
	//---------------------------------
	
	/*
	 *  Creates and returns a Store with 3 employees. Hours can be changed to simplify
	 *  if needed by modifying the hours array.
	 */
	public static Store createStoreWith3Employees() {
		Store store = new Store();
		double[] hours = {8,8,8,8,8,0,0};
		Employee e1 = new Employee("Amanda", 10.0);
		for(int x = 0; x < hours.length; x++) {
			e1.setHours(x, hours[x]);
		}
		store.addEmployee(e1);
		
		double[] hours2 = {0,0,8,8,8,8,8};
		Employee e2 = new Employee("Jorge", 10.0);
		for(int x = 0; x < hours2.length; x++) {
			e2.setHours(x, hours2[x]);
		}
		store.addEmployee(e2);

		double[] hours3 = {5,5,0,5,0,5,0};
		Employee e3 = new Employee("Lexi", 20.0);
		for(int x = 0; x < hours3.length; x++) {
			e3.setHours(x, hours3[x]);
		}
		store.addEmployee(e3);
		return store;
	}

	/*
	 *  Creates and returns a Store with 5 employees. The first 3 come from
	 *  the createStoreWith3Employees() method.
	 */
	public static Store createStoreWith5Employees() {
		Store store = createStoreWith3Employees();
		
		double[] hours = {8,8,8,8,8,0,0};
		Employee e1 = new Employee("Ben", 10.0);
		for(int x = 0; x < hours.length; x++) {
			e1.setHours(x, hours[x]);
		}
		store.addEmployee(e1);
		
		double[] hours2 = {10,10,10,10,10,8,8};
		Employee e2 = new Employee("Steven", 10.0);
		for(int x = 0; x < hours2.length; x++) {
			e2.setHours(x, hours2[x]);
		}
		store.addEmployee(e2);
		return store;
	}

	/*
	 *  Creates and returns a Store with 20 employees.
	 */
	public static Store createStoreWith20Employees() {
		Store store = new Store();
		store.addEmployee(createTestEmployee("Amanda", 10.0));
		store.addEmployee(createTestEmployee("Bill", 10.0));
		store.addEmployee(createTestEmployee("Christina", 10.0));
		store.addEmployee(createTestEmployee("David", 10.0));
		store.addEmployee(createTestEmployee("Edith", 10.0));
		store.addEmployee(createTestEmployee("Fernando", 10.0));
		store.addEmployee(createTestEmployee("Genesis", 10.0));
		store.addEmployee(createTestEmployee("Harry", 10.0));
		store.addEmployee(createTestEmployee("Irene", 10.0));
		store.addEmployee(createTestEmployee("Jason", 10.0));
		store.addEmployee(createTestEmployee("Kelly", 10.0));
		store.addEmployee(createTestEmployee("Louis", 10.0));
		store.addEmployee(createTestEmployee("Maria", 10.0));
		store.addEmployee(createTestEmployee("Newton", 10.0));
		store.addEmployee(createTestEmployee("Olivia", 10.0));
		store.addEmployee(createTestEmployee("Perry", 10.0));
		store.addEmployee(createTestEmployee("Quistis", 10.0));
		store.addEmployee(createTestEmployee("Randal", 10.0));
		store.addEmployee(createTestEmployee("Sarah", 10.0));
		store.addEmployee(createTestEmployee("Tyrone", 10.0));
		return store;
	}
	
	/*
	 * Creates an Employee object with an input name and pay rate, 
	 * with a work week of 5 hours every weekday.
	 */	
	private static Employee createTestEmployee(String name, double rate) {
		Employee e1 = new Employee(name, rate);
		for(int x = 0; x < 5; x++) {
			e1.setHours(x, 5);
		}
		return e1;
	}
	
	// Helper method
	private static String getGetEmployeeMessage(Employee e) {
	       if(e==null) {
	             return ""+e;  // prints: null
	       }
	       else {
	             return e.getName();
	       }
	}
}
