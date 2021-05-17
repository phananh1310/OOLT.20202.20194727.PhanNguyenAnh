package hust.soict.globalict.aims.media;

import java.time.LocalDate;

public class Disc extends Media {
	private String director;
	private int length;
	
	public Disc(String title, String category, String director, int length, float cost, LocalDate date) {
		super(title,category,cost,date);
		this.director = director;
		this.length = length;
	}
	
	public Disc(String title, String category, String director, int length, float cost) {
		super(title,category,cost);
		this.director = director;
		this.length = length;
	}
	public Disc(String title, String category, String director, float cost) {
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
