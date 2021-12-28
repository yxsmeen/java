package prob1;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;

public class CodeComparator implements Comparator<Product>{
	
	public CodeComparator() {}
	
	public String getLetters(Product o) {
		return o.getCode().substring(0,2);
	}
	
	public String getNums(Product o) {
		return o.getCode().substring(2);
	}

//	@Override
//	public int compare(Product o1, Product o2) {
//		int diff = getLetters(o1).compareTo(getLetters(o2));
//		if(diff != 0) {
//			return diff;
//		}
//		else {
//			return getNums(o1).compareTo(getNums(o2));
//		}
//	}
	
	@Override
	public int compare(Product o1, Product o2) {
		int diff = getLetters(o1).compareTo(getLetters(o2));
		if((getLetters(o1).equals("QC")) || (getLetters(o2).equals("QC"))) {
			if(diff != 0) {
				return diff;
			}
			else {
				return getNums(o1).compareTo(getNums(o2));
			}
		}
		else{
			if(diff != 0) {
				return diff;
			}
			else {
				return getNums(o1).compareTo(getNums(o2));
			}
	
		}
	}
	
}
