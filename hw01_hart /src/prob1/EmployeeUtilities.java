package prob1;

public class EmployeeUtilities {
	
	//empty constructor
	public EmployeeUtilities() {
		
	}
	
	public double getTotalPay(Employee[] emps) {
		double totalPay = 0;
		for(Employee e: emps) {
			totalPay += e.getPay();
		}
		return totalPay;
	}
	
	//return Employee with most hours in a week
	public Employee getEmployeeWithMostHours(Employee[] emps) {
		double max = 0;
		Employee maxEmp = null;
		for(Employee e: emps) {
			if(e.getPay() > max) {
				max = e.getPay();
				maxEmp = e;
			}
		}
		return maxEmp;
	}
	
	//return array with total hours for each Employee
	public double[] getHoursArray(Employee[] emps) {
		double[] hours = new double[emps.length];
		for(int i = 0; i < hours.length; i++) {
			hours[i] += emps[i].getTotalHours();
		}
		return hours;
	}
	
}