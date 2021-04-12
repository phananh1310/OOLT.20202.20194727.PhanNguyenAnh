package hust.soict.globalict.aims;

import java.util.ArrayList;

import hust.soict.globalict.aims.media.DigitalVideoDisc;
import hust.soict.globalict.aims.media.Media;

public class Store {
	private ArrayList<Media> itemsOrdered = new ArrayList<Media> ();
	private int Medianumber=0;
	
	public Store() {
		super();
	}
	
	public void addMediatoStore(Media media) {
	
			itemsOrdered.add(media);
			Medianumber += 1;
	}
	
	public void addListMediatoStore(Media [] medias) {
		for(Media item : medias) {
			this.addMediatoStore(item);
		}
	}
	
	public void removeDVDfromStore(Media media) {
		if(Medianumber <= 0) {
			System.out.println("Store is empty!");
		}
		else {
			Medianumber -= 1;
			int index= itemsOrdered.indexOf(media);
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
		if (Medianumber >0) {
			System.out.println("**********************STORE******************************************************************************************************");
			for(Media item : itemsOrdered) {
				System.out.print(i+". ");
				i++;
				System.out.println("Media - "+item.getTitle()+" (id = "+item.getId()+")");
			}
			System.out.println("****************************************************************************************************************************");
		
		}
		else {
			System.out.println("Store is empty!");
		}
	}
	public Media searchStorebyID(int ID) {
		for(Media item : itemsOrdered) {
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

