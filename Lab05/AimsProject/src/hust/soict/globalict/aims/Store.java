package hust.soict.globalict.aims;

import java.util.ArrayList;

import hust.soict.globalict.aims.disc.DigitalVideoDisc;

public class Store {
	private ArrayList<DigitalVideoDisc> itemsOrdered = new ArrayList<DigitalVideoDisc> ();
	private int DVDnumber=0;
	
	public Store() {
		super();
	}
	
	public void addDVDtoStore(DigitalVideoDisc disc) {
	
			itemsOrdered.add(disc);
			DVDnumber += 1;
	}
	
	public void addListDVDtoStore(DigitalVideoDisc [] dvdList) {
		for(DigitalVideoDisc item : dvdList) {
			this.addDVDtoStore(item);
		}
	}
	
	public void removeDVDfromStore(DigitalVideoDisc disc) {
		if(DVDnumber <= 0) {
			System.out.println("Store is empty!");
		}
		else {
			DVDnumber -= 1;
			int index= itemsOrdered.indexOf(disc);
			if (index==-1) {
				System.out.println("No DVD found to be removed from Store!");
			}
			else {
				itemsOrdered.remove(index);
			}
			
		}
	}
	public void displayStore() {
		int i=1;
		if (DVDnumber >0) {
			System.out.println("**********************STORE******************************************************************************************************");
			for(DigitalVideoDisc item : itemsOrdered) {
				System.out.print(i+". ");
				i++;
				System.out.println("DVD - "+item.getTitle()+" (id = "+item.getId()+")");
			}
			System.out.println("****************************************************************************************************************************");
		
		}
		else {
			System.out.println("Store is empty!");
		}
	}
	public DigitalVideoDisc searchStorebyID(int ID) {
		for(DigitalVideoDisc item : itemsOrdered) {
			if (item.getId()==ID) return item;
		}
		return null;// not found
	}
	public static void ShowMenu() {
		System.out.println("AIMS: ");
		System.out.println("--------------------------------");
		System.out.println("1. View store");
		System.out.println("2. Update store");
		System.out.println("3. See current cart");
		System.out.println("4. Exit");
		System.out.println("--------------------------------");
		System.out.print("Please choose a number: 1-2-3-4: ");
		
	}
	public static void storeMenu() {
	System.out.println("Options: ");
	System.out.println("--------------------------------");
	System.out.println("1. See a DVD’s details");
	System.out.println("2. Add a DVDto cart");
	System.out.println("3. See current cart");
	System.out.println("4. Exit");
	System.out.println("--------------------------------");
	System.out.print("Please choose anumber: 1-2-3-4: ");
	}
	public static void cartMenu() {
	System.out.println("Options: ");
	System.out.println("--------------------------------");
	System.out.println("1. Filter DVDs in cart");
	System.out.println("2. Sort DVDs in cart");
	System.out.println("3. Remove DVD from cart");
	System.out.println("4. Place order");
	System.out.println("5. Exit");
	System.out.println("--------------------------------");
	System.out.print("Please choose a number: 1-2-3-4-5: ");
	}
}

