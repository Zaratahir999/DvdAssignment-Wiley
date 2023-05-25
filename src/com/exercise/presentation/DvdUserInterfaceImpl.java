package com.exercise.presentation;

import java.util.LinkedList;
import java.util.Scanner;

import com.exercise.dto.Dvd;
import com.exercise.service.DvdBusinessLogic;
import com.exercise.service.DvdBusinessLogicImpl;


public class DvdUserInterfaceImpl implements DvdUserInterface {
	
	private DvdBusinessLogic businessLogic= new DvdBusinessLogicImpl();

	@Override
	public void showMenu() {
	System.out.println("Dvd Library Menu, choose a number :");
	System.out.println("====================================");
	System.out.println("1. Add DVD to collection");
	System.out.println("2. Remove DVD from collection");
	System.out.println("3. Edit DVD information");
	System.out.println("4. List DVDs in collection");
	System.out.println("5. Display information of particular DVD");
	System.out.println("6. Check if DVD is on list");
	System.out.println("7. Exit");	// TODO Auto-generated method stub

	}

	@Override
	public void performMenu(int choice) {
		Scanner scanner = new Scanner(System.in);

	switch (choice) {
	
	case 1:
	Dvd dvd = new Dvd(null, null, null, null, null, null);
	System.out.println("Enter Title : ");
	dvd.setTitle(scanner.next());
	System.out.println("Enter Release date : ");
	dvd.setReleaseDate(scanner.next());
	System.out.println("Enter MPAA rating : ");
	dvd.setMpaaRating(scanner.next());
	System.out.println("Enter Director's name : ");
	dvd.setDirectorsName(scanner.next());
	System.out.println("Enter Studio : ");
	dvd.setStudio(scanner.next());
	System.out.println("Enter user rating : ");
	dvd.setUserRating(scanner.next());
	
	boolean status=businessLogic.addDvd(dvd);
	
	if (status) {
		System.out.println("DVD has been added.");
}   else 
		System.out.println("Dvd has not been added.");
	break;
	
	
	case 2:
	    System.out.println("Enter DVD title whose record you want to delete:");
	    String delete = scanner.nextLine();
	    
	    if (businessLogic.deleteDvd(delete)) {
	        System.out.println("Record deleted.");
	    } else {
	        System.out.println("DVD with title '" + delete + "' does not exist.");
	    }
	    break;

	
	
	case 3: 
		System.out.println("Enter the title of the DVD you want to edit information:");
		String title2 = scanner.next();

		Dvd currentDvd = businessLogic.searchDvd(title2);

		if (currentDvd != null) {
		    System.out.println("Select the attribute you want to edit:");
		    System.out.println("1. Title");
		    System.out.println("2. Release date");
		    System.out.println("3. MPAA Rating");
		    System.out.println("4. Director's name");
		    System.out.println("5. Studio");
		    System.out.println("6. User Rating");
		    int choice2 = scanner.nextInt();
		    scanner.nextLine();

		    switch (choice2) {
		        case 1:
		            System.out.println("Enter updated title:");
		            String newTitle = scanner.nextLine();
		            currentDvd.setTitle(newTitle);
		            break;
		        case 2:
		            System.out.println("Enter updated release date:");
		            String newReleaseDate = scanner.nextLine();
		            currentDvd.setReleaseDate(newReleaseDate);
		            break;
		        case 3:
		            System.out.println("Enter updated MPAA rating:");
		            String newMpaaRating = scanner.nextLine();
		            currentDvd.setMpaaRating(newMpaaRating);
		            break;
		        case 4:
		            System.out.println("Enter updated director's name:");
		            String newDirector = scanner.nextLine();
		            currentDvd.setDirectorsName(newDirector);
		            break;
		        case 5:
		            System.out.println("Enter updated studio:");
		            String newStudio = scanner.nextLine();
		            currentDvd.setStudio(newStudio);
		            break;
		        case 6:
		            System.out.println("Enter updated user rating:");
		            String newUserRating = scanner.nextLine();
		            currentDvd.setUserRating(newUserRating);
		            break;
		        default:
		            System.out.println("Invalid choice.");
		            break;
		    }

		    boolean status2 = businessLogic.editDvd(title2, currentDvd);
		    if (status2) {
		        System.out.println("Information has been updated.");
		    } else {
		        System.out.println("Information could not be updated.");
		    }
		} else {
		    System.out.println("DVD does not exist.");
		}break;


	case 4:
		LinkedList<Dvd> dvds=businessLogic.getAllDvds();
		for(Dvd dvd1:dvds) {
			System.out.println(dvd1);}
		break;

	case 5:
		  System.out.println("Enter the DVD title you want to search for: ");
		    String search = scanner.nextLine();
		    
		    Dvd searchDvd = businessLogic.searchDvd(search);
		    
		    if (searchDvd != null) {
		    	System.out.println("Employee details for ID " + search + ":");
		        System.out.println(searchDvd);
		    } else {
		        System.out.println("Employee with ID " + search + " does not exist.");
		    }
		    break;
		    
	case 6:
	    System.out.println("Enter the title of the DVD you want to search:");
	    String title3 = scanner.nextLine();
	    boolean dvdExists;
	    try {
	        dvdExists = businessLogic.searchDvdList(title3);
	        if (dvdExists) {
	            System.out.println("Yes, the DVD is in the list.");
	        } else {
	            System.out.println("No, the DVD is not in the list.");
	        }
	    } catch (Exception e) {
	        System.out.println("An error occurred while searching for the DVD.");
	    }
	    break;

	    
	case 7: 
		System.out.println("Thanks for using the DVD Library");
		System.exit(0);
	default:
		System.out.println("Invalid choice");

		
		    }  
		} 


}
