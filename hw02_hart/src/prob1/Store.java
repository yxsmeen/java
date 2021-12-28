package prob1;

import emps.Employee;

public class Store {
	//only two instance variables, documentation calls for three
	private Employee[] emps = new Employee[20];
	private int numEmps;
	
	public Store() {
		numEmps = 0;
	}
	
	public int getNumEmployees() {
		return numEmps;
	}
	
	public void addEmployee(Employee e) {
		if(numEmps < 20) {
			emps[numEmps] = e;
			numEmps++;
		}
	}
	
	public Employee getEmployee(int i) {
		Employee e = null;
		if((0 <= i) && (i < numEmps)) {
			e = emps[i];
		}
		return e;
	}
	
	public double getTotalHours() {
		double total = 0;
		for(int i = 0; i < numEmps; i++) {
			total += emps[i].getTotalHours();
		}
		return total;
	}
	
	public double getTotalPay() {
		double total = 0;
		for(int i = 0; i < numEmps; i++) {
			total += emps[i].getTotalHours() * emps[i].getPayRate();
		}
		return total;
	}
	
	public Employee getEmployeeWithName(String findName) {
		Employee e = null;
		for(int i = 0; i < numEmps; i++) {
			if(emps[i].getName().equals(findName)) {
				e = emps[i];
			}
		}
		return e;
	}
	
	public String toString() {
		String msg = String.format("Number of Employees: %d, Total hours: %.2f, Total pay: %.2f",
				getNumEmployees(), getTotalHours(), getTotalPay());
		return msg;
	}
	
	public Employee removeEmployee(int i) {
		Employee e = null;
		if((0 <= i) && (i < numEmps)) {
			e = emps[i];
			for(int j = i + 1; j < numEmps; j++) {
				emps[j - 1] = emps[j];
			}
			numEmps--;
			return e;
		}
		return null;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Employee e = new Employee("Will", 22.33);
	}

}
