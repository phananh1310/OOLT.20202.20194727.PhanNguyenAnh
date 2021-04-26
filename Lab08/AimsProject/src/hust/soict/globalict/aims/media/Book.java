package hust.soict.globalict.aims.media;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Book extends Media {

	private List<String> authors = new ArrayList<String>();
	private String content;
	private List<String> contentTokens = new ArrayList<String>();
	private Map<String, Integer> wordFrequency = new TreeMap<String,Integer>();
	
	public void processContent() {
		// regex = " " 
		String[] arr = content.split(" ");
		
		for (String s: arr) {
			while (!contentTokens.contains(s)) {
				contentTokens.add(s);
			}
			if (wordFrequency.containsKey(s)) {
				wordFrequency.put(s, wordFrequency.get(s)+1);
			}
			else {
				wordFrequency.put(s,1);
			}
		}
		Collections.sort(contentTokens);
		
		

	}
	public void setContent(String newContent) {
		this.content = newContent;
		this.processContent();
	}
	
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
	// display with content
	public void display() {

		System.out.println("Book - " + this.getTitle()+" - " + this.getCategory()+ ": "+ this.getCost()+"$"+"(id="+this.getId()+")"+"(dateAdded="+this.getDateAdded()+")");
		System.out.print("Authors: ");
		for (String author: authors) {
			System.out.print(author+" | ");
		}
		System.out.println();
		System.out.println("Content: "+content);
		System.out.println("Content Tokens: "+contentTokens);
		System.out.println("Word Frequency: "+ wordFrequency);

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
