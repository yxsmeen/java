package prob1;

public class Employee {
	private double[] hours = new double[7];
	private String name;
	private double payRate;
	
	//constructor	
	public Employee(String name, double payRate) {
		this.name = name;
		this.payRate = payRate;
	}
	
	//return num days worked in the week mon-sun
	public int getNumDaysWorked() {
		int numDaysWorked = 0;
		for(int i = 0; i < hours.length; i++) {
			if(hours[i] > 0) {
				numDaysWorked++;
			}
		}
		return numDaysWorked;
	}
	
	public String getName() {
		String n = name;
		return n;
	}
	
	//set hours worked on a given day
	public void setHours(int day, double hours) {
		this.hours[day] = hours;
	}
	
	//gets hours worked on a given day
	public double getHours(int day) {
		return hours[day];
	}
	
	//return total number of hours worked that week
	public double getTotalHours() {
		double totalHours = 0;
		for(int i = 0; i < hours.length; i++) {
			totalHours += hours[i];
		}
		return totalHours;
	}
	
	//return total number of hours worked mon - fri
	public double getWeekdayHours() {
		double weekdayHours = 0;
		for(int i = 0; i < 5; i++) {
			weekdayHours += hours[i];
		}
		return weekdayHours;
	}
	
	//return total number of hours worked sat & sun
	public double getWeekendHours() {
		double weekendHours = 0;
		for(int i = 5; i < hours.length; i++) {
			weekendHours += hours[i];
		}
		return weekendHours;
	}
	
	//restarts the week, enters 0 in each element of the array
	public void newWeek() {
		for(int i = 0; i < hours.length; i++) {
			hours[i] = 0;
		}
	}
	
	//add employee hours
	public void mergeEmployee(Employee e) {
		for(int i = 0; i < hours.length; i++) {
			this.hours[i] += e.hours[i];
		}
	}
	
	//returns pay at 1.5x over 40 hours on weekdays and 2x for any hours on weekends
	public double getPay() {
		double paid = 0;
		if(getWeekdayHours() <= 40) {
			paid += getWeekdayHours() * (payRate * 1);
		}
		if(getWeekdayHours() > 40) {
			double wkHours = getWeekdayHours() - 40;
			paid += 40 * (payRate * 1);
			paid += wkHours * (payRate * 1.5);
		}
		paid += getWeekendHours() * (payRate * 2);
		int days = getNumDaysWorked();
		if (days == 7) {
			paid += 50;
		}
		return paid;
	}

	//print pay stub (prints bisley instead of waldo?)
	public String toString() {
		String msg = String.format("Pay Stub"
				+ "\n--------"
				+ "\nName:%s, Pay Rate:$%,.2f"
				+ "\nHours:Mon:%.2f Tue:%.2f Wed:%.2f Thu:%.2f Fri:%.2f Sat:%.2f Sun:%.2f"
				+ "\nDays worked:%d, Total Hours:%.2f"
				+ "\nWeekday hours:%.2f, Weekend hours:%.2f"
				+ "\nTotal pay:$%,.2f", name, payRate, hours[0], hours[1], hours[2], hours[3], hours[4], hours[5], hours[6],
				getNumDaysWorked(), getTotalHours(), getWeekdayHours(), getWeekendHours(), getPay());
	return msg;
	}
	
}