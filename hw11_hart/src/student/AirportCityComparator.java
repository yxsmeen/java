package student;

import java.util.Comparator;

public class AirportCityComparator implements Comparator<Airport> {
	public AirportCityComparator() {
		
	}
	public int compare(Airport a1, Airport a2) {
		int diffC = a1.getCity().compareTo(a2.getCity());
		if(diffC != 0) {
			return diffC;
		}else {
			int diffS = a1.getState().compareTo(a2.getState());
			return diffS;
		}
	}
}
