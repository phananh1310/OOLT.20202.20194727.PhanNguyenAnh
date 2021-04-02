package hust.soict.globalict.aims.disc;
import java.time.LocalDate;

/*
  If you create a constructor method to build a DVD by title,
 then create a constructor method to build a DVD by category.
 Does Java allow you to do it?
 
  Yes java allow to do it. Each will have its own default attributes except the one
 you put in (title or category).
 
 */

public class DigitalVideoDisc {
	private String title;
	private String category;
	private String director;
	private int length;
	private float cost;
	private LocalDate dateAdded; 
	private static int nbDigitalVideoDiscs = 0;
	private int id;
	
	public DigitalVideoDisc() {
		super();
	}

	public DigitalVideoDisc(String title, String category, String director, int length, float cost, LocalDate date) {
		super();
		this.title = title;
		this.category = category;
		this.director = director;
		this.length = length;
		this.cost = cost;
		this.dateAdded = date;
		nbDigitalVideoDiscs+=1;
		this.id= nbDigitalVideoDiscs;
	}
	
	public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
		super();
		this.title = title;
		this.category = category;
		this.director = director;
		this.length = length;
		this.cost = cost;
		nbDigitalVideoDiscs+=1;
		this.id= nbDigitalVideoDiscs;
		this.dateAdded = LocalDate.now();
	}

	public DigitalVideoDisc(String title) {
		super();
		this.title = title;
		nbDigitalVideoDiscs+=1;
		this.id= nbDigitalVideoDiscs;
		this.dateAdded = LocalDate.now();
	}

	public String getTitle() {
		return title;
	}
	public String getCategory() {
		return category;
	}
	public String getDirector() {
		return director;
	}
	public int getLength() {
		return length;
	}
	public float getCost() {
		return cost;
	}
	public LocalDate getDateAdded() {
		return dateAdded;
	}
	public static int getNbDigitalVideoDiscs() {
		return nbDigitalVideoDiscs;
	}
	
	public int getId() {
		return id;
	}
// I use this instead of getDetail(). I think return type of getDetail is String. Change all object information in that dvd into string and then return
// I also print id and date for detail
	public void displayDVD() {
		System.out.println("DVD - " + this.getTitle()+" - " + this.getCategory()+" - "+ this.getDirector()+" - " + this.getLength()+": "+ this.getCost()+"$"+"(id="+this.getId()+")"+"(dateAdded="+this.getDateAdded()+")");
	}

	// create setter to swap
	public void setTitle(String title) {
		this.title = title;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public void setCost(float cost) {
		this.cost = cost;
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
