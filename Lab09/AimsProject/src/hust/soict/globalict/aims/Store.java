package hust.soict.globalict.aims;

import java.util.ArrayList;

import hust.soict.globalict.aims.media.Media;

public class Store {
	private ArrayList<Media> itemsInStore = new ArrayList<Media> ();
	private int Medianumber=0;
	
	public Store() {
		super();
	}
	
	public ArrayList<Media> getItemsInStore(){
		return itemsInStore;
	}
	
	public void addMediatoStore(Media media) {
	
			itemsInStore.add(media);
			Medianumber += 1;
	}
	
	public void addListMediatoStore(Media [] medias) {
		for(Media item : medias) {
			this.addMediatoStore(item);
		}
	}
	
	public void removeMediafromStore(Media media) {
		if(Medianumber <= 0) {
			System.out.println("Store is empty!");
		}
		else {
			Medianumber -= 1;
			int index= itemsInStore.indexOf(media);
			if (index==-1) {
				System.out.println("No Media found to be removed from Store!");
			}
			else {
				itemsInStore.remove(index);
			}
			
		}
	}
	public void displayStore() {
		int i=1;
		if (Medianumber >0) {
			System.out.println("**********************STORE******************************************************************************************************");
			for(Media item : itemsInStore) {
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
		for(Media item : itemsInStore) {
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
	System.out.println("1. See a Media’s details");
	System.out.println("2. Add a Media to cart");
	System.out.println("3. See current cart");
	System.out.println("4. Play Media");
	System.out.println("5. Exit");
	System.out.println("--------------------------------");
	System.out.print("Please choose a number: 1-2-3-4: ");
	}
	public static void cartMenu() {
	System.out.println("Options: ");
	System.out.println("--------------------------------");
	System.out.println("1. Filter Medias in cart");
	System.out.println("2. Sort Medias in cart");
	System.out.println("3. Remove Media from cart");
	System.out.println("4. Get a lucky item from cart");
	System.out.println("5. Place order");
	System.out.println("6. Exit");
	System.out.println("--------------------------------");
	System.out.print("Please choose a number: 1-2-3-4-5-6: ");
	}
}

