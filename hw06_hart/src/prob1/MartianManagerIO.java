package prob1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import prob2.*;


public class MartianManagerIO {

	/**
	 *  DO NOT ALTER THIS METHOD.
	 */
	public static void writeMartians(String fileName, MartianManager mm) {
		File file = new File(fileName);
        try {
			writeMartiansFile(file, mm);
		}
        catch (FileNotFoundException e) {
			System.out.println("Error writing file");
			e.printStackTrace();
		}
	}
	
	/**
	 *  YOU  WRITE THIS METHOD.
	 *  
	 *  Write the martians in the MartianManager to the file. The format is exactly the same
	 *  as specified in the homework document for reading valid data: G I V or R I V T.
	 */
	private static void writeMartiansFile(File file, MartianManager mm) throws FileNotFoundException {
		Martian m = null;
		try {
			FileWriter f = new FileWriter(file);
			for(int i = 0; i < mm.getNumMartians(); i++) {
				m = mm.getMartianAt(i);
				if(m instanceof GreenMartian) {
					GreenMartian gm = (GreenMartian)m;
					f.write("G ");
					f.write(gm.getId() + " ");
					f.write(gm.getVolume() + "\n");
				}
				else if(m instanceof RedMartian) {
					RedMartian rm = (RedMartian)m;
					f.write("R ");
					f.write(rm.getId() + " ");
					f.write(rm.getVolume() + " ");
					f.write(rm.getTenacity() + "\n");
				}
			}
			f.close();
		} catch (IOException e) {
			e.printStackTrace();
		}	
		}
	

	/**
	 *  DO NOT ALTER THIS METHOD.
	 */
	public static ReadReport readMartians(String fileName) {
		File file = new File(fileName);
		ReadReport report = null;
        try {
			report = readMartiansFile(file);
		}
        catch (FileNotFoundException e) {
			System.out.println("Error reading file");
			e.printStackTrace();
		}
		return report;
	}
	
	private static boolean isInteger(String s) {
		for(int i = 0; i < s.length(); i++) {
			if(!(Character.isDigit(s.charAt(i)))) {
				return false;
			}
		}
		return true;
	}
	/**
	 * YOU WRITE THIS METHOD.
	 * 
	 * Reads a text file that contains Martian data and returns a ReadReport object. Details
	 * are in the homework document. 
	 * 
	 * @param file
	 * @return
	 * @throws RuntimeException
	 * @throws FileNotFoundException
	 */
	private static ReadReport readMartiansFile(File file) throws RuntimeException, FileNotFoundException {
		int numSuccessfullyAdded = 0;
		int numAlreadyExist = 0;
		int numIllFormed = 0;
		
		MartianManager mm = new MartianManager();
		
		Scanner scan = new Scanner(file);
		while(scan.hasNextLine()) {
			String line = scan.nextLine();
			String[] vals = line.split(" ");
			//check if g
			if(vals[0].equals("G")) {
				if(vals.length == 3) {
					if(isInteger(vals[1])) {
						if(isInteger(vals[2])) {
							GreenMartian gm = new GreenMartian(Integer.parseInt(vals[1]), Integer.parseInt(vals[2]));
							if(mm.addMartian(gm)) {
								numSuccessfullyAdded++;
							}
							else if (!(mm.addMartian(gm))){
								numAlreadyExist++;
							}
						}
						else {
							numIllFormed++;
						}
					}
					else {
						numIllFormed++;
					}
				}
				else {
					numIllFormed++;
				}
			}
			
			//check if r
			else if(vals[0].equals("R")) {
				if(vals.length == 4) {
					if(isInteger(vals[1])) {
						if(isInteger(vals[2])) {
							if(isInteger(vals[3])) {
								RedMartian rm = new RedMartian(Integer.parseInt(vals[1]), Integer.parseInt(vals[2]), Integer.parseInt(vals[3]));
								if(mm.addMartian(rm)) {
									numSuccessfullyAdded++;
								}
								else if (!(mm.addMartian(rm))){
									numAlreadyExist++;
								}
							}
							else {
								numIllFormed++;
							}
						}
						else {
							numIllFormed++;
						}
					}
					else {
						numIllFormed++;
					}
				}
				else {
					numIllFormed++;
				}
			}
			
			else {
				numIllFormed++;
			}
			
		}
		
		
		int numLinesRead = numSuccessfullyAdded + numAlreadyExist + numIllFormed;
		ReadReport report = new ReadReport(mm, file.getName(), numLinesRead, numSuccessfullyAdded, numAlreadyExist, numIllFormed);

		return report;
	}

}
