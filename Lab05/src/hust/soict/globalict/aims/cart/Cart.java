package hust.soict.globalict.aims.cart;
import java.util.*;
import hust.soict.globalict.aims.disc.DigitalVideoDisc;

public class Cart {
	
	private int qtyOrdered;
	public static final int MAX_NUMBERS_ORDERED = 20;
	private ArrayList<DigitalVideoDisc> itemsOrdered = new ArrayList<DigitalVideoDisc> ();
	
	public Cart() {
		super();
	}
	
	public void addDigitalVideoDisc(DigitalVideoDisc disc) {
		if(qtyOrdered >=MAX_NUMBERS_ORDERED) {
			System.out.println("Your cart is full!");
		}
		else {
			itemsOrdered.add(disc);
			qtyOrdered += 1;
			System.out.println("This DVD has been added to your Cart!");
			if (qtyOrdered >= 18) {
				System.out.println("Your cart is almost full!");
			}
		}
	}
	
	public void addDigitalVideoDisc(DigitalVideoDisc [] dvdList) {
		for(DigitalVideoDisc item : dvdList) {
			this.addDigitalVideoDisc(item);
		}
	}
	
	public void addDigitalVideoDisc(DigitalVideoDisc dvd1,DigitalVideoDisc dvd2) {
		this.addDigitalVideoDisc(dvd1);
		this.addDigitalVideoDisc(dvd2);
	}
	
	public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
		if(qtyOrdered <= 0) {
			System.out.println("Your cart is empty!");
		}
		else {
			qtyOrdered -= 1;
			int index= itemsOrdered.indexOf(disc);
			if (index==-1) {
				System.out.println("No DVD found to be removed!");
			}
			else {
				System.out.println("DVD '"+disc.getTitle()+"'"+" has been removed from your Cart!");
				itemsOrdered.remove(index);
			}
			
		}
	}
	public DigitalVideoDisc DVD(int rm) { 
		return itemsOrdered.get(rm); // take the rm th element of the list
	}
	public float totalCost() {
		float cost = 0;
		for(DigitalVideoDisc item : itemsOrdered) {
			cost += item.getCost();
		}
		return cost;
	}
	public int getQtyOrdered() {
		return qtyOrdered;
	}
	public void displayCart() {
		int i=1;
		float cost = 0;
		if (qtyOrdered >0) {
			System.out.println("**********************CART******************************************************************************************************");
			for(DigitalVideoDisc item : itemsOrdered) {
				cost += item.getCost();
				System.out.print(i+". ");
				i++;
				item.displayDVD();
			}
			System.out.println("****************************************************************************************************************************");
			System.out.println("Total Cost: "+cost+"$");
		}
		else {
			System.out.println("Your cart is NULL!");
		}
	}
	
	public void sortCartbyCost() {
		
		Collections.sort(itemsOrdered, new DVDCostComparator());
		this.displayCart();
	}
	public void sortCartbyTitle() {
		
		Collections.sort(itemsOrdered, new DVDTitleComparator());
		this.displayCart();
	}
	public void sortCart() {
		Collections.sort(itemsOrdered, new DVDComparator());
		this.displayCart();
	}
	
	public DigitalVideoDisc searchCartbyID(int ID) {
		for(DigitalVideoDisc item : itemsOrdered) {
			if (item.getId()==ID) return item;
		}
		return null;// not found
	}
	public void SearchIDandDisplay(int ID) {
		DigitalVideoDisc dvd = this.searchCartbyID(ID);
		if (dvd == null ) {
			System.out.println("Not found!");
		}
		else {
			System.out.println("DVD found:");
			dvd.displayDVD();
		}
	}
	
}



