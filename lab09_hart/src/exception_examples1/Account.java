package exception_examples1;

public class Account {
	private double balance;
	
	public Account(double balance) {
		if(balance < 0.0) {
			throw new IllegalArgumentException("Balance must be greater than 0.0");
		}
		this.balance = balance;
	}
	
	public String toString() {
		return String.format("Balance: " + balance);
	}
	
	public static void main(String[] args) {
		Account a;
		double balance = -10.2;
		try {
			System.out.println("Trying new account");
			a = new Account(balance);
			System.out.println("Account created");
			System.out.println(a);
		}
		catch(RuntimeException e) {
			System.out.println("Account not created, enter a balance greater than 0.0");
		}
		
	}
}
