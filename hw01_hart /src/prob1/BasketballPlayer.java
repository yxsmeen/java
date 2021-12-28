package prob1;

public class BasketballPlayer {
	private int freeThrowsAttempted;
	private int freeThrowsMade;
	private String name;
	private int threePointersAttempted;
	private int threePointersMade;
	private int twoPointersAttempted;
	private int twoPointersMade;
	
	//constructor
	public BasketballPlayer(String name){
		this.name = name;
	}
	
//free throw methods
	public void shootFreeThrow(boolean isMade) {
		freeThrowsAttempted++;
		if(isMade == true) {
			freeThrowsMade++;
		}
	}
	
	//returns num of free throws made
	public int getFreeThrowsMade() {
		int freeThrowsMade = this.freeThrowsMade;
		return freeThrowsMade;
	}
	
	//returns num of free throws attempted
	public int getFreeThrowsAttempted() {
		int freeThrowsAttempted = this.freeThrowsAttempted;
		return freeThrowsAttempted;
	}
	
	//returns the percent of free throws made
	public double getFreeThrowPercent() {
		if(freeThrowsAttempted > 0) {
			double percent = 100.0 * freeThrowsMade/freeThrowsAttempted;
			return percent;
		}
		else {
			return 0;
		}
	}
	
//two pointer methods
	public void shootTwoPointer(boolean isMade) {
		twoPointersAttempted++;
		if(isMade == true) {
			twoPointersMade++;
		}
	}
	
	//returns num of two pointers made
	public int getTwoPointersMade() {
		int twoPointersMade = this.twoPointersMade;
		return twoPointersMade;
	}
	
	//returns num of two pointers attempted
	public int getTwoPointersAttempted() {
		int twoPointersAttempted = this.twoPointersAttempted;
		return twoPointersAttempted;
	}
	
	//returns the percent of two pointers made
	public double getTwoPointerPercent() {
		if(twoPointersAttempted > 0) {
			double percent = 100.0 * twoPointersMade / twoPointersAttempted;
			return percent;
		}
		else {
			return 0;
		}
	}
	
//three pointer methods
	public void shootThreePointer(boolean isMade) {
		threePointersAttempted++;
		if(isMade == true) {
			threePointersMade++;
		}
	}
	
	//returns num of three pointers made
	public int getThreePointersMade() {
		int threePointersMade = this.threePointersMade;
		return threePointersMade;
	}
	
	//returns num of of three pointers attempted
	public int getThreePointersAttempted() {
		int threePointersAttempted = this.threePointersAttempted;
		return threePointersAttempted;
	}
	
	//returns the percent of three pointers made
	public double getThreePointerPercent() {
		if(threePointersAttempted > 0) {
			double percent = 100.0 * threePointersMade / threePointersAttempted;
			return percent;
		}
		else {
			return 0;
		}
	}
	
//returns total points
	public int getTotalPoints() {
		int totalPoints = 1 * freeThrowsMade + 2 * twoPointersMade + 3 * threePointersMade;
		return totalPoints;
	}
//to string method
	public String toString() {
		String msg = "Player:" + name + ", points:" + getTotalPoints() + 
					"\n   Free Throws: made: " + freeThrowsMade + ", attempted: " + freeThrowsAttempted + ", percent: " + (Math.round(getFreeThrowPercent() * 10.0 )/ 10.0) + 
					"\n    2 Pointers: made: " + twoPointersMade + ", attempted: " + twoPointersAttempted + ", percent: " + (Math.round(getTwoPointerPercent() * 10.0 )/ 10.0) +
					"\nThree Pointers: made: " + threePointersMade + ", attempted: " + threePointersAttempted + ", percent: " + (Math.round(getThreePointerPercent() * 10.0 )/ 10.0);
		return msg;
	}
}