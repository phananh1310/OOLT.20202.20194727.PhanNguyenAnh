package hust.soict.globalict.aims.cart;
import java.util.*;
import hust.soict.globalict.aims.media.*;

public class Cart {
	
	private ArrayList<Media> itemsOrdered = new ArrayList<Media>();
	public static final int MAX_NUMBERS_ORDERED = 20;
	public Cart() {
		super();
	}
	
	public void addMedia(Media media) {
		if (itemsOrdered.size()<MAX_NUMBERS_ORDERED) {
			itemsOrdered.add(media);
		}
		else {
			System.out.println("Your cart is full!");
		}
	}
	public void removeMedia(int id) {
		if (itemsOrdered.size()==0) {
			System.out.println("Your cart is empty!");
		}
		else {
			for (Media item: itemsOrdered) {
				if (item.getId()==id) {
					itemsOrdered.remove(item);
					return;
				}
			}
			System.out.println("Can't find that item!");
		}
	}
	
	public void addMedia(Media [] List) {
		for(Media item : List) {
			this.addMedia(item);
		}
	}
	
	public void addMedia(Media media1,Media media2) {
		this.addMedia(media1);
		this.addMedia(media2);
	}
	
	public Media DVD(int rm) { 
		return itemsOrdered.get(rm); // take the rm th element of the list
	}
	public float totalCost() {
		float cost = 0;
		for(Media item : itemsOrdered) {
			cost += item.getCost();
		}
		return cost;
	}
	
	
	public void displayCart() {
		int i=1;
		float cost = 0;
		if (itemsOrdered.size() >0) {
			System.out.println("**********************CART******************************************************************************************************");
			for(Media item : itemsOrdered) {
				cost += item.getCost();
				System.out.print(i+". ");
				i++;
				item.display();
			}
			System.out.println("****************************************************************************************************************************");
			System.out.println("Total Cost: "+cost+"$");
		}
		else {
			System.out.println("Your cart is NULL!");
		}
	}
	
	public void sortCartbyCost() {
		
		Collections.sort(this.itemsOrdered, new DVDCostComparator());
		this.displayCart();
	}
	public void sortCartbyTitle() {
		
		Collections.sort(this.itemsOrdered, new DVDTitleComparator());
		this.displayCart();
	}
	public void sortCart() {
		Collections.sort(this.itemsOrdered, new DVDComparator());
		this.displayCart();
	}
	
	public Media searchCartbyID(int ID) {
		for(Media item : itemsOrdered) {
			if (item.getId()==ID) return item;
		}
		return null;// not found
	}
	public void SearchIDandDisplay(int ID) {
		Media dvd = this.searchCartbyID(ID);
		if (dvd == null ) {
			System.out.println("Not found!");
		}
		else {
			System.out.println("DVD found:");
			dvd.display();
		}
	}
	
	public void SearchAndDisplay_CartbyTitle(String title) {
		int count=0;
		System.out.println("Result:");
			for(Media item : itemsOrdered) {
				if (item.search(title)) {
					item.display();
					count++;
				}
					
			}
			if (count==0) System.out.println("Not found");
			else System.out.println("Found "+count+" DVD");
		}
	
	public void getALuckyItem() {
        int rand = (int)(Math.random() * (itemsOrdered.size()+1)) + 0;
        itemsOrdered.get(rand).setCost(0);
    }
	public int getQtyOrdered() {
		return itemsOrdered.size();
	}
		
	}
	




