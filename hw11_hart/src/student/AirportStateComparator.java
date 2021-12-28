package student;

import java.util.Comparator;

public class AirportStateComparator implements Comparator<Airport>{
	public AirportStateComparator() {
			
	}
	public int compare(Airport a1, Airport a2) {
		int diffS = a1.getState().compareTo(a2.getState());
		if(diffS != 0) {
			return diffS;
		}else {
			int diffC = a1.getCity().compareTo(a2.getCity());
			return diffC;
		}
	}
}
