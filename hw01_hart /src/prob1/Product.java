package prob1;

public class Product {
	private int batch;
	private String code;
	private String date;
	private String plant;
	
	//constructor
	public Product(String code) {
		this.code = code;
		if(Character.isDigit(code.charAt(2)) == true) {
			plant = code.substring(0,2);
			date = code.substring(2,10);
			batch = Integer.valueOf(code.substring(10));
		}
		else if (Character.isDigit(code.charAt(2)) == false) {
			plant = code.substring(0,3);
			date = code.substring(3,11);
			batch = Integer.valueOf(code.substring(11));
		}
	}
	
	//gets batch
	public int getBatch() {
		int b = batch;
		return b;
	}
	
	//gets code
	public String getCode() {
		String c = code;
		return c;
	}
	
	//gets date
	public String getDate() {
		String d = date;
		return d;
	}
	
	//gets plant
	public String getPlant() {
		String p = plant;
		return p;
	}
	
	//returns true if the date is greater than or equal to 2000, false if otherwise
	public boolean isAfter2000() {
		boolean isAfter2k;
		int year = Integer.valueOf(date.substring(4));
		if(year >= 2000) {
			isAfter2k = true;
		}
		else {
			isAfter2k = false;
		}
		return isAfter2k;
	}
	
	//returns true if the month the product was produced is equal to the input month
	public boolean isMonthEqual(int month) {
		boolean monthIsEqual;
		int mth = Integer.valueOf(date.substring(0,2));
		if(mth == month) {
			monthIsEqual = true;
		}
		else {
			monthIsEqual = false;
		}
		return monthIsEqual;
	}
	
	//returns string
	public String toString() {
		String str = "code=" + code + ", plant=" + plant + ", date=" + date.substring(0,2)
		+ "/" + date.substring(2,4) + "/" + date.substring(4) + ", batch=" + batch;
		return str;
	}
}
