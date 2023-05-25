package com.exercise.service;

import java.util.LinkedList;

import com.exercise.dto.Dvd;

public interface DvdBusinessLogic {
	LinkedList<Dvd>getAllDvds();
	boolean addDvd (Dvd dvd);
	boolean deleteDvd (String title);
	boolean editDvd (String title, Dvd updatedDvd);
	public void saveAllDvds() throws Exception;
	Dvd searchDvd(String title);
	boolean searchDvdList (String title)throws Exception;
	

}
