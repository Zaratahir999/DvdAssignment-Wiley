package com.exercise.dto;

public class Dvd {
	
	private String title;
	private String releaseDate;
	private String mpaaRating;
	private String directorsName;
	private String studio;
	private String userRating;
	
	
	public Dvd(String title, String releaseDate, String mpaaRating, String directorsName, String studio,
			String userRating) {
		super();
		this.title = title;
		this.releaseDate = releaseDate;
		this.mpaaRating = mpaaRating;
		this.directorsName = directorsName;
		this.studio = studio;
		this.userRating = userRating;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getReleaseDate() {
		return releaseDate;
	}


	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}


	public String getMpaaRating() {
		return mpaaRating;
	}


	public void setMpaaRating(String mpaaRating) {
		this.mpaaRating = mpaaRating;
	}


	public String getDirectorsName() {
		return directorsName;
	}


	public void setDirectorsName(String directorsName) {
		this.directorsName = directorsName;
	}


	public String getStudio() {
		return studio;
	}


	public void setStudio(String studio) {
		this.studio = studio;
	}


	public String getUserRating() {
		return userRating;
	}


	public void setUserRating(String userRating) {
		this.userRating = userRating;
	}


	@Override
	public String toString() {
		return "Dvd [title=" + title + ", releaseDate=" + releaseDate + ", mpaaRating=" + mpaaRating
				+ ", directorsName=" + directorsName + ", studio=" + studio + ", userRating=" + userRating + "]";

	
	}
	 
	
	     }
    

