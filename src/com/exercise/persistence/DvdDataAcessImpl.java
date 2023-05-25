package com.exercise.persistence;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Scanner;

import com.exercise.dto.Dvd;

public class DvdDataAcessImpl implements DvdDataAccess {

	@Override
	public boolean writeDvd(LinkedList<Dvd> dvds) throws Exception {
	    FileWriter fileWriter = new FileWriter("DvdsData"); // Corrected filename
	    PrintWriter printWriter = new PrintWriter(fileWriter);

	    for (Dvd dvd : dvds) {
	        String dvdData = dvd.getTitle() + "," + dvd.getReleaseDate() + "," + dvd.getMpaaRating() + ","
	                + dvd.getDirectorsName() + "," + dvd.getStudio() + "," + dvd.getUserRating();
	        printWriter.println(dvdData);
	    }

	    printWriter.flush();
	    printWriter.close();
	    fileWriter.close();
	    return true;
	}


    @Override
    public LinkedList<Dvd> readDvds() throws Exception {
    	
    	LinkedList<Dvd> dvds=new LinkedList<Dvd>();
		
		FileReader fileReader = new FileReader("DvdsData");

		// read the content from buffer
		BufferedReader bufferedReader = new BufferedReader(fileReader);

		Scanner scanner = new Scanner(bufferedReader);
		while (scanner.hasNext()) {
			String currentLine = scanner.nextLine();
		

			String values[]=currentLine.split(",");
			
			if (values.length == 6) {
	            Dvd dvd = new Dvd(values[0], values[1], values[2], values[3], values[4], values[5]);
	            dvds.add(dvd);
	        } else {
	            System.out.println("Invalid data format: " + currentLine);
	        }
	    }
		fileReader.close();
		bufferedReader.close();
		
		return dvds;
	}
    

}
