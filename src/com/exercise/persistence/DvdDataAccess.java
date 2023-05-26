package com.exercise.persistence;

import java.util.LinkedList;

import com.exercise.dto.Dvd;

public interface DvdDataAccess {

	public boolean writeDvd(LinkedList<Dvd>dvd) throws Exception ;
	public LinkedList<Dvd> readDvds()throws Exception ;
}
