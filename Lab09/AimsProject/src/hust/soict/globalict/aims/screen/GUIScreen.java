package hust.soict.globalict.aims.screen;

import java.util.ArrayList;
import java.util.List;

import hust.soict.globalict.aims.Store;
import hust.soict.globalict.aims.cart.Cart;
import hust.soict.globalict.aims.media.Book;
import hust.soict.globalict.aims.media.CompactDisc;
import hust.soict.globalict.aims.media.DigitalVideoDisc;
import hust.soict.globalict.aims.media.Media;
import hust.soict.globalict.aims.media.Track;

public class GUIScreen {
	public Cart cart = new Cart();
	public static void main(String[] args) {
		Store store = new Store();

		//Add video to store
		Media dvd1 = new DigitalVideoDisc("Harry P","aaaa","aaaa",1,5.6f);
		Media dvd2 = new DigitalVideoDisc("H Potter ","bbbb","aaaa",1,5.3f);
		Media dvd3 = new DigitalVideoDisc("Your NameHary","cccc","aaaa",2,5.3f);
		Media dvd4 = new DigitalVideoDisc("Harry P","dddd","aaaa",1,7.1f);
		Media dvd5 = new DigitalVideoDisc("EEEE","eeee","aaaa",1,3.3f);
		Media dvd6 = new DigitalVideoDisc("EEEE","eeee","aaaa",1,3.3f);
		Media dvd7 = new DigitalVideoDisc("EEEE","eeee","aaaa",1,3.3f);
		Media cd = new CompactDisc("EEEE","eeee","aaaa","NA",3.3f);
		Track track = new Track("Track1",5);
		cd.addTrack(track);
		track = new Track("Track2",8);cd.addTrack(track);

		List<String> authors = new ArrayList<String>();
		Media book1 = new Book("Phan Anh","abc", 1.6f,authors);
		book1.addAuthor("Phan Anh");
		book1.setContent("d d as  l asds ahs as ue  da ad");
		
		store.addListMediatoStore(new Media [] {dvd1,dvd2,dvd3,dvd4,dvd5,dvd6,dvd7,cd});
		
		store.addMediatoStore(book1);
		
		new StoreScreen(store);
	}
}
