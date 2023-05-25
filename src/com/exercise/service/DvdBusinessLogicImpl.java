package com.exercise.service;

import java.util.LinkedList;

import com.exercise.dto.Dvd;
import com.exercise.persistence.DvdDataAccess;
import com.exercise.persistence.DvdDataAcessImpl;

public class DvdBusinessLogicImpl implements DvdBusinessLogic {
	
	private DvdDataAccess dataAccess = new DvdDataAcessImpl();
	
	private LinkedList<Dvd> dvdList;
	
	public DvdBusinessLogicImpl() {
	    try {
	        dvdList = dataAccess.readDvds();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}

	@Override
	public LinkedList<Dvd> getAllDvds() {
		// TODO Auto-generated method stub
		return dvdList;
	}

	@Override
	public boolean addDvd(Dvd dvd) {
		// TODO Auto-generated method stub
		return dvdList.add(dvd);
	}

	@Override
	public boolean deleteDvd(String title) {
		for(Dvd dvd:dvdList) {
			if(title.equals(dvd.getTitle()))
				return dvdList.remove(dvd);
		}
		return false;
	}

	@Override
	public void saveAllDvds() throws Exception {
		dataAccess.writeDvd(dvdList);


	}

	@Override
	public Dvd searchDvd(String title) {
		for (Dvd dvd : dvdList) {
			if(title.equals(dvd.getTitle()))
				return dvd;
		}
		return null;
	}
	
	@Override
	public boolean editDvd(String title, Dvd updatedDvd) {
	    for (Dvd dvd : dvdList) {
	        if (title.equals(dvd.getTitle())) {
	        	dvd.setTitle(updatedDvd.getTitle());
	            dvd.setReleaseDate(updatedDvd.getReleaseDate());
	            dvd.setMpaaRating(updatedDvd.getMpaaRating());
	            dvd.setDirectorsName(updatedDvd.getDirectorsName());
	            dvd.setStudio(updatedDvd.getStudio());
	            dvd.setUserRating(updatedDvd.getUserRating());
	            return true;
	        }
	    }
	    return false;
	} 
	@Override
	public boolean searchDvdList(String title) throws Exception {
	    LinkedList<Dvd> dvds = dataAccess.readDvds();
	    for (Dvd dvd : dvds) {
	        if (dvd.getTitle().equalsIgnoreCase(title)) {
	            return true; 
	        }
	    }
	    return false;
	}

	

		
	}
	
	
	

