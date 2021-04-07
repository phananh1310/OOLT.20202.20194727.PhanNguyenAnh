package hust.soict.globalict.aims.media;

import java.time.LocalDate;

public class Media {
	private static int nbMedia = 0;
	private int id;
	private String title;
	private String category;
	private float cost;
	private LocalDate dateAdded; 

	public Media() {
		super();
		nbMedia += 1;
		this.id = nbMedia;
		this.dateAdded = LocalDate.now();
	}
	public Media(String title) {
		super();
		this.title = title;
		nbMedia += 1;
		this.id = nbMedia;
		this.dateAdded = LocalDate.now();
	}
	

	public Media(String title, String category, float cost) {
		super();
		this.title = title;
		this.category = category;
		this.cost = cost;
		nbMedia += 1;
		this.id = nbMedia;
		this.dateAdded = LocalDate.now();
	}


	public Media(String title, String category, float cost, LocalDate dateAdded) {
		super();
		this.title = title;
		this.category = category;
		this.cost = cost;
		this.dateAdded = dateAdded;
		nbMedia += 1;
		this.id = nbMedia;
	}


	public static int getNbMedia() {
		return nbMedia;
	}

	public int getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getCategory() {
		return category;
	}

	public float getCost() {
		return cost;
	}

	public LocalDate getDateAdded() {
		return dateAdded;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public void setCost(float cost) {
		this.cost = cost;
	}
	public void setDateAdded(LocalDate dateAdded) {
		this.dateAdded = dateAdded;
	}
	

}
