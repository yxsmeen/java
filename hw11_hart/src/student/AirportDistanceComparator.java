package student;

import java.util.Comparator;

public class AirportDistanceComparator implements Comparator<Double>{
	public AirportDistanceComparator() {
		
	}
	
	@Override
	public int compare(Double d1, Double d2) {
		if(d1 > d2) {
			return 1;
		}else if(d1 < d2) {
			return -1;
		}else {
			return 0;
		}
	}

}
