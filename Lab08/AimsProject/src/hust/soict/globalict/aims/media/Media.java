package hust.soict.globalict.aims.media;

import java.time.LocalDate;
import java.util.Comparator;

public abstract class Media implements Comparable<Media> {
	private static int nbMedia = 0;
	private int id;
	private String title;
	private String category;
	private float cost;
	private LocalDate dateAdded; 
	
	public static final Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparatorByTitleCost();
	public static final Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitle();

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
	
	public void displayMedia() {
		
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
	
	public void display() {		
	}
	public boolean search(String title2) {
		return false;
	}
	public int getLength() {
		return 0;
	}
	public void addAuthor(String string) {		
	}
	public void removeAuthor(String string) {
	}
	public void play() {
		
	}
	public void setCost(float x){
		this.cost=x;
	}
	public void addTrack(Track track) {
		
	}
	@Override
	public boolean equals(Object media) {
		if (media instanceof Media) {
		return (this.id==((Media)media).getId());
		}
		else return false;
	}
	 
	@Override
	public int compareTo(Media o) {
		int r=this.getTitle().compareTo(o.getTitle());
		if (r==0) 
			return this.getCategory().compareTo(o.getCategory());
		else 
			return r;
	}
	


}
