package hust.soict.globalict.aims.cart;
import java.util.*;

import javax.naming.LimitExceededException;

import hust.soict.globalict.aims.exception.LuckyItemException;
import hust.soict.globalict.aims.media.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Cart {
	
	private ObservableList<Media> itemsOrdered = FXCollections.observableArrayList();
	public static final int MAX_NUMBERS_ORDERED = 20;
	
	public ObservableList<Media> getItemsOrdered() {
		return itemsOrdered;
	}

	public Cart() {
		super();
	}
	
	public void addMedia(Media media) throws LimitExceededException {
		if (itemsOrdered.size()<MAX_NUMBERS_ORDERED) {
			itemsOrdered.add(media);
		}
		else {
			throw new LimitExceededException("ERROR: The number of media has reached its limit");
		}
	}
	public void removeMedia(int id) throws NoSuchElementException,LimitExceededException {
		if (itemsOrdered.size()==0) {
			throw new LimitExceededException("Your cart is empty!");
		}
		else {
			for (Media item: itemsOrdered) {
				if (item.getId()==id) {
					itemsOrdered.remove(item);
					return;
				}
			}
			throw new NoSuchElementException("Can't find that item!");
		}
	}
	
	public void addMedia(Media [] List) throws LimitExceededException {
		for(Media item : List) {
			this.addMedia(item);
		}
	}
	
	public void addMedia(Media media1,Media media2) throws LimitExceededException {
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
	
	// another way to sort using comparator of Media
	public void sortCartByTitleCost() {
		Collections.sort(this.itemsOrdered, Media.COMPARE_BY_TITLE_COST);
		this.displayCart();
	}
	public void sortCartByCostTitle() {
		Collections.sort(this.itemsOrdered, Media.COMPARE_BY_COST_TITLE);
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


	

	public void getALuckyItem() throws LuckyItemException{
		// this list contain index of valid lucky item in itemsOrdered
		ArrayList<Integer> validItem = new ArrayList<Integer>();

		// get cost of min_value item
		double minCost = Double.MAX_VALUE;
		for(Media item : itemsOrdered) {
			if (item.getCost()<minCost) 
				minCost = item.getCost();
		}
		
		// define threshold
		
		final double priceThreshold = 100;
		final double numOfItemsThreshold = 6;
		final double maxLuckyItemPrice = 30;
		double luckyItemPriceThreshold = (this.totalCost()/priceThreshold) * minCost  ;
		
		if (luckyItemPriceThreshold>maxLuckyItemPrice)
			luckyItemPriceThreshold = maxLuckyItemPrice;
		
		for(Media item : itemsOrdered) {
			if (item.getCost()<=luckyItemPriceThreshold) 
				validItem.add(itemsOrdered.indexOf(item));
		}

		if (this.getQtyOrdered()>numOfItemsThreshold&&this.totalCost()>priceThreshold) {
		
        int rand = (int)(Math.random() * validItem.size()) + 0;
        itemsOrdered.get(validItem.get(rand)).setCost(0);
		}
		else if (this.getQtyOrdered()<=numOfItemsThreshold)
			throw new LuckyItemException("Number of Items not reach Threshold to get a lucky Item!");
		else if (this.totalCost()<=priceThreshold)
			throw new LuckyItemException("Total Cost not reach Threshold to get a lucky Item!");
		
    }
	public int getQtyOrdered() {
		return itemsOrdered.size();
	}
		
	}
	




