package hust.soict.globalict.aims.media;

import java.time.LocalDate;

public class Disc extends Media {
	private String director;
	private int length;
	
	public Disc(String title, String category, String director, int length, float cost, LocalDate date) throws IllegalArgumentException {
		super(title,category,cost,date);
		if (length >0) {
		this.director = director;
		this.length = length;}
		else {
			throw new IllegalArgumentException("ERROR: Length is less than 0");
		}
	}
	
	public Disc(String title, String category, String director, int length, float cost) throws IllegalArgumentException {
		super(title,category,cost);
		if (length >0) {
		this.director = director;
		this.length = length;}
		else {
			throw new IllegalArgumentException("ERROR: Length is less than 0");
		}
	}
	public Disc(String title, String category, String director, float cost) throws IllegalArgumentException {
		super(title,category,cost);
		this.director = director;
	}
	
	public Disc() {
		super();// check here
	}
	public Disc(String title) {
		super(title);// check here
	}
	
	
	public String getDirector() {
		return director;
	}
	public int getLength() {
		return length;
	}

	

}
