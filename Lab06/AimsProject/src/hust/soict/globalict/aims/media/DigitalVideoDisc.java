package hust.soict.globalict.aims.media;
import java.time.LocalDate;

/*
  If you create a constructor method to build a DVD by title,
 then create a constructor method to build a DVD by category.
 Does Java allow you to do it?
 
  Yes java allow to do it. Each will have its own default attributes except the one
 you put in (title or category).
 
 */

public class DigitalVideoDisc extends Media {
	
	private String director;
	private int length;
	private LocalDate dateAdded; 

	
	public DigitalVideoDisc() {
		super();
	}

	public DigitalVideoDisc(String title, String category, String director, int length, float cost, LocalDate date) {
		super(title,category,cost,date);
		this.director = director;
		this.length = length;
		this.dateAdded = date;
	}
	
	public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
		super(title,category,cost);
		this.director = director;
		this.length = length;	
		this.dateAdded = LocalDate.now();
	}

	public DigitalVideoDisc(String title) {
		super(title);
		this.dateAdded = LocalDate.now();
	}

	
	public String getDirector() {
		return director;
	}
	public int getLength() {
		return length;
	}
	public LocalDate getDateAdded() {
		return dateAdded;
	}

	
// I use this instead of getDetail(). I think return type of getDetail is String. Change all object information in that dvd into string and then return
// I also print id and date for detail
	public void display() {
		System.out.println("DVD - " + this.getTitle()+" - " + this.getCategory()+" - "+ this.getDirector()+" - " + this.getLength()+": "+ this.getCost()+"$"+"(id="+this.getId()+")"+"(dateAdded="+this.getDateAdded()+")");
	}

	// create setter to swap
	

	public void setDirector(String director) {
		this.director = director;
	}

	public void setLength(int length) {
		this.length = length;
	}

	

	public boolean search(String title) {
		String[] arr = title.split(" ");    

		for ( String word : arr) {
			if(this.getTitle().toLowerCase().contains(word.toLowerCase())) {
				return true;
			}
		}
		
		return false;
	}
	
	
	
}
