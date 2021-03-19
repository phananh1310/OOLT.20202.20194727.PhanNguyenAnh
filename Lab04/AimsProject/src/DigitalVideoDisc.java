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
	
	public DigitalVideoDisc() {
		super();
	}

	public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
		super();
		this.title = title;
		this.category = category;
		this.director = director;
		this.length = length;
		this.cost = cost;
	}
	public DigitalVideoDisc(String title) {
		super();
		this.title = title;
	}
	public DigitalVideoDisc(String title, String category, float cost) {
		super();
		this.title = title;
		this.category = category;
		this.cost = cost;
	}
	public DigitalVideoDisc(String title, String category, String director, float cost) {
		super();
		this.title = title;
		this.category = category;
		this.director = director;
		this.cost = cost;
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
	
	public void displayDVD() {
		System.out.println("Title: " + this.getTitle());
		System.out.println("Category: " + this.getCategory());
		System.out.println("Director: " + this.getDirector());
		System.out.println("Length: " + this.getLength());
		System.out.println("Cost: " + this.getCost());
	}
}
