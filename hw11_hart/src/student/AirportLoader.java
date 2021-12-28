package student;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

public class AirportLoader {
	public AirportLoader() {
	
	}
	
	public static Map<String, Airport> getAirportMap(File airportFile){
		Map<String, Airport> airportMap = new HashMap<String, Airport>();
		BufferedReader br = null;
		
		try {
			br = new BufferedReader(new FileReader(airportFile));
			String line = null;
			
			while((line = br.readLine()) != null) {
				String[] bits = line.split("\t");
				
				String code = bits[0];
				String lat = bits[1];
				double latitude = Double.parseDouble(lat);
				String lon = bits[2];
				double longitude = Double.parseDouble(lon);
				String city = bits[3];
				String state = bits[4];
				Airport ap = new Airport(code, latitude, longitude, city, state);
				
				if(!code.equals("") && !ap.equals(null)) {
					airportMap.put(code, ap);
				}
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			if(br != null) {
				try {
					br.close();
				}
				catch(Exception e) {
					
				};
			}
		}
		return airportMap;
	}
}
