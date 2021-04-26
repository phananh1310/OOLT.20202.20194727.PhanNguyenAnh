package hust.soict.globalict.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book extends Media implements Comparable<Book> {

	private List<String> authors = new ArrayList<String>();
	
	public Book() {
		super();
	}

	public Book(String title, String category, float cost, List<String> authors) {
		super(title,category,cost);
		this.authors=authors;
	}
	
	public List<String> getAuthors() {
		return authors;
	}

	public void setAuthors(ArrayList<String> authors) {
		this.authors = authors;
	}
	
	public void addAuthor(String authorName) {
		if (authors.contains(authorName)) {
			System.out.println("This author is already in the list!");
		}
		else {
			authors.add(authorName);
			System.out.println("This author's been added to the list!");
		}
	}
	public void removeAuthor(String authorName) {
		if (authors.contains(authorName)) {
			authors.remove(authorName);
			System.out.println("Author is removed!");
		}
		else {
			System.out.println("This author is not in the list!");
		}
	}
	public void display() {

		System.out.println("Book - " + this.getTitle()+" - " + this.getCategory()+ ": "+ this.getCost()+"$"+"(id="+this.getId()+")"+"(dateAdded="+this.getDateAdded()+")");
		System.out.print("Authors: ");
		for (String author: authors) {
			System.out.print(author+" | ");
		}
		System.out.println();
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

	@Override
	public int compareTo(Book o) {
		int r=this.getTitle().compareTo(o.getTitle());
		if (r==0) 
			return this.getCategory().compareTo(o.getCategory());
		else 
			return r;
	}
	
	

}
